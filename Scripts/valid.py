import numpy as np
import matplotlib.pyplot as plt

# Positions
positions = ["Rear Wing", "Left", "Middle"]

# Mean % difference (absolute error from experiments)
Real_k_epsilon = [18.88, 120.25, 0.55]  
k_epsilonlagEB = [17.4, 126.64,0.55]
k_omega_sst = [18.3, 260.69, 0.63]
urans = [15.45, 125.51, 0.52]
des = [16.80, 118, 0.69]

plt.figure(figsize=(8, 5))

plt.plot(positions, Real_k_epsilon, marker='o', linestyle='-', label="Realizable k-ε", color="blue")
plt.plot(positions, k_epsilonlagEB, marker='^', linestyle='-.', label="k-ε lag Elliptic Blending", color="green")
plt.plot(positions, k_omega_sst, marker='s', linestyle='--', label="k-ω SST", color="red")
plt.plot(positions, urans, marker='D', linestyle=':', label="URANS", color="purple")
plt.plot(positions, des, marker='P', linestyle='-.', label="DES", color="orange")

plt.axhline(0, color='black', linewidth=1, linestyle="--")  # Perfect match line

# Formatting
plt.xlabel("Position")
plt.ylabel("Mean % Difference from Experiment")
plt.title("Comparison of Turbulence Models with Experiment")
plt.legend()
plt.grid(True, linestyle="--", alpha=0.6)
plt.show()
