import matplotlib.pyplot as plt
import numpy as np

# Data
models = [
    "Rk-ε", "Lag EB", "SST (0.31)", "SST (1.0)", "URANS", "DES", "LES"
]

# Computational cost
wall_clock = [2.2, 2.5, 2.1, 2.0, None, None, None]  # hours
throughput = [None, None, None, None, 1.12, 0.6, 0.36]  # s/day
cost = [r if r is not None else 10 / t for r, t in zip(wall_clock, throughput)]  # runtime equivalent

# MAE values
mae = [17.8, 20.8, 20.9, 20.2, 18.2, 12.4, 10.2]

x = np.arange(len(models))
width = 0.35

# Plot
fig, ax1 = plt.subplots(figsize=(10, 6))
bars1 = ax1.bar(x - width/2, cost, width, label='Computational Cost (h or 1/s)', color='orange', edgecolor='black')
bars2 = ax1.bar(x + width/2, mae, width, label='MAE (%) Rear Wing', color='skyblue', edgecolor='black')

# Labels
ax1.set_ylabel('Value')
ax1.set_title('Model Comparison: Computational Cost vs Accuracy')
ax1.set_xticks(x)
ax1.set_xticklabels(models, rotation=45, ha='right')
ax1.legend()

# Annotate bars
for bar in bars1 + bars2:
    height = bar.get_height()
    ax1.annotate(f'{height:.2f}', xy=(bar.get_x() + bar.get_width() / 2, height),
                 xytext=(0, 3), textcoords="offset points", ha='center', va='bottom', fontsize=9)

plt.tight_layout()
plt.savefig("cost_vs_accuracy.png", dpi=600)
#plt.show()
