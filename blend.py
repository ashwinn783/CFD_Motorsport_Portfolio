from PIL import Image
import os

# CONFIG
input_dir = "E:/Master Thesis/Animations/raw/DES/vor1"  # Directory with original images
output_dir = "E:/Master Thesis/Animations/raw/DES/vor1/blended_frames"  # Output directory
frames_between = 5  # Number of crossfade frames between originals

# Create output directory
os.makedirs(output_dir, exist_ok=True)

# Get and sort image filenames
images = sorted([f for f in os.listdir(input_dir) if f.endswith(".png")])

output_index = 0

for i in range(len(images) - 1):
    img1 = Image.open(os.path.join(input_dir, images[i])).convert("RGBA")
    img2 = Image.open(os.path.join(input_dir, images[i + 1])).convert("RGBA")

    # Save current original frame with clean name
    img1.save(os.path.join(output_dir, f"frame_{output_index:04d}.png"))
    output_index += 1

    # Generate intermediate blended frames
    for j in range(1, frames_between + 1):
        alpha = j / (frames_between + 1)
        blended = Image.blend(img1, img2, alpha)
        blended.save(os.path.join(output_dir, f"frame_{output_index:04d}.png"))
        output_index += 1

# Save the last original frame
img2.save(os.path.join(output_dir, f"frame_{output_index:04d}.png"))

print(f"✅ Done. {output_index + 1} frames written to: {output_dir}")
