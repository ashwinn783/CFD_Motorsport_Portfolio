import cv2
import os

# Parameters
input_folder = "output_folder"
output_folder = "cropped"
crop_pixels_top = 80  # crop amount from top
logo_box = (20, 20, 500, 300)  # original coordinates: (x1, y1, x2, y2)

# Ensure output directory exists
os.makedirs(output_folder, exist_ok=True)

# Process all image files
for filename in os.listdir(input_folder):
    if filename.lower().endswith((".png", ".jpg", ".jpeg")):
        path = os.path.join(input_folder, filename)
        img = cv2.imread(path)

        # Draw white rectangle BEFORE cropping
        x1, y1, x2, y2 = logo_box
        cv2.rectangle(img, (x1, y1), (x2, y2), (255, 255, 255), -1)

        # Now crop the image
        cropped = img[crop_pixels_top:, :]

        # Save the processed image
        out_path = os.path.join(output_folder, filename)
        cv2.imwrite(out_path, cropped)

print("✔ Batch processing complete. Logo covered and top cropped.")
