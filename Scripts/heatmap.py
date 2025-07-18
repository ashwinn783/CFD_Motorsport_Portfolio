import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
from matplotlib.colors import ListedColormap, BoundaryNorm

# Load the data
df = pd.read_csv("heatmap.csv")

# Custom color map and boundaries for bins
colors = ['green', 'yellow', 'orange', 'red']
bounds = [0, 10, 20, 30, 100]
cmap = ListedColormap(colors)
norm = BoundaryNorm(bounds, len(colors))

# Function to plot rotated heatmap with fixed bins and annotations
def plot_rotated_heatmap(model_col, title):
    pivot = df.pivot_table(index='Z (m)', columns='Y (m)', values=model_col)
    pivot = pivot.sort_index(ascending=False).sort_index(axis=1, ascending=True)  # Z bottom to top, Y left to right

    plt.figure(figsize=(12, 7))
    sns.heatmap(
        pivot,
        annot=True, fmt=".1f",
        cmap=cmap,
        norm=norm,
        linewidths=0.5,
        cbar_kws={'label': 'Relative Error (%)'},
        square=False
    )
    plt.title(f'{title} Error Matrix', fontsize=14)
    plt.xlabel('Y (m)', fontsize=12)
    plt.ylabel('Z (m)', fontsize=12)
    plt.tight_layout()
    plt.show()

# Dictionary of model columns with display names
models = {
    'Realizable k-ε_RelError': r'Realizable $k-\epsilon$',
    'k-ε Lag EB_RelError': r'$k-\epsilon$ Lag EB',
    'k-ω SST (a₁=0.31)_RelError': r'$k-\omega$ SST (a₁=0.31)',
    'k-ω SST (a₁=1.0)_RelError': r'$k-\omega$ SST (a₁=1.0)',
    'URANS_RelError': 'URANS',
    'DES_RelError': 'DES',
    'LES_RelError': 'LES'
}

# Plot all models with fixed scale
for col, name in models.items():
    plot_rotated_heatmap(col, name)
