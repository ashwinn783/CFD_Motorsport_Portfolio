import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

# Set Seaborn style
sns.set_theme(style="whitegrid")

# Font size settings
font_sizes = {
    "title": 22,
    "label": 18,
    "ticks": 16,
    "legend": 16,
    "annot": 18
}

# Data
models = [
    "Rk-epsilon",
    "Lag EB",
    "SST (0.31)",
    "SST (1.0)",
    "URANS",
    "DES",
    "LES"
]


fz_total = np.array([768, 789, 641, 783, 820, 782, 832])
fx_total = np.array([270, 291, 253, 290, 290, 286, 307])

fz_components = np.array([
    [203.86, 287.91, 172.94,  96.23,  7.06],
    [204.01, 287.73, 192.46,  97.19,  7.59],
    [209.43, 289.53, 181.44,  95.64,  6.97],
    [241.75, 290.95, 183.98,  96.59,  6.73],
    [202.12, 280.95, 192.02, 100.05,  6.86],
    [223.22, 308.99, 192.78, 100.54,  6.47]
])

fx_components = np.array([
    [ 44.17,  59.72, 119.66,  24.04, 22.41],
    [ 44.37,  59.41, 136.36,  27.49, 23.38],
    [ 45.01,  59.65, 133.40,  25.49, 26.46],
    [ 48.18,  54.58, 126.85,  33.05, 27.35],
    [ 43.31,  55.22, 130.05,  31.85, 25.57],
    [ 46.86,  61.05, 145.20,  28.05, 25.85]
])

component_labels = ["FW", "UT", "RW", "Mono", "Rem"]

# --- 1. Bar Chart: Total Drag vs. Downforce ---
plt.figure(figsize=(16, 7))
x = np.arange(len(models))
width = 0.4
plt.bar(x - width/2, fz_total, width=width, label="Downforce (Fz)", color="royalblue")
plt.bar(x + width/2, fx_total, width=width, label="Drag (Fx)", color="tomato", alpha=0.8)
plt.xlabel("Turbulence Model", fontsize=font_sizes["label"])
plt.ylabel("Force (N)", fontsize=font_sizes["label"])
plt.xticks(x, models, fontsize=font_sizes["ticks"])
plt.yticks(fontsize=font_sizes["ticks"])
plt.legend(loc='upper left', bbox_to_anchor=(1.05, 1), fontsize=font_sizes["legend"])
plt.tight_layout()
plt.savefig("totalFplot", dpi=600, bbox_inches='tight')  # high-res vector export
# plt.show()

# --- 2. Scatter Plot: Drag vs Downforce ---
plt.figure(figsize=(10, 6))
sns.scatterplot(x=fx_total, y=fz_total, color='darkorange', edgecolor='black', s=100)
for i, txt in enumerate(models):
    plt.annotate(txt, (fx_total[i], fz_total[i]), fontsize=font_sizes["annot"], xytext=(5, 5), textcoords="offset points")
plt.xlabel("Drag (N)", fontsize=font_sizes["label"])
plt.ylabel("Downforce (N)", fontsize=font_sizes["label"])
plt.xticks(x, models, fontsize=font_sizes["ticks"], rotation=0, ha='center', linespacing=1.8)
plt.yticks(fontsize=font_sizes["ticks"])
plt.grid(True, linestyle='--', alpha=0.6)
plt.tight_layout()
plt.savefig("forcemap", dpi=600, bbox_inches='tight')
# plt.show()
