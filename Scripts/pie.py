import matplotlib.pyplot as plt
from matplotlib.patches import Patch
import seaborn as sns

# Use seaborn theme
sns.set_theme(style="whitegrid")

# Font size settings
title_fontsize = 16
label_fontsize = 16
legend_fontsize = 16
legend_title_fontsize = 18

# Data
labels = [
    'Business Plan (75)', 'Cost & Manufacturing (100)', 'Engineering Design (150)',
    'Skidpad (50)', 'DV Skidpad (75)', 'Acceleration (50)', 'DV Acceleration (75)',
    'Autocross (100)', 'Endurance (250)', 'Efficiency (75)'
]

points = [75, 100, 150, 50, 75, 50, 75, 100, 250, 75]

# Colors: blue for static, red for dynamic
colors = [
    '#66b3ff', '#66b3ff', '#66b3ff',     # Static Events
    '#ff9999', '#ff9999', '#ff9999',     # Dynamic Events
    '#ff9999', '#ff9999', '#ff9999', '#ff9999'
]

# Create the pie chart
fig, ax = plt.subplots(figsize=(10, 8))
wedges, texts = ax.pie(points, labels=labels, colors=colors, startangle=140)

# Apply label font size
for text in texts:
    text.set_fontsize(label_fontsize)

# Add legend outside the plot
legend_elements = [
    Patch(facecolor='#66b3ff', edgecolor='black', label='Static Events'),
    Patch(facecolor='#ff9999', edgecolor='black', label='Dynamic Events')
]
ax.legend(
    handles=legend_elements,
    title='Event Type',
    loc='center left',
    bbox_to_anchor=(0, 1),
    fontsize=legend_fontsize,
    title_fontsize=legend_title_fontsize
)

# Add title (optional)
#plt.title('Formula Student Event Scoring Breakdown (Total: 1000 Points)',fontsize=title_fontsize, weight='bold', pad=20)

plt.tight_layout()
plt.savefig("fs_scoring_pie_chart.png", dpi=600, bbox_inches='tight')
