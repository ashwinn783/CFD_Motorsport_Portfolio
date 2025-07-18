import os
import cv2
import glob

input_folder = "cropped"
output_folder = "renamed"
os.makedirs(output_folder, exist_ok=True)

# Sort files numerically by the number after "combined_"
files = sorted(glob.glob(os.path.join(input_folder, "combined_*.png")),
               key=lambda f: int(os.path.basename(f).split("_")[1]))

for i, filepath in enumerate(files, 1):
    new_filename = f"image-{i:05d}.jpg"
    new_path = os.path.join(output_folder, new_filename)

    # Read and save as JPEG
    img = cv2.imread(filepath)
    cv2.imwrite(new_path, img)

print("✔ Images renamed and converted to JPG for ffmpeg.")
