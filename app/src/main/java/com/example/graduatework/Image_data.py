import sqlite3
from tkinter import *
from tkinter import filedialog

root = Tk()

def filedialogs():
    global get_image
    get_image = filedialog.askopenfilenames(title="SELECT IMAGE", filetypes=(("png", "*.png"), ("jpg", "*.jpg"), ("Allfile", "*.*")))

def conver_image_into_binary(filename):
    with open(filename, 'rb') as file:
        photo_image = file.read()
    return photo_image

def insert_image():
    image_database = sqlite3.connect("museum.db")
    data = image_database.cursor()

    for image in get_image:
        inser_photo = conver_image_into_binary(image)
        data.execute("insert into Exhibit (PngExhibit) values(:image)",
                    {'image' : inser_photo})

        image_database.commit()
        image_database.close()

select_image = Button(root, text="Select image", command=filedialogs)
select_image.grid(row=0, column=0, pady=(100,0), padx=100)

save_image = Button(root, text="Save", command=insert_image)
save_image.grid(row=1, column=0)

root.mainloop()
