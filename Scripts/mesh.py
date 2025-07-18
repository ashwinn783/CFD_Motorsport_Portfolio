import pandas as pd
import matplotlib.pyplot as plt

# Load and standardize
def load_and_standardize(filepath, x_label):
    df = pd.read_csv(filepath)
    df.columns = df.columns.str.strip()
    df.columns = [x_label, "Air: Frequency"]
    df["Percentage"] = (df["Air: Frequency"] / df["Air: Frequency"].sum()) * 100
    return df

# Plot percentage histogram with font size options
def plot_percentage_histogram(df, x_col, title, xlabel, ylabel, filename, bar_width=0.04, font_sizes=None):
    if font_sizes is None:
        font_sizes = {"title": 16, "label": 14, "ticks": 12}
    
    plt.figure(figsize=(10, 6))
    plt.bar(df[x_col], df["Percentage"], width=bar_width, align='center', edgecolor='black')
    
    plt.title(title, fontsize=font_sizes["title"])
    plt.xlabel(xlabel, fontsize=font_sizes["label"])
    plt.ylabel(ylabel, fontsize=font_sizes["label"])
    plt.xticks(fontsize=font_sizes["ticks"])
    plt.yticks(fontsize=font_sizes["ticks"])
    plt.grid(True, linestyle='--', alpha=0.6)
    plt.tight_layout()
    plt.savefig(filename, dpi=600)
    plt.close()

# Load data
cell_quality = load_and_standardize("cell quality.csv", "Cell Quality")
skewness_angle = load_and_standardize("skewness angle.csv", "Skewness Angle")
volume_change = load_and_standardize("volume change.csv", "Volume Change")

# Define font sizes
font_sizes = {"title": 22, "label": 18, "ticks": 16}

# Generate plots with custom fonts
plot_percentage_histogram(cell_quality, "Cell Quality", 
    "Cell Quality Distribution (%)", "Cell Quality", "Percentage (%)", "cell quality.png",
    font_sizes=font_sizes)

plot_percentage_histogram(skewness_angle, "Skewness Angle", 
    "Skewness Angle Distribution (%)", "Skewness Angle (degrees)", "Percentage (%)", "skewness angle.png",
    bar_width=3, font_sizes=font_sizes)

plot_percentage_histogram(volume_change, "Volume Change", 
    "Volume Change Distribution (%)", "Volume Change", "Percentage (%)", "volume change.png",
    font_sizes=font_sizes)
