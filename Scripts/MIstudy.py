import seaborn as sns
import matplotlib.pyplot as plt
import pandas as pd
from matplotlib.ticker import FuncFormatter

# Data for Realizable k-epsilon
data_kepsilon = {
    'Number of cells': [17691547, 18169704, 20200964, 30039901, 52290156, 93092652],
    'Cl': [-5.6, -6.38, -7.12, -8.22, -8.92, -9.3],
    'Cd': [-2.67, -2.87, -3.08, -3.12, -3.12, -3.16],
    'Cl/Cd': [2.097378277, 2.222996516, 2.311688312, 2.634615385, 2.858974359, 2.943037975]
}

# Data for k-epsilon lag EB
data_kepsilon_lag = {
    'Number of cells': [17700582, 18178963, 20210658, 30048108, 43309512, 93100824],
    'Cl': [-5.37, -5.78, -6.7, -7.92, -8.43, -8.74],
    'Cd': [-2.69, -2.76, -2.92, -3.04, -3.09, -3.13],
    'Cl/Cd': [1.996282528, 2.094202899, 2.294520548, 2.605263158, 2.72815534, 2.792332268]
}

# Data for k-omega SST
data_komega = {
    'Number of cells': [29502019, 31683143, 41820502, 55520050, 71005676, 106420370],
    'Cl': [-5.64, -6.44, -7.65, -7.78, -7.83, -7.88],
    'Cd': [-2.77, -3, -3.15, -2.86, -2.87, -2.91],
    'Cl/Cd': [2.036101083, 2.146666667, 2.428571429, 2.72027972, 2.728222997, 2.70790378]
}

# Convert data to pandas DataFrame
df_kepsilon = pd.DataFrame(data_kepsilon)
df_kepsilon_lag = pd.DataFrame(data_kepsilon_lag)
df_komega = pd.DataFrame(data_komega)

# Formatter function to convert to millions
million_formatter = FuncFormatter(lambda x, _: f'{x*1e-6:.0f}M')

# Plotting function with scaling and formatting
def plot_data(df, title):
    plt.figure(figsize=(10, 6))
    sns.lineplot(x='Number of cells', y='Cl/Cd', data=df, marker='o', color='b')
    plt.xlabel('Number of cells (millions)', fontsize=26)
    plt.ylabel(r'$\dfrac{C_{l}}{C_{d}}$', fontsize=26)
    plt.gca().xaxis.set_major_formatter(million_formatter)
    plt.tick_params(axis='both', labelsize=24)
    plt.grid(True)
    plt.tight_layout()
    plt.show()

# Plot for each table
plot_data(df_kepsilon, 'Realizable k-epsilon: Number of cells vs Cl/Cd')
plot_data(df_kepsilon_lag, 'k-epsilon lag EB: Number of cells vs Cl/Cd')
plot_data(df_komega, 'k-omega SST: Number of cells vs Cl/Cd')
