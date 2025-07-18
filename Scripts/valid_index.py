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

# --- 1. LOAD EXPERIMENTAL DATA ---
exp_df = pd.read_csv(EXPERIMENT_CSV)
exp_df['X (m)'] = exp_df['X (mm)']/1000
exp_df['Y (m)'] = exp_df['Y (mm)']/1000
exp_df['Z (m)'] = exp_df['Z (mm)']/1000
exp_df = exp_df[['X (m)','Y (m)','Z (m)','Pressure']]
exp_df = exp_df.rename(columns={'Pressure':'Pressure_Exp'})

# --- 2. LOAD STEADY RANS MODELS ---
model_dfs = {}
for name, path in STEADY_FILES_MM.items():
    df = pd.read_csv(path)
    df['X (m)'] = df['X (mm)']/1000
    df['Y (m)'] = df['Y (mm)']/1000
    df['Z (m)'] = df['Z (mm)']/1000
    df = df.rename(columns={'Total Pressure (Pa)': f'Pressure_{name}'})
    model_dfs[name] = df[['X (m)','Y (m)','Z (m)', f'Pressure_{name}']]

# --- 3. LOAD & AVERAGE TRANSIENT MODELS ---
def load_transient(folder, model_name):
    pattern = r"Validation_table_([0-9.eE+-]+)\.csv"
    frames = []
    for fn in os.listdir(folder):
        m = re.match(pattern, fn)
        if not m: 
            continue
        df = pd.read_csv(os.path.join(folder, fn))
        df = df[['X (m)','Y (m)','Z (m)','Total Pressure (Pa)']]
        df['Time'] = float(m.group(1))
        frames.append(df)
    allf = pd.concat(frames, ignore_index=True)
    avg = (
        allf
        .groupby(['X (m)','Y (m)','Z (m)'])
        .agg(Pressure=('Total Pressure (Pa)','mean'),
             Std     =('Total Pressure (Pa)','std'))
        .reset_index()
    )
    return avg.rename(columns={
        'Pressure': f'Pressure_{model_name}',
        'Std'     : f'{model_name}_Std'
    })

for name, folder in TRANSIENT_MODELS.items():
    model_dfs[name] = load_transient(folder, name)

# --- 4. ROUND & MERGE ALL ---
for df in model_dfs.values():
    for c in ['X (m)','Y (m)','Z (m)']:
        df[c] = df[c].round(5)
for c in ['X (m)','Y (m)','Z (m)']:
    exp_df[c] = exp_df[c].round(5)

merged = exp_df.copy()
for name, df in model_dfs.items():
    merged = pd.merge(merged, df, on=['X (m)','Y (m)','Z (m)'], how='inner')

# --- 5. DEFINE REGIONS & ASSIGN PROBE INDEX ---
regions = {
    "Rear wing":  (lambda df: np.isclose(df['X (m)'], 0.25, atol=1e-3), ['Y (m)', True]),
    "Tire wake":  (lambda df: np.isclose(df['X (m)'], 1.225, atol=1e-3), ['Y (m)', False]),
    "Middle":     (lambda df: df['X (m)']>2.0,                         ['Z (m)', False]),
}

color_map = {
        'LES': 'red', 'DES': 'blue', 'URANS': 'green',
        "Realizable k-ε": '#9467bd', "k-ε Lag EB": '#ff7f0e',
        "k-ω SST (a₁=0.31)": '#8c564b', "k-ω SST (a₁=1.0)": '#17becf'
    }
# 'True' means sort ascending, 'False' descending (so index 0 at top/wake root)

for region, (mask_fn, (sort_col, ascending)) in regions.items():
    sub = merged[mask_fn(merged)].copy()
    # sort & assign index
    sub = sub.sort_values(sort_col, ascending=ascending).reset_index(drop=True)
    sub['ProbeIdx'] = np.arange(len(sub))

    # --- Compute common y-limits (min and max across all plotted models and Exp) ---
    all_cols = ['Pressure_Exp'] + [f'Pressure_{name}' for name in STEADY_FILES_MM] + \
               [f'Pressure_k-ε Lag EB'] + [f'Pressure_{m}' for m in TRANSIENT_MODELS]
    y_values = pd.concat([sub[col] for col in all_cols if col in sub], axis=0)
    y_min, y_max = y_values.min(), y_values.max()
    y_pad = (y_max - y_min) * 0.05  # add 5% padding
    y_limits = (y_min - y_pad, y_max + y_pad)

    # 6a) Plot all steady vs experiment
    plt.figure(figsize=(7,4))
    plt.plot(sub['ProbeIdx'], sub['Pressure_Exp'], '--k', label='Experiment')
    for name in STEADY_FILES_MM:
        plt.plot(sub['ProbeIdx'], sub[f'Pressure_{name}'], 
                 '-', label=name, linewidth=1.5)
    plt.title(f"{region} — Steady Models")
    plt.xlabel("Probe Index")
    plt.ylabel("Pressure (Pa)")
    plt.ylim(*y_limits)
    plt.legend(fontsize=8)
    plt.grid(ls='--', alpha=0.5)
    plt.tight_layout()
    plt.show()

    # 6b) Plot best steady + all transient
    plt.figure(figsize=(7,4))
    plt.plot(sub['ProbeIdx'], sub['Pressure_Exp'], '--k', label='Experiment')
    plt.plot(sub['ProbeIdx'], sub[f'Pressure_k-ε Lag EB'], 
             '-', color=color_map['k-ε Lag EB'], label='k-ε Lag EB', linewidth=1.5)
    for name in TRANSIENT_MODELS:
        y = sub[f'Pressure_{name}']
        plt.plot(sub['ProbeIdx'], y, '-', color=color_map[name], label=name, linewidth=1.5)
    # LES std band
    if 'LES_Std' in sub:
        std = sub['LES_Std']
        plt.fill_between(sub['ProbeIdx'], sub['Pressure_LES'] - std, sub['Pressure_LES'] + std,
                         color='red', alpha=0.25)
    plt.title(f"{region} — Best Steady + Transient")
    plt.xlabel("Probe Index")
    plt.ylabel("Pressure (Pa)")
    plt.ylim(*y_limits)
    plt.legend(fontsize=8)
    plt.grid(ls='--', alpha=0.5)
    plt.tight_layout()
    plt.show()
