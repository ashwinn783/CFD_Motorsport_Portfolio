import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import seaborn as sns
from matplotlib.colors import ListedColormap

# Load your data
df = pd.read_csv("Nose_Comparison_All_Models.csv")  # Replace with your actual path

# Extract error columns
error_columns = [col for col in df.columns if 'error' in col.lower()]

# Define custom layout (3x3 grid, center blank)
# Index layout:
# [[ 6, 7, 8],
#  [ 3, x, 5],
#  [ 0, 1, 2]]
# x = blank/NaN

# Manual grid mapping of 8 values into a 3x3 matrix with center blank
grid_template = np.array([
    [5, 6, 7],
    [3, None, 4],
    [0, 1, 2]
])

# Define color map
cmap = ListedColormap(["green", "yellow", "orange", "red"])
bounds = [0, 10, 20, 30, 100]
norm = plt.cm.colors.BoundaryNorm(bounds, cmap.N)

# Loop through each error column
for error_col in error_columns:
    errors = df[error_col].values[:8]  # Only use 8 probes for 3x3 with 1 blank

    # Initialize 3x3 matrix with NaNs
    error_matrix = np.full((3, 3), np.nan)

    # Fill based on the custom template
    for r in range(3):
        for c in range(3):
            idx = grid_template[r, c]
            if idx is not None:
                error_matrix[r, c] = errors[int(idx)]

    # Flip to have [0,0] at bottom-left
    error_matrix = np.flipud(error_matrix)

    # Plot
    plt.figure(figsize=(8, 6))
    sns.heatmap(
        error_matrix,
        annot=True,
        fmt=".1f",
        cmap=cmap,
        norm=norm,
        cbar_kws={"label": "Relative Error (%)"},
        linewidths=0.5,
        linecolor='black',
        annot_kws={"size": 20}
    )

    plt.gca().invert_yaxis()  # Y-axis increases upward
    plt.title(f"{error_col} Matrix", fontsize=24)
    plt.xlabel("Probe Index (X)", fontsize=18)
    plt.ylabel("Probe Index (Y)", fontsize=18)
    plt.xticks(fontsize=14)
    plt.yticks(fontsize=14)
    plt.tight_layout()
    plt.show()
