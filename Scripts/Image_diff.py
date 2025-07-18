import cv2
import numpy as np
import os

# Paths to image folders
image1_folder = "E:/Aero/Simulations/CFD Tool/finished/sigma_base/Cp_x-Section" 
image2_folder = "E:/Aero/Simulations/CFD Tool/finished/fw8/Cp_x-Section" 
output_folder = "output_folder"  

# Create output folder if it doesn't exist
os.makedirs(output_folder, exist_ok=True)

# Get list of image files (assuming they are named consistently)
image1_files = sorted(os.listdir(image1_folder))
image2_files = sorted(os.listdir(image2_folder))

# Ensure same number of files in both folders
if len(image1_files) != len(image2_files):
    raise ValueError("Mismatch in the number of images in both folders.")

# Process each pair of images
for img1_name, img2_name in zip(image1_files, image2_files):
    img1_path = os.path.join(image1_folder, img1_name)
    img2_path = os.path.join(image2_folder, img2_name)

    # Load images
    img1 = cv2.imread(img1_path)
    img2 = cv2.imread(img2_path)

    # Ensure both images exist and have the same dimensions
    if img1 is None or img2 is None:
        print(f"Skipping {img1_name} and {img2_name} due to missing file.")
        continue
    if img1.shape != img2.shape:
        print(f"Skipping {img1_name} and {img2_name} due to dimension mismatch.")
        continue

    # Compute absolute difference
    diff = cv2.absdiff(img1, img2)

    # Convert to grayscale
    gray_diff = 2*cv2.cvtColor(diff, cv2.COLOR_BGR2GRAY)

    # Apply a heatmap to enhance differences
    heatmap = cv2.applyColorMap(gray_diff, cv2.COLORMAP_PLASMA)

    # Keep black pixels black
    mask = np.all(img2 == [0, 0, 0], axis=-1)  # Find black pixels in image2
    heatmap[mask] = [0, 0, 0]  # Set them to black in the heatmap

    # Save the difference image
    output_path = os.path.join(output_folder, f"diff_{img1_name}")
    cv2.imwrite(output_path, heatmap)

    print(f"Saved: {output_path}")

print("Processing complete!")
