import numpy as np
import matplotlib.pyplot as plt

# Parameters
m = 180            # Mass of the car (kg)
g = 9.81           # Gravity (m/s^2)
mu_friction = 1.2  # Tire-road friction coefficient
rho = 1.225        # Air density (kg/m^3)

R_values = np.linspace(1, 40, 40)  # Corner radius range (m)
CL_values = [0, 1.0, 2.0, 3.0, 4.0, 5.0]  # Different downforce levels

# Initialize speed matrix
V_max = np.zeros((len(CL_values), len(R_values)))

# Compute V_max for each combination of CL and R
for j, CLA in enumerate(CL_values):
    for i, R in enumerate(R_values):
        denominator = (m / R) - (mu_friction * rho * CLA / 2)
        if denominator > 0:
            V_max[j, i] = np.sqrt((mu_friction * m * g) / denominator)
        else:
            V_max[j, i] = np.nan  # Avoid imaginary values

# Plot settings
plt.figure(figsize=(8, 8))  # Square figure
colors = plt.cm.viridis(np.linspace(0, 1, len(CL_values)))

# Increase font sizes
plt.rcParams.update({
    'font.size': 14,
    'axes.titlesize': 16,
    'axes.labelsize': 16,
    'legend.fontsize': 12,
    'xtick.labelsize': 12,
    'ytick.labelsize': 12
})

for j, CLA in enumerate(CL_values):
    plt.plot(R_values, V_max[j, :], color=colors[j], linewidth=2,
             label=fr'$C_{{LA}} = {CLA:.1f}$')

plt.xlabel('Corner Radius (m)')
plt.ylabel('Maximum Cornering Speed (m/s)')
plt.legend()
plt.grid(True)
plt.tight_layout()

# Save the figure
plt.savefig('cornering_speed_vs_radius_square.png', dpi=600)
plt.close()
