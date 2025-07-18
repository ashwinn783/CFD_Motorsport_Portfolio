import matplotlib.pyplot as plt
import seaborn as sns

# Use seaborn style
sns.set_theme(style="whitegrid")

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

min_cp = [-4.8, -4.9, -4.1, -5.5, -6.0, -7.0, -11.5]

# Plot
plt.figure(figsize=(8, 5))
bars = plt.barh(models, min_cp, color="skyblue", edgecolor="black")
plt.xlabel("Minimum $C_p$")
plt.title("Minimum Pressure Coefficient by Turbulence Model")
plt.gca().invert_yaxis()

# Annotate bars with values INSIDE the bar, aligned to right
for bar, value in zip(bars, min_cp):
    plt.text(value + 0.2, bar.get_y() + bar.get_height()/2,
             f"{value:.1f}", va='center', ha='left', color='black')

plt.tight_layout()
plt.savefig("min_cp_histogram.png", dpi=600)
#plt.show()
