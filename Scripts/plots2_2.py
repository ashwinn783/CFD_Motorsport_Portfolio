import numpy as np
import matplotlib.pyplot as plt

# Font size settings
font_sizes = {
    "title": 20,
    "label": 16,
    "ticks": 14,
    "legend": 14
}

# Define models (4 categories)
models = [
    r"$k-\omega$ SST URANS",
    "DES",
    "LES"
]

fz_total = np.array([820, 782, 832])
fx_total = np.array([290, 286, 307])

fz_components = np.array([
    [241.75, 202.12, 223.22],
    [290.95, 280.95, 309.00],
    [183.98, 192.02, 192.78],
    [96.59, 100.05, 100.54],
    [6.73,   6.86,   6.47]
])

fx_components = np.array([
    [48.18,  43.31,  46.86],
    [54.58,  55.22,  61.05],
    [126.85, 130.05, 145.20],
    [33.05,  31.85,  28.05],
    [27.35,  25.57,  25.85]
])

fz_labels = ["Front Wing", "Undertray", "Rear Wing", "Monocoque", "Remaining"]
fx_labels = fz_labels
colors = ['#1f77b4', '#ff7f0e', '#2ca02c', '#9467bd', '#d62728']

# Create vertical subplots
fig, axes = plt.subplots(2, 1, figsize=(10, 12), sharex=True)

# ===== Downforce (Fz) =====
bottom = np.zeros(len(models))
for i in range(len(fz_components)):
    axes[0].bar(models, fz_components[i], bottom=bottom, label=fz_labels[i], color=colors[i])
    bottom += fz_components[i]

axes[0].set_title("Component-wise Contributions to Downforce", fontsize=font_sizes["title"])
axes[0].set_ylabel("Force Contribution (N)", fontsize=font_sizes["label"])
axes[0].tick_params(axis='x', rotation=20, labelsize=font_sizes["ticks"])
axes[0].tick_params(axis='y', labelsize=font_sizes["ticks"])

# ===== Drag (Fx) =====
bottom = np.zeros(len(models))
for i in range(len(fx_components)):
    axes[1].bar(models, fx_components[i], bottom=bottom, label=fx_labels[i], color=colors[i])
    bottom += fx_components[i]

axes[1].set_title("Component-wise Contributions to Drag", fontsize=font_sizes["title"])
axes[1].set_ylabel("Force Contribution (N)", fontsize=font_sizes["label"])
axes[1].tick_params(axis='x', rotation=20, labelsize=font_sizes["ticks"])
axes[1].tick_params(axis='y', labelsize=font_sizes["ticks"])
axes[1].legend(loc='upper left', bbox_to_anchor=(1.05, 1), fontsize=font_sizes["legend"])

plt.tight_layout()
plt.savefig("componentplot_vertical.png", dpi=600, bbox_inches='tight')
# plt.show()
