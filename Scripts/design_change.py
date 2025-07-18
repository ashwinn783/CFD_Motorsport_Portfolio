from PIL import Image
import cv2
import numpy as np

# Load your images
rho_img = Image.open("rho2.png").convert("RGB")
sigma_img = Image.open("sigma2.png").convert("RGB")

# Resize to match
if rho_img.size != sigma_img.size:
    sigma_img = sigma_img.resize(rho_img.size)

# Video settings
video_path = "design_transition.mp4"
fps = 10
frame_size = rho_img.size
fourcc = cv2.VideoWriter_fourcc(*'mp4v')
video = cv2.VideoWriter(video_path, fourcc, fps, frame_size)

# Durations in seconds (to simulate slowing down)
switch_durations = [0.05, 0.07, 0.09, 0.12, 0.15, 0.20, 0.30, 0.40, 0.50, 1.0]

# Convert PIL to OpenCV format
def pil_to_cv(img):
    return cv2.cvtColor(np.array(img), cv2.COLOR_RGB2BGR)

# Add alternating frames with increasing hold
for duration in switch_durations:
    repeat = max(1, int(duration * fps))
    for _ in range(repeat):
        video.write(pil_to_cv(rho_img))
    for _ in range(repeat):
        video.write(pil_to_cv(sigma_img))

# Hold final frame longer
for _ in range(int(1.5 * fps)):
    video.write(pil_to_cv(sigma_img))

video.release()
