import matplotlib.pyplot as plt
import numpy as np

# Font sizes
font_sizes = {
    "title": 20,
    "label": 16,
    "ticks": 14,
    "legend": 14,
    "annot": 14
}

# Data
models = [
    r"Realizable $k-\epsilon$",
    r"$k-\epsilon$ Lag EB",
    r"$k$-$\omega$ SST ($a_1$=0.31)",
    r"$k$-$\omega$ SST ($a_1$=1.0)",
    r"$k$-$\omega$ SST URANS", "DES", "LES"
]

Mx = [-0.18, -0.55, -10.8, -2.0, 0.05, -1.42, -2.33]
My = [618.59, 597.66, 499.57, 608.74, 633.29, 594.09, 638.94]
Mz = [0.80, 0.18, 4.69, 0.96, 0.12, -1.03, -3.64]

# Normalize
def normalize(data):
    max_val = max(abs(min(data)), abs(max(data)))
    return [x / max_val for x in data]

Mx_norm = normalize(Mx)
My_norm = normalize(My)
Mz_norm = normalize(Mz)

# Plotting
x = np.arange(len(models))
width = 0.25

fig, ax = plt.subplots(figsize=(14, 6))

# Bars
ax.bar(x - width, Mx_norm, width, label='Mx', color='tab:blue')
ax.bar(x, My_norm, width, label='My', color='tab:orange')
ax.bar(x + width, Mz_norm, width, label='Mz', color='tab:green')

# Labels
ax.set_ylabel('Normalized Moment Value', fontsize=font_sizes["label"])
ax.set_xticks(x)
ax.set_xticklabels(models, fontsize=font_sizes["ticks"], rotation=15)
ax.set_yticks(np.linspace(-1, 1, 9))
ax.tick_params(axis='y', labelsize=font_sizes["ticks"])
ax.legend(fontsize=font_sizes["legend"])
ax.grid(axis='y', linestyle='--', alpha=0.6)

# Annotate values
for offset, data in zip([-width, 0, width], [Mx_norm, My_norm, Mz_norm]):
    for i, val in enumerate(data):
        ax.annotate(f'{val:.2f}', (x[i] + offset, val),
                    textcoords="offset points", xytext=(0, 4 if val >= 0 else -12),
                    ha='center', fontsize=font_sizes["annot"])

plt.tight_layout()

# Save outputs
plt.savefig("moments.png", dpi=600, bbox_inches='tight')
#plt.savefig("normalized_moments.pdf", bbox_inches='tight')
# plt.show()  # Uncomment to display plot
