import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import seaborn as sns
from matplotlib.colors import ListedColormap

# Load the rear wing dataset
df = pd.read_csv("Rear_Wing_Comparison_All_Models.csv")  # Replace with your actual path

# Extract only relative error columns (e.g., columns containing "RelError")
rel_error_columns = [col for col in df.columns if 'relerror' in col.lower()]

# Create 7x7 grid (49 cells) with 1 empty center cell for 48 probes
matrix_size = 7
grid_template = np.arange(matrix_size**2).reshape((matrix_size, matrix_size)).astype(object)
grid_template[3, 3] = None  # Set the center as blank

# Determine valid indices in order
valid_indices = [idx for idx in grid_template.flatten() if idx is not None]

# Define custom colormap
cmap = ListedColormap(["green", "yellow", "orange", "red"])
bounds = [0, 10, 20, 30, 100]
norm = plt.cm.colors.BoundaryNorm(bounds, cmap.N)

# Loop through each relative error column
for error_col in rel_error_columns:
    errors = df[error_col].values[:48]  # First 48 probe errors

    # Initialize 7x7 matrix with NaNs
    error_matrix = np.full((matrix_size, matrix_size), np.nan)

    # Fill matrix using valid indices
    count = 0
    for r in range(matrix_size):
        for c in range(matrix_size):
            if grid_template[r, c] is not None:
                error_matrix[r, c] = errors[count]
                count += 1

    # Flip matrix vertically to make [0,0] bottom-left
    error_matrix = np.flipud(error_matrix)

    # Plot the heatmap
    plt.figure(figsize=(10, 8))
    sns.heatmap(
        error_matrix,
        annot=True,
        fmt=".1f",
        cmap=cmap,
        norm=norm,
        cbar_kws={"label": "Relative Error (%)"},
        linewidths=0.5,
        linecolor='black',
        annot_kws={"size": 28}
    )

    plt.gca().invert_yaxis()  # Make Y-axis increase upward
    plt.title(f"{error_col} Matrix", fontsize=24)
    plt.xlabel("Probe Index (X)", fontsize=18)
    plt.ylabel("Probe Index (Y)", fontsize=18)
    plt.xticks(fontsize=14)
    plt.yticks(fontsize=14)
    plt.tight_layout()
    plt.show()
