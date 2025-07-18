import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

# Load merged CSV
df = pd.read_csv("Rear_Wing_Comparison_All_Models.csv")

# Define the Z‐planes, model lists, and colors
planes = [0.735, 0.810, 0.885]
steady_models   = ["Realizable k-ε", "k-ε Lag EB", "k-ω SST (a₁=0.31)", "k-ω SST (a₁=1.0)"]
unsteady_models = ["LES", "DES", "URANS"]

colors = {
    "Experimental":      "k",
    "LES":               "red",
    "DES":               "blue",
    "URANS":             "green",
    "Realizable k-ε":    "#9467bd",
    "k-ε Lag EB":        "#ff7f0e",
    "k-ω SST (a₁=0.31)": "#8c564b",
    "k-ω SST (a₁=1.0)":  "#17becf"
}

def prepare_plane(Z):
    sub = df[np.isclose(df["Z (m)"], Z, atol=1e-3)]
    grp = (
        sub.groupby("Y (m)")
           .agg({
               "Pressure_Exp": "mean",
               "Std_Exp":      "mean",
               **{f"Pressure_{m}": "mean" for m in steady_models + unsteady_models},
               **{f"{m}_Std":       "mean" for m in unsteady_models}
           })
           .reset_index()
           .sort_values("Y (m)")            # <--- ensure sorted
    )
    return grp

# Plot Steady models
for Z in planes:
    grp = prepare_plane(Z)
    y     = grp["Y (m)"].to_numpy()
    p_exp = grp["Pressure_Exp"].to_numpy()

    plt.figure(figsize=(6,4))
    # Experimental
    plt.plot(y, p_exp, "--", c=colors["Experimental"], label="Exp", lw=1.5)
    plt.scatter(y, p_exp, c=colors["Experimental"], s=20)

    # Steady RANS
    for m in steady_models:
        plt.plot(
            y,
            grp[f"Pressure_{m}"].to_numpy(),
            "-",
            c=colors[m],
            label=m,
            lw=1.5
        )

    plt.title(f"Steady @ Z = {Z:.3f} m")
    plt.xlabel("Y (m)")
    plt.ylabel("Pressure (Pa)")
    plt.grid(ls="--", alpha=0.4)
    plt.legend(fontsize=8, ncol=1, loc="lower left")
    plt.tight_layout()
    plt.show()

# Plot Unsteady models
for Z in planes:
    grp = prepare_plane(Z)
    y     = grp["Y (m)"].to_numpy()
    p_exp = grp["Pressure_Exp"].to_numpy()
    s_exp = grp["Std_Exp"].to_numpy()

    plt.figure(figsize=(6,4))
    # Experimental ±1σ band
    plt.fill_between(y, p_exp - s_exp, p_exp + s_exp, color="gray", alpha=0.3)
    plt.plot(y, p_exp, "--", c=colors["Experimental"], lw=1.5)
    plt.scatter(y, p_exp, c=colors["Experimental"], s=20)

    # Unsteady
    for m in unsteady_models:
        pm = grp[f"Pressure_{m}"].to_numpy()
        plt.plot(y, pm, "-", c=colors[m], label=m, lw=1.5)
        if m == "LES":
            s = grp[f"{m}_Std"].to_numpy()
            plt.fill_between(y, pm - s, pm + s, color=colors[m], alpha=0.25)

    plt.title(f"Unsteady @ Z = {Z:.3f} m")
    plt.xlabel("Y (m)")
    plt.ylabel("Pressure (Pa)")
    plt.grid(ls="--", alpha=0.4)
    plt.legend(fontsize=8, ncol=1, loc="lower left")
    plt.tight_layout()
    plt.show()
