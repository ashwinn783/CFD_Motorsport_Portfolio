import numpy as np
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

# Set seaborn style
sns.set_theme(style="whitegrid")

# Font size settings
font_sizes = {
    "title": 20,
    "label": 16,
    "ticks": 14,
    "legend": 14
}

# Define models (6 categories)
models = [
    r"Realizable $k-\epsilon$", r"$k-\epsilon$ lag EB", r"$k-\omega$ SST",
    r"$k-\omega$ SST URANS", "DES", "LES"
]

fz_components = np.array([
    [211, 212, 217, 226, 200, 242],    # Fz FW
    [298, 299, 300, 272, 278, 335],    # Fz UT
    [179, 200, 188, 172, 190, 209],    # Fz RW
    [99.6, 101, 99.1, 90.3, 99.0, 109],# Fz Mono
    [7.31, 7.89, 7.22, 6.29, 6.79, 7.01], # Fz Rem
])

fx_components = np.array([
    [40.6, 41.0, 41.5, 41.4, 39.3, 42.6],
    [54.9, 54.9, 55.0, 46.9, 50.1, 55.5],
    [110, 126, 123, 109, 118, 132],
    [22.1, 25.4, 23.5, 28.4, 28.9, 25.5],
    [20.6, 21.6, 24.4, 23.5, 23.2, 23.5],
])

component_labels = ["Front Wing", "Undertray", "Rear Wing", "Monocoque", "Remaining"]
colors = ['#1f77b4', '#ff7f0e', '#2ca02c', '#9467bd', '#d62728']

# Convert forces to percentages
fz_total = fz_components.sum(axis=0)
fx_total = fx_components.sum(axis=0)
fz_percent = (fz_components / fz_total) * 100
fx_percent = (fx_components / fx_total) * 100

# Create DataFrames for Seaborn
fz_df = pd.DataFrame(fz_percent.T, columns=component_labels)
fz_df["Model"] = models
fz_df = fz_df.melt(id_vars="Model", var_name="Component", value_name="Percentage")

fx_df = pd.DataFrame(fx_percent.T, columns=component_labels)
fx_df["Model"] = models
fx_df = fx_df.melt(id_vars="Model", var_name="Component", value_name="Percentage")

# Create subplots
fig, axes = plt.subplots(1, 2, figsize=(16, 7), sharey=True)

# Downforce Plot
sns.barplot(data=fz_df, x="Percentage", y="Model", hue="Component", palette=colors, ax=axes[0])
axes[0].set_title("Component-wise % Contributions to Downforce", fontsize=font_sizes["title"])
axes[0].set_xlabel("Percentage (%)", fontsize=font_sizes["label"])
axes[0].set_ylabel("", fontsize=font_sizes["label"])
axes[0].tick_params(labelsize=font_sizes["ticks"])
axes[0].invert_yaxis()

# Drag Plot
sns.barplot(data=fx_df, x="Percentage", y="Model", hue="Component", palette=colors, ax=axes[1])
axes[1].set_title("Component-wise % Contributions to Drag", fontsize=font_sizes["title"])
axes[1].set_xlabel("Percentage (%)", fontsize=font_sizes["label"])
axes[1].set_ylabel("", fontsize=font_sizes["label"])
axes[1].tick_params(labelsize=font_sizes["ticks"])

# Move legend outside
axes[1].legend(loc='upper left', bbox_to_anchor=(1.05, 1), fontsize=font_sizes["legend"])
axes[0].legend_.remove()  # remove legend from left plot

plt.tight_layout()

# Save to PNG (high-res) and PDF (vector)
plt.savefig("component_contributions.png", dpi=600, bbox_inches='tight')
#plt.savefig("component_contributions.pdf", bbox_inches='tight')
# plt.show()  # Uncomment if you want to also display
