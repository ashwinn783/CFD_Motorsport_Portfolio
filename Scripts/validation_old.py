import pandas as pd
import os
import re
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt

def plot_structured_region_heatmap(region_name, coords, merged, sim_type='LES'):
    records = []

    for (x, y, z) in coords:
        match = merged[
            (np.isclose(merged['X (m)'], x, atol=1e-5)) &
            (np.isclose(merged['Y (m)'], y, atol=1e-5)) &
            (np.isclose(merged['Z (m)'], z, atol=1e-5))
        ]

        if not match.empty:
            sim_p = match['LES_Pressure'].values[0] if sim_type == 'LES' else match['Pressure_RANS'].values[0]
            exp_p = match['Pressure_Exp'].values[0]
            rel_error = abs((sim_p - exp_p) / exp_p) * 100 if exp_p != 0 else np.nan
            records.append((y, z, rel_error))

    if not records:
        print(f"No data found for {region_name} - {sim_type}")
        return

    df = pd.DataFrame(records, columns=['Y (m)', 'Z (m)', 'RelError'])
    df_pivot = df.pivot(index='Z (m)', columns='Y (m)', values='RelError')
    df_pivot = df_pivot.sort_index(ascending=False)  # To have Z from top to bottom

    plt.figure(figsize=(8, 5))
    sns.heatmap(df_pivot, annot=True, fmt=".1f", cmap='coolwarm', cbar_kws={'label': 'Relative Error (%)'})
    plt.title(f"{sim_type} Relative Pressure Error - {region_name}")
    plt.xlabel("Y (m)")
    plt.ylabel("Z (m)")
    plt.tight_layout()
    plt.show()


# === USER INPUTS ===
sim_folder = "E:/Validation"                   # LES simulation CSVs (per time step)
exp_file = "E:/Experiment.csv"                 # Experimental pressure data
rans_file = "E:/lagEB.csv"              # RANS pressure data file

# === 1. LOAD LES SIMULATION DATA ===
pattern = r"Validation_table_([0-9.e+-]+).csv"
sim_data = []

for fname in os.listdir(sim_folder):
    match = re.search(pattern, fname)
    if match:
        time = float(match.group(1))
        df = pd.read_csv(os.path.join(sim_folder, fname))
        df['Time'] = time
        sim_data.append(df)

sim_df = pd.concat(sim_data, ignore_index=True)

# === 2. TIME-AVERAGE LES PRESSURE ===
sim_avg = (
    sim_df
    .groupby(['X (m)', 'Y (m)', 'Z (m)'], as_index=False)
    .agg({'Total Pressure (Pa)': ['mean', 'std']})
)
sim_avg.columns = ['X (m)', 'Y (m)', 'Z (m)', 'LES_Pressure', 'LES_Std']

# === 3. LOAD EXPERIMENTAL DATA (mm → m) ===
exp_df = pd.read_csv(exp_file)
exp_df['X (m)'] = exp_df['X (mm)'] / 1000
exp_df['Y (m)'] = exp_df['Y (mm)'] / 1000
exp_df['Z (m)'] = exp_df['Z (mm)'] / 1000

# === 4. LOAD RANS DATA (mm → m) ===
rans_df = pd.read_csv(rans_file)
rans_df['X (m)'] = rans_df['X (mm)'] / 1000
rans_df['Y (m)'] = rans_df['Y (mm)'] / 1000
rans_df['Z (m)'] = rans_df['Z (mm)'] / 1000
rans_df = rans_df.rename(columns={'Total Pressure (Pa)': 'Pressure_RANS'})

# === 5. ROUND ALL POSITIONS FOR MERGING ===
for col in ['X (m)', 'Y (m)', 'Z (m)']:
    sim_avg[col] = sim_avg[col].round(5)
    exp_df[col] = exp_df[col].round(5)
    rans_df[col] = rans_df[col].round(5)

