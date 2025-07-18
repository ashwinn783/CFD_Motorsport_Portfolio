import matplotlib.pyplot as plt
import numpy as np

# Define yaw angles
yaw_angles = [0, 2, 4, 6, 8]

# Define force values for each model
data = {
    'Realizable k-epsilon': {
        'Lift': [-768, -788, -752, -712, -687],
        'Drag': [-270, -283, -277, -264, -254],
        'Side force': [1.28, -21.1, -38.3, -63.7, -87.8]
    },
    'k-epsilon lag EB': {
        'Lift': [-789, -768, -741, -681, -672],
        'Drag': [-291, -286, -275, -264, -250],
        'Side force': [0.299, -23.6, -40.9, -62.9, -87.7]
    },
    'k-omega SST (a1=0.31)': {
        'Lift': [-642, -684, -671, -583, -557],
        'Drag': [-253, -283, -270, -256, -249],
        'Side force': [3.69, -20.4, -43.2, -66.3, -94.6]
    },
    'k-omega SST (a1=1.0)': {
        'Lift': [-783, -749, -710, -669, -604],
        'Drag': [-290, -289, -275, -264, -250],
        'Side force': [0.654, -24.3, -43.3, -64.6, -91.1]
    }
}

# Flip sign to make histograms go upward
for model in data:
    for force in data[model]:
        data[model][force] = [-val for val in data[model][force]]

# Calculate global max value for y-axis uniform scaling
all_values = []
for model_data in data.values():
    for force_vals in model_data.values():
        all_values.extend(force_vals)

ymin = 0
ymax = max(all_values) * 1.1  # Add 10% headroom

# Plot each force histogram
forces = ['Lift', 'Drag', 'Side force']
colors = ['#1f77b4', '#ff7f0e', '#2ca02c', '#d62728']

for force in forces:
    plt.figure(figsize=(10, 6))
    bar_width = 0.2
    for i, (model, values) in enumerate(data.items()):
        x = np.array(yaw_angles) + i * bar_width
        plt.bar(x, values[force], width=bar_width, label=model, alpha=0.9)

    plt.xlabel('Yaw Angle (degrees)')
    plt.ylabel(f'{force} [N]')
    plt.title(f'{force} vs Yaw Angle for Different Turbulence Models (Uniform Scale)')
    plt.xticks(np.array(yaw_angles) + 1.5 * bar_width, yaw_angles)
    plt.ylim([ymin, ymax])
    plt.legend()
    plt.grid(True)
    plt.tight_layout()

plt.show()
