import pandas as pd
import numpy as np
import os
import re
import matplotlib.pyplot as plt

# === FILE/FOLDER LOCATIONS ===
ROOT = "E:/Validation"

TRANSIENT_MODELS = {
    "URANS": os.path.join(ROOT, "URANS"),
    "DES":   os.path.join(ROOT, "DES"),
    "LES":   os.path.join(ROOT, "LES"),
}

STEADY_FILES_MM = {
    "Realizable k-ε":      os.path.join(ROOT, "real_keps.csv"),
    "k-ε Lag EB":          os.path.join(ROOT, "lagEB.csv"),
    "k-ω SST (a₁=0.31)":   os.path.join(ROOT, "komegasst_031.csv"),
    "k-ω SST (a₁=1.0)":    os.path.join(ROOT, "komegasst_100.csv"),
}

EXPERIMENT_CSV = os.path.join(ROOT, "Experiment.csv")

# === 1. LOAD EXPERIMENTAL DATA ===
exp_df = pd.read_csv(EXPERIMENT_CSV)
exp_df['X (m)'] = exp_df['X (mm)'] / 1000
exp_df['Y (m)'] = exp_df['Y (mm)'] / 1000
exp_df['Z (m)'] = exp_df['Z (mm)'] / 1000
exp_df = exp_df.rename(columns={
    'Pressure': 'Pressure_Exp',
    'std':      'Std_Exp'        # <-- keep your time-series std
})
exp_df = exp_df[['X (m)','Y (m)','Z (m)','Pressure_Exp','Std_Exp']]


# === 2. LOAD STEADY RANS MODELS ===
model_dfs = {}
for name,path in STEADY_FILES_MM.items():
    df = pd.read_csv(path)
    df['X (m)'] = df['X (mm)']/1000
    df['Y (m)'] = df['Y (mm)']/1000
    df['Z (m)'] = df['Z (mm)']/1000
    df = df.rename(columns={'Total Pressure (Pa)':f'Pressure_{name}'})
    model_dfs[name] = df[['X (m)','Y (m)','Z (m)',f'Pressure_{name}']]

# === 3. LOAD & AVERAGE TRANSIENT MODELS ===
def load_transient(folder, model_name):
    pattern = r"Validation_table_([0-9.eE+-]+)\.csv"
    frames = []
    for fn in os.listdir(folder):
        m = re.match(pattern, fn)
        if not m: continue
        df = pd.read_csv(os.path.join(folder, fn))
        df = df[['X (m)','Y (m)','Z (m)','Total Pressure (Pa)']]
        df['Time'] = float(m.group(1))
        frames.append(df)
    allf = pd.concat(frames, ignore_index=True)
    avg = (
        allf
        .groupby(['X (m)', 'Y (m)', 'Z (m)'])
        .agg(Pressure=('Total Pressure (Pa)', 'mean'),
             Std=('Total Pressure (Pa)', 'std'))
        .reset_index()
    )
    avg = avg.rename(columns={
        'Pressure': f'Pressure_{model_name}',
        'Std':      f'{model_name}_Std'
    })
    return avg

for name, folder in TRANSIENT_MODELS.items():
    model_dfs[name] = load_transient(folder, name)

# === 4. ROUND & MERGE EVERYTHING ===
for df in model_dfs.values():
    for c in ['X (m)','Y (m)','Z (m)']:
        df[c] = df[c].round(5)
for c in ['X (m)','Y (m)','Z (m)']:
    exp_df[c] = exp_df[c].round(5)

merged = exp_df.copy()
for name, df in model_dfs.items():
    merged = pd.merge(
        merged, df,
        on=['X (m)', 'Y (m)', 'Z (m)'],
        how='inner'
    )
# now merged has Pressure_Exp, Std_Exp, and all your model pressures.


# === 5. COMPUTE ERRORS & %ERRORS ===
for name in model_dfs:
    merged[f'{name}_Err'] = merged[f'Pressure_{name}'] - merged['Pressure_Exp']
    merged[f'{name}_RelErr%'] = (merged[f'{name}_Err'].abs() / merged['Pressure_Exp'].abs()) * 100

