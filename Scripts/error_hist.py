import matplotlib.pyplot as plt
import numpy as np

# Model names
models = [
    "Rk-ε", "Lag EB", "SST (0.31)", "SST (1.0)", "URANS", "DES", "LES"
]
x = np.arange(len(models))
width = 0.35

# Data
mae_nose = [0.55, 0.54, 0.63, 0.53, 1.03, 2.1, 0.67]
mae_rear = [17.83, 20.80, 20.94, 20.15, 18.24, 12.36, 10.20]

rmse_nose = [0.77, 0.76, 0.86, 0.75, 1.19, 2.06, 0.75]
rmse_rear = [27.21, 30.96, 34.33, 30.57, 27.42, 16.60, 13.68]

# ----- MAE Figure -----
fig1, ax1 = plt.subplots(figsize=(10, 6))
bars1 = ax1.bar(x - width/2, mae_nose, width, label='Nose (8 pts)', color='skyblue', edgecolor='black')
bars2 = ax1.bar(x + width/2, mae_rear, width, label='Rear Wing (48 pts)', color='salmon', edgecolor='black')
ax1.set_ylabel('MAE (%)')
ax1.set_title('Mean Absolute Error by Region')
ax1.set_xticks(x)
ax1.set_xticklabels(models, rotation=45, ha='right')
ax1.legend()

for bar in bars1 + bars2:
    height = bar.get_height()
    ax1.annotate(f'{height:.1f}', xy=(bar.get_x() + bar.get_width()/2, height),
                 xytext=(0, 3), textcoords='offset points', ha='center', va='bottom', fontsize=9)

plt.tight_layout()
plt.savefig("mae_validation.png", dpi=600)
#plt.show()

# ----- RMSE Figure -----
fig2, ax2 = plt.subplots(figsize=(10, 6))
bars3 = ax2.bar(x - width/2, rmse_nose, width, label='Nose (8 pts)', color='skyblue', edgecolor='black')
bars4 = ax2.bar(x + width/2, rmse_rear, width, label='Rear Wing (48 pts)', color='salmon', edgecolor='black')
ax2.set_ylabel('RMSE')
ax2.set_title('Root Mean Square Error by Region')
ax2.set_xticks(x)
ax2.set_xticklabels(models, rotation=45, ha='right')
ax2.legend()

for bar in bars3 + bars4:
    height = bar.get_height()
    ax2.annotate(f'{height:.1f}', xy=(bar.get_x() + bar.get_width()/2, height),
                 xytext=(0, 3), textcoords='offset points', ha='center', va='bottom', fontsize=9)

plt.tight_layout()
plt.savefig("rmse_validation.png", dpi=600)
#plt.show()