# === 6. MERGE ALL THREE SOURCES ===
merged = pd.merge(sim_avg, exp_df[['X (m)', 'Y (m)', 'Z (m)', 'Pressure']],
                  on=['X (m)', 'Y (m)', 'Z (m)'], how='inner')
merged = pd.merge(merged, rans_df[['X (m)', 'Y (m)', 'Z (m)', 'Pressure_RANS']],
                  on=['X (m)', 'Y (m)', 'Z (m)'], how='inner')
merged = merged.rename(columns={'Pressure': 'Pressure_Exp'})

if merged.empty:
    print("❌ Merge failed. No common probe locations.")
    exit()

# === 7. PRESSURE ERROR METRICS ===
merged['LES_Error'] = merged['LES_Pressure'] - merged['Pressure_Exp']
merged['RANS_Error'] = merged['Pressure_RANS'] - merged['Pressure_Exp']

mae_les = np.mean(np.abs(merged['LES_Error']))
rmse_les = np.sqrt(np.mean(merged['LES_Error'] ** 2))

mae_rans = np.mean(np.abs(merged['RANS_Error']))
rmse_rans = np.sqrt(np.mean(merged['RANS_Error'] ** 2))

print("\n--- PRESSURE VALIDATION METRICS ---")
print(f"LES  - MAE: {mae_les:.2f} Pa | RMSE: {rmse_les:.2f} Pa")
print(f"RANS - MAE: {mae_rans:.2f} Pa | RMSE: {rmse_rans:.2f} Pa")

# === 8. PLOTTING FUNCTION ===
def plot_pressure_profile(data, fixed_axis, fixed_value, varying_axis, label=None):
    filtered = data[np.isclose(data[fixed_axis], fixed_value, atol=0.01)]
    if filtered.empty:
        print(f"No data at {fixed_axis} = {fixed_value}")
        return

    grouped = filtered.groupby(varying_axis).agg({
        'LES_Pressure': 'mean',
        'LES_Std': 'mean',
        'Pressure_Exp': 'mean',
        'Pressure_RANS': 'mean'
    }).reset_index()

    plt.figure(figsize=(7, 6))
    
    # LES with shading
    plt.plot(grouped[varying_axis], grouped['LES_Pressure'], color='navy', label='LES')
    plt.fill_between(grouped[varying_axis],
                     grouped['LES_Pressure'] - grouped['LES_Std'],
                     grouped['LES_Pressure'] + grouped['LES_Std'],
                     alpha=0.2, color='navy')

    # RANS
    plt.plot(grouped[varying_axis], grouped['Pressure_RANS'], color='crimson', linestyle='-', label='RANS')

    # Experimental
    plt.plot(grouped[varying_axis], grouped['Pressure_Exp'], color='black', linestyle='--', label='Experimental')

    plt.xlabel(varying_axis)
    plt.ylabel("Pressure (Pa)")
    title = f"Pressure Profile at {fixed_axis} = {fixed_value:.3f} m"
    if label:
        title += f" ({label})"
    plt.title(title)
    plt.legend()
    plt.grid(True)
    plt.tight_layout()
    plt.show()

# === 9. GENERATE 5 PLOTS ===

# 1. Vertical centerline profile
plot_pressure_profile(merged, 'X (m)', 0.25, 'Z (m)', label='Centerline')

# 2. Horizontal Y-profile at X=0.25 m
plot_pressure_profile(merged, 'X (m)', 0.25, 'Y (m)', label='Horizontal at X=0.25')

# 3. Radial profile at bottom Z=0.735
plot_pressure_profile(merged, 'Z (m)', 0.735, 'Y (m)', label='Z=0.735')

# 4. Radial profile at mid-height Z=0.810
plot_pressure_profile(merged, 'Z (m)', 0.810, 'Y (m)', label='Z=0.810')

# 5. Vertical profile at Y=0.0
plot_pressure_profile(merged, 'Y (m)', 0.0, 'Z (m)', label='Centerline at Y=0')

# === 10. EXPORT COMBINED DATA ===
merged.to_csv("Full_Pressure_Comparison.csv", index=False)


