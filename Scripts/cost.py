import matplotlib.pyplot as plt
import seaborn as sns
import pandas as pd

# Use seaborn theme
sns.set_theme(style="whitegrid")

# Data
models = [
    "Realizable k-ε", "Lag EB k-ε", "SST (a1=0.31)", "SST (a1=1.0)",
    "URANS", "DES", "LES"
]
is_steady = [True, True, True, True, False, False, False]
runtime = [2.2, 2.5, 2.1, 2.0, None, None, None]  # wall time (h)
throughput = [None, None, None, None, 1.12, 0.6, 0.36]  # s/day
mae = [17.8, 20.8, 20.9, 20.2, 18.2, 12.4, 10.2]

# Separate data
steady_models = [m for m, s in zip(models, is_steady) if s]
steady_runtime = [r for r in runtime if r is not None]
steady_mae = [m for m, s in zip(mae, is_steady) if s]

unsteady_models = [m for m, s in zip(models, is_steady) if not s]
unsteady_throughput = [t for t in throughput if t is not None]
unsteady_mae = [m for m, s in zip(mae, is_steady) if not s]

# --- Plot 1: Steady Models (Runtime vs MAE) ---
plt.figure(figsize=(8, 6))
sns.scatterplot(x=steady_runtime, y=steady_mae, s=100, color='blue')

for x, y, label in zip(steady_runtime, steady_mae, steady_models):
    plt.text(x, y + 0.4, label, ha='center', fontsize=9)

plt.xlabel("Runtime (hours)")
plt.ylabel("Rear Wing MAE (%)")
plt.title("Steady-State Models: Runtime vs Accuracy")
plt.grid(True)
plt.tight_layout()
plt.savefig("steady_runtime_vs_mae.png", dpi=300)
#plt.show()

# --- Plot 2: Unsteady Models (Throughput vs MAE) ---
plt.figure(figsize=(8, 6))
sns.scatterplot(x=unsteady_throughput, y=unsteady_mae, s=100, color='red')

for x, y, label in zip(unsteady_throughput, unsteady_mae, unsteady_models):
    plt.text(x, y + 0.4, label, ha='center', fontsize=9)

plt.xlabel("Throughput (s/day)")
plt.ylabel("Rear Wing MAE (%)")
plt.title("Unsteady Models: Throughput vs Accuracy")
plt.grid(True)
plt.tight_layout()
plt.savefig("unsteady_throughput_vs_mae.png", dpi=300)
#plt.show()
