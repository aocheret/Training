import mysql.connector
from tabulate import tabulate


db = mysql.connector.connect(
    host = "localhost",
    user = "root",
    passwd = "Andro99@MY",
    database = "challenge1"
)

cursor = db.cursor()


#Display sales table data on screen
def display():
    sales_query = "SELECT * FROM sales"
    cursor.execute(sales_query)
    rows = cursor.fetchall()
    column_names = [i[0] for i in cursor.description]
    print(tabulate(rows, headers=column_names, tablefmt='psql'))


display()
old_count = cursor.rowcount


#Insert row in sales table but collecting data from user
new_row = input("Do you want to input a new row?(y/n): ")
while new_row == "y":
    print("Input new row")
    customer_id = input("Customer ID: ")
    order_date = input("Order Date (YYYY-MM-DD): ")
    product_id = input("Product ID: ")

    insert_query = "INSERT INTO sales (customer_id, order_date, product_id) VALUES (%s, %s, %s)"
    cursor.execute(insert_query, (customer_id, order_date, product_id))
    db.commit()

    new_row = input("Do you want to input another row?(y/n): ")


display()
print(cursor.rowcount - old_count, "row(s) inserted.")

cursor.close()
db.close()


