import cv2
import os
import glob

# Settings
image_folder = 'E:/Master Thesis/Yaw/Straight/lagEB/Images'  # Folder where images are stored
output_video = 'output.mp4'
image_pattern = 'image-*.png'
frame_rate = 1  # frames per second; change to 2 or more if needed

# Get sorted list of images
image_files = sorted(glob.glob(os.path.join(image_folder, image_pattern)))

# Read first image to get dimensions
first_image = cv2.imread(image_files[0])
height, width, _ = first_image.shape

# Define video writer
fourcc = cv2.VideoWriter_fourcc(*'mp4v')  # or 'XVID' for .avi
video_writer = cv2.VideoWriter(output_video, fourcc, frame_rate, (width, height))

# Write each image to video
# Write each image to video
for i, file in enumerate(image_files):
    img = cv2.imread(file)
    if img.shape[:2] != (height, width):
        img = cv2.resize(img, (width, height))

    video_writer.write(img)

    # If it's the last frame, write it multiple times to extend duration
    if i == len(image_files) - 1:
        extra_seconds = 2  # How many extra seconds to show last frame
        extra_frames = int(extra_seconds * frame_rate)
        for _ in range(extra_frames):
            video_writer.write(img)


video_writer.release()
print(f"✅ Video saved as: {output_video}")
