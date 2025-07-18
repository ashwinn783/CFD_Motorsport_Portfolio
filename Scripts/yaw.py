import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

# Set Seaborn style
sns.set_theme(style="whitegrid")

# Define yaw angles
yaw_angles = np.array([0, 2, 4, 6, 8])

# Delta C_l values
delta_c_l_realizable_ke = [0, -0.0014145, -0.1849315, -0.394488, -0.5200985]
delta_c_l_ke_lag_eb = [0, -0.2159165, -0.3544905, -0.6651285, -0.7117515]
delta_c_l_komega_sst1 = [0, 0.227525, 0.1554755, -0.3097395, -0.4517415]
delta_c_l_komega_sst2 = [0, -0.182658, -0.389747, -0.6075115, -0.9530905]

# Delta C_d values
delta_c_d_realizable_ke = [0, 0.032898, 0.00268, -0.0640175, -0.119079]
delta_c_d_ke_lag_eb = [0, -0.0621725, -0.117318, -0.1759205, -0.251583]
delta_c_d_komega_sst1 = [0, 0.1604495, 0.093503, 0.0178885, -0.020585]
delta_c_d_komega_sst2 = [0, -0.0072005, -0.0804405, -0.140859, -0.213663]

# Delta C_s values
delta_c_s_realizable_ke = [0, 0.119, 0.2105, 0.346, 0.474]
delta_c_s_ke_lag_eb = [0, 0.1275, 0.219, 0.336, 0.468]
delta_c_s_komega_sst1 = [0, 0.128, 0.2495, 0.3725, 0.525]
delta_c_s_komega_sst2 = [0, 0.133, 0.234, 0.347, 0.4885]

# Delta Balance values
delta_balance_realizable_ke = [0, -2.52, -2.47, -1.07, 1.20]
delta_balance_ke_lag_eb = [0, 0.134, 2.11, 2.44, 4.63]
delta_balance_komega_sst1 = [0, -0.883, -2.21, -1.9, 0.797]
delta_balance_komega_sst2 = [0, -0.852, 1.03, 2.15, 4.06]

# Delta Efficiency values
delta_efficiency_realizable_ke = [0, -0.0683, -0.137, -0.158, -0.141]
delta_efficiency_ke_lag_eb = [0, -0.0268, -0.0203, -0.132, -0.0173]
delta_efficiency_komega_sst1 = [0, -0.121, -0.00584, -0.262, -0.303]
delta_efficiency_komega_sst2 = [0, -0.109, -0.121, -0.165, -0.286]

# Store data in a dictionary
models = {
    r"$\Delta C_l$": [delta_c_l_realizable_ke, delta_c_l_ke_lag_eb, delta_c_l_komega_sst1, delta_c_l_komega_sst2],
    r"$\Delta C_d$": [delta_c_d_realizable_ke, delta_c_d_ke_lag_eb, delta_c_d_komega_sst1, delta_c_d_komega_sst2],
    r"$\Delta C_s$": [delta_c_s_realizable_ke, delta_c_s_ke_lag_eb, delta_c_s_komega_sst1, delta_c_s_komega_sst2],
    r"$\Delta CoP$": [delta_balance_realizable_ke, delta_balance_ke_lag_eb, delta_balance_komega_sst1, delta_balance_komega_sst2],
    r"$\Delta Efficiency$": [delta_efficiency_realizable_ke, delta_efficiency_ke_lag_eb, delta_efficiency_komega_sst1, delta_efficiency_komega_sst2]
}

# Model names and properties
model_names = [
    r"Realizable $k-\epsilon$",
    r"$k-\epsilon$ Lag EB",
    r"$k$-$\omega$ SST ($a_1$=0.31)",
    r"$k$-$\omega$ SST ($a_1$=1.0)"
]

palette = sns.color_palette("deep", n_colors=4)
linestyles = ["dashed", "dashed", "solid", "solid"]
markers = ["o", "s", "D", "^"]

# Generate and save plots
for title, data in models.items():
    plt.figure(figsize=(7, 5))
    for model_data, name, ls, marker, color in zip(data, model_names, linestyles, markers, palette):
        sns.lineplot(x=yaw_angles, y=model_data, linestyle=ls, marker=marker, label=name, color=color)

    plt.xlabel("Yaw Angle (degrees)", fontsize=12)
    plt.ylabel(title, fontsize=12)
    plt.xticks([0, 2, 4, 6, 8])
    plt.axhline(0, color='black', linewidth=1, linestyle="--")
    plt.legend(fontsize=10)
    plt.grid(True, linestyle="--", alpha=0.6)
    plt.tight_layout()

    # Create a valid filename by removing LaTeX symbols
    filename = title.replace("$", "").replace("\\", "").replace("{", "").replace("}", "").replace(" ", "_").replace("-", "_") + ".png"
    plt.savefig(filename, dpi=600)
    plt.close()
