import matplotlib.pyplot as plt

# Font size dictionary
font_sizes = {
    "title": 20,
    "label": 16,
    "ticks": 14,
    "annot": 15
}

# Turbulence models
models = [
    r"Realizable $k$–$\epsilon$",
    r"$k$–$\epsilon$ Lag EB",
    r"$k$–$\omega$ SST ($a_1$=0.31)",
    r"$k$–$\omega$ SST ($a_1$=1.0)",
    r"$k$–$\omega$ SST URANS",
    "DES",
    "LES"
]

# CoP values (% front)
cop_values = [50.3, 47.4, 48.7, 48.8, 48.7, 47.9, 47.9]

# Plot
plt.figure(figsize=(12, 6))
bars = plt.bar(models, cop_values, color='skyblue')

# Annotate bars
for bar, value in zip(bars, cop_values):
    plt.text(bar.get_x() + bar.get_width() / 2, value + 0.2, f'{value:.1f}',
             ha='center', va='bottom', fontsize=font_sizes["annot"])

# Axes & grid
plt.ylabel('CoP (% Front)', fontsize=font_sizes["label"])
plt.xticks(rotation=30, ha='right', fontsize=font_sizes["ticks"])
plt.yticks(fontsize=font_sizes["ticks"])
# plt.title('Center of Pressure by Turbulence Model', fontsize=font_sizes["title"])
plt.grid(axis='y', linestyle='--', alpha=0.6)
plt.tight_layout()

# Save high-resolution
plt.savefig("cop.png", dpi=600, bbox_inches='tight')
#plt.savefig("center_of_pressure.pdf", bbox_inches='tight')
# plt.show()  # Uncomment to display
