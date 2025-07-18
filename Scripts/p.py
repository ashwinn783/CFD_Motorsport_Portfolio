import matplotlib.pyplot as plt

# Data
yaw_angle = [0, 2, 4, 6, 8]
cl = [-4.1647815, -3.9821235, -3.7750345, -3.55727, -3.211691]
cd = [-1.544143, -1.5369425, -1.4637025, -1.403284, -1.33048]
cs = [0.003480363, -0.1294951, -0.23057435, -0.3434945, -0.48485225]

# Plot Yaw Angle vs -Cl
plt.figure(figsize=(6, 4))
plt.plot(yaw_angle, [-val for val in cl], marker='o')
#plt.title('Yaw Angle vs Cl')
plt.xlabel('Yaw Angle (degrees)')
plt.ylabel('Cl')
plt.xticks(yaw_angle)  # Set x-ticks explicitly
plt.grid(True)
plt.tight_layout()
plt.show()

# Plot Yaw Angle vs -Cd
plt.figure(figsize=(6, 4))
plt.plot(yaw_angle, [-val for val in cd], marker='s')
#plt.title('Yaw Angle vs Cd')
plt.xlabel('Yaw Angle (degrees)')
plt.ylabel('Cd')
plt.xticks(yaw_angle)
plt.grid(True)
plt.tight_layout()
plt.show()

# Plot Yaw Angle vs -Cs
plt.figure(figsize=(6, 4))
plt.plot(yaw_angle, [-val for val in cs], marker='^')
#plt.title('Yaw Angle vs Cs')
plt.xlabel('Yaw Angle (degrees)')
plt.ylabel('Cs')
plt.xticks(yaw_angle)
plt.grid(True)
plt.tight_layout()
plt.show()
