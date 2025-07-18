import os
from PIL import Image

# Folder where your images are stored
folder_path = 'E:/Master Thesis/Thesis images'  # <-- Replace this with your actual folder path

# Specific image order for 2 columns × 3 rows
ordered_files = [
  #  'realkeps_rear.png',
  #  'lageb_rear.png',
  #  'sst031_rear.png',
   # 'sst100_rear.png',
   # 'urans_rear.png',
  #  'des_rear.png',
  #  'les_rear.png'
  '1_1.png',
  '1_2.png'
]

# Load images
images = [Image.open(os.path.join(folder_path, f)) for f in ordered_files]

# Resize all images to match the first image size (optional)
img_width, img_height = images[0].size
images = [img.resize((img_width, img_height)) for img in images]

# Collage size: 2 columns, 3 rows
collage_width = img_width * 1
collage_height = img_height * 2
collage = Image.new('RGB', (collage_width, collage_height), color='white')

# Paste images in 2 columns × 3 rows
for idx, img in enumerate(images):
    x = (idx % 2) * img_width
    y = (idx // 2) * img_height
    collage.paste(img, (x, y))

# Save collage
output_path = os.path.join(folder_path, 'lines.png')
collage.save(output_path)
print(f"Collage saved to {output_path}")
