import cv2
import os

# Folder paths
input_folder = "E:/Master Thesis/output_folder"
output_folder = "images_output"
os.makedirs(output_folder, exist_ok=True)

# Define the region to cover (tweak based on your images)
# Example: top 10% of the image
def get_cover_region(image):
    h, w, _ = image.shape
    x1, y1 = 600, 0
    x2, y2 = w, int(0.1 * h)  # Cover top 10%
    return (x1, y1, x2, y2)

# Main loop
for filename in os.listdir(input_folder):
    if filename.lower().endswith(('.png', '.jpg', '.jpeg')):
        image_path = os.path.join(input_folder, filename)
        image = cv2.imread(image_path)

        x1, y1, x2, y2 = get_cover_region(image)

        # Get color from nearby region (you could also hardcode it)
        bg_color = image[y2 + 1, x1 + 1].tolist()

        # Fill the box with the background color
        cv2.rectangle(image, (x1, y1), (x2, y2), bg_color, thickness=-1)

        # Save the output
        output_path = os.path.join(output_folder, filename)
        cv2.imwrite(output_path, image)
        print(f"Cleaned {filename}")

print("All images processed.")