# === 6. REGION-BASED METRICS ===
regions = {
    "Rear wing": lambda df: np.isclose(df['X (m)'], 0.25, atol=1e-3),
    "Tire wake": lambda df: np.isclose(df['X (m)'], 1.225, atol=1e-3),
    "Middle":    lambda df: df['X (m)'] > 2.0
}

print("\n--- REGION-WISE RELATIVE ERRORS (%) ---")
for region, mask_fn in regions.items():
    sub = merged[mask_fn(merged)]
    print(f"\n>> {region} ({len(sub)} points)")
    for name in model_dfs:
        relerr = sub[f'{name}_RelErr%'].abs()
        mae = relerr.mean()
        rmse = np.sqrt((relerr ** 2).mean())
        print(f"   {name:20s}  MAE%: {mae:6.2f}%   RMSE%: {rmse:6.2f}%")

# === 7. PLOTTING FUNCTION ===
def plot_group(df, fix_ax, fix_val, var_ax, models, title, show_bands=None):
    if show_bands is None:
        show_bands = []

    sel = df[np.isclose(df[fix_ax], fix_val, atol=1e-3)]
    if sel.empty:
        print(f"No data at {fix_ax}={fix_val}")
        return

    # Group to get the mean Pressure_Exp and the mean Std_Exp at each probe
    grp = sel.groupby(var_ax).agg({
        'Pressure_Exp': 'mean',
        'Std_Exp':      'mean',
        **{f'Pressure_{m}': 'mean' for m in models},
        **{f'{m}_Std': 'mean' for m in models if f'{m}_Std' in sel}
    }).reset_index()

    x = grp[var_ax].values
    y_exp = grp['Pressure_Exp'].values
    s_exp = grp['Std_Exp'].values

    plt.figure(figsize=(7, 6))

    # 1) Experimental line
    plt.plot(x, y_exp, '--k', label='Experimental', linewidth=1.5)
    plt.scatter(x, y_exp, c='k', s=30)

    # Experimental band
    if 'Exp' in show_bands:
        plt.fill_between(
            x,
            y_exp - s_exp,
            y_exp + s_exp,
            color='gray',
            alpha=0.3,
        )

    # 2) Simulation models
    color_map = {
        'LES': 'red', 'DES': 'blue', 'URANS': 'green',
        "Realizable k-ε": '#9467bd', "k-ε Lag EB": '#ff7f0e',
        "k-ω SST (a₁=0.31)": '#8c564b', "k-ω SST (a₁=1.0)": '#17becf'
    }

    for name in models:
        y_mod = grp[f'Pressure_{name}']
        c = color_map.get(name, 'gray')
        plt.plot(x, y_mod, '-', color=c, linewidth=1.5, label=name)

        # LES or other models if allowed in show_bands
        std_col = f'{name}_Std'
        if name in show_bands and std_col in grp:
            plt.fill_between(
                x,
                y_mod - grp[std_col],
                y_mod + grp[std_col],
                color=c,
                alpha=0.25
            )

    plt.xlabel(var_ax)
    plt.ylabel("Pressure (Pa)")
    plt.title(f"{fix_ax}={fix_val:.3f} m — {title}")
    plt.grid(ls='--', alpha=0.5)
    plt.legend(fontsize=9)
    plt.tight_layout()
    plt.show()


# === 8. SPLIT PLOTS ===
steady   = list(STEADY_FILES_MM.keys())
unsteady = ['LES', 'DES', 'URANS']

locations = [
    ('Z (m)', 0.735, 'Y (m)', 'Probe Line @ Z=0.735'),
    ('Z (m)', 0.810, 'Y (m)', 'Probe Line @ Z=0.810'),
    ('Z (m)', 0.885, 'Y (m)', 'Probe Line @ Z=0.885'),
]

for fx, fv, vx, label in locations:
    plot_group(merged, fx, fv, vx, steady, f"{label} — steady", show_bands=[])
    plot_group(merged, fx, fv, vx, unsteady, f"{label} — unsteady", show_bands=['LES', 'Exp'])

# === 9. EXPORT CSV ===
merged.to_csv(os.path.join(ROOT, "Full_Pressure_Comparison_All_Models.csv"), index=False)
