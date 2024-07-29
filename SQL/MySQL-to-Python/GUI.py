import mysql.connector
import tkinter as tk
from tkinter import ttk
from tkinter import messagebox
from PIL import Image, ImageTk


db = mysql.connector.connect(
    host = "localhost",
    user = "root",
    passwd = "Andro99@MY",
    database = "challenge1"
)

cursor = db.cursor()


#Display sales table data on screen
def display():
    image_label.pack_forget()
    for widget in content_frame.winfo_children():
        widget.destroy()

    sales_query = "SELECT * FROM sales"
    cursor.execute(sales_query)
    rows = cursor.fetchall()
    column_names = [i[0] for i in cursor.description]

    tree = ttk.Treeview(content_frame, columns=column_names, show='headings')
    for col in column_names:
        tree.heading(col, text=col)
        tree.column(col, width=100)
    tree.pack(pady=10, padx=10, fill=tk.BOTH, expand=True)

    for row in rows:
        tree.insert("", "end", values=row)


#Insert row in sales table but collecting data from user
def insert(customer_id, order_date, product_id):
    insert_query = "INSERT INTO sales (customer_id, order_date, product_id) VALUES (%s, %s, %s)"
    cursor.execute(insert_query, (customer_id, order_date, product_id))
    db.commit()
    messagebox.showinfo("Information", "Data successfully inserted!")


def open_form():
    image_label.pack_forget()
    for widget in content_frame.winfo_children():
        widget.destroy()

    tk.Label(content_frame, text="customer_id").grid(row=0, column=0, padx=10, pady=10)
    customer_id_en = tk.Entry(content_frame)
    customer_id_en.grid(row=1, column=0, padx=10, pady=10, sticky="ew")

    tk.Label(content_frame, text="order_date").grid(row=0, column=1, padx=10, pady=10)
    order_date_en = tk.Entry(content_frame)
    order_date_en.grid(row=1, column=1, padx=10, pady=10, sticky="ew")

    tk.Label(content_frame, text="product_id").grid(row=0, column=2, padx=10, pady=10)
    product_id_en = tk.Entry(content_frame)
    product_id_en.grid(row=1, column=2, padx=10, pady=10, sticky="ew")

    def on_click():
        customer_id = customer_id_en.get()
        order_date = order_date_en.get()
        product_id = product_id_en.get()

        insert(customer_id, order_date, product_id)

        customer_id_en.delete(0, tk.END)
        order_date_en.delete(0, tk.END)
        product_id_en.delete(0, tk.END)

    insert_button = tk.Button(content_frame, text="Insert", command=on_click)
    insert_button.grid(row=2, columnspan=3, pady=10, sticky="ew")


root = tk.Tk()
root.title("My DB")

window_width = 600
window_height = 400
root.geometry(f"{window_width}x{window_height}")

button_frame = tk.Frame(root)
button_frame.pack(side=tk.TOP, pady=10)

table_button = tk.Button(button_frame, text="Show Table", command=display)
table_button.pack(side=tk.LEFT, padx=10)

form_button = tk.Button(button_frame, text="Open Form", command=open_form)
form_button.pack(side=tk.LEFT, padx=10)

image = Image.open("img/mysql.png")
img_height = int(image.size[1]/image.size[0]*window_width)
resized_image = image.resize((window_width, img_height), Image.LANCZOS)
photo = ImageTk.PhotoImage(resized_image)
image_label = tk.Label(root, image=photo)
image_label.pack(fill=tk.BOTH, expand=True, pady=10)

content_frame = tk.Frame(root)
content_frame.pack(fill=tk.BOTH, expand=True, padx=20)

content_frame.grid_columnconfigure(0, weight=1)
content_frame.grid_columnconfigure(1, weight=1)
content_frame.grid_columnconfigure(2, weight=1)

root.mainloop()

cursor.close()
db.close()
