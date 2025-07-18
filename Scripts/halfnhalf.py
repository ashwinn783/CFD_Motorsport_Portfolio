import os
from PIL import Image

# Define the paths for the input folders and the output folder
folder1 = "E:/Aero/Simulations/CFD Tool/finished/LES/CpT_x-Section"  # Folder containing the first set of images
folder2 = "E:/Aero/Simulations/CFD Tool/finished/LES/CpT_Mean_x-Section"  # Folder containing the second set of images
output_folder = "output_folder"  # Folder to save the combined images

# Create the output folder if it doesn't exist
os.makedirs(output_folder, exist_ok=True)

# Get the list of images from both folders
images1 = sorted(os.listdir(folder1))
images2 = sorted(os.listdir(folder2))

# Check if both folders have the same number of images
if len(images1) != len(images2):
    print("Warning: The folders have different numbers of images!")

# Process each pair of images
for img1_name, img2_name in zip(images1, images2):
    # Construct full file paths
    img1_path = os.path.join(folder1, img1_name)
    img2_path = os.path.join(folder2, img2_name)

    # Open both images
    image1 = Image.open(img1_path)
    image2 = Image.open(img2_path)

    # Ensure both images are the same size (resize them to match if necessary)
    image1 = image1.resize((min(image1.width, image2.width), min(image1.height, image2.height)))
    image2 = image2.resize((image1.width, image1.height))

    # Calculate the midpoint for vertical splitting
    mid_x = image1.width // 2

    # Split the images in half
    left_half = image1.crop((0, 0, mid_x, image1.height))
    right_half = image2.crop((mid_x, 0, image2.width, image2.height))

    # Create a new image and paste the halves together
    new_image = Image.new("RGB", (image1.width, image1.height))
    new_image.paste(left_half, (0, 0))
    new_image.paste(right_half, (mid_x, 0))

    # Save the new image to the output folder
    new_image.save(os.path.join(output_folder, f"combined_{img1_name}"))

print("Image processing complete!")
