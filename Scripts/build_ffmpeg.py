import os

num_images = 5  # Change this if needed
image_pattern = "image-%04d.png"
image_duration = 2  # seconds each image is shown
fade_duration = 1   # seconds to fade

inputs = []
for i in range(num_images):
    inputs.append(f"-loop 1 -t {image_duration} -i {image_pattern % (i + 1)}")

filter_steps = []
for i in range(num_images - 1):
    input_a = "[0:v]" if i == 0 else f"[v{i}]"
    input_b = f"[{i+1}:v]"
    output = f"[v{i+1}]"
    offset = (image_duration - fade_duration) * (i + 1)
    filter_steps.append(f"{input_a}{input_b}xfade=transition=fade:duration={fade_duration}:offset={offset}{output}")

# Build command
input_string = " \\\n    ".join(inputs)
filter_string = ";\n    ".join(filter_steps)
final_output = f"[v{num_images - 1}]"

command = f"""ffmpeg \\
    {input_string} \\
    -filter_complex "
    {filter_string}
    " -map "{final_output}" -c:v libx264 -pix_fmt yuv420p output.mp4"""

print("Copy and run the following in PowerShell or Bash:\n")
print(command)
