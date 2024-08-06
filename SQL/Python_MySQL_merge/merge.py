import mysql.connector
from tabulate import tabulate


db = mysql.connector.connect(
    host = "localhost",
    user = "root",
    passwd = "Andro99@MY",
    database = "customer"
)

cursor = db.cursor()
# back_up_cr = "CREATE TABLE customer.python_customer_backup LIKE customer.customers"
# cursor.execute(back_up_cr)
#
# back_up_in = "INSERT INTO customer.python_customer_backup SELECT * FROM customer.customers"
# cursor.execute(back_up_in)
#
def display():
    display_query = "SELECT * FROM customer.python_customer_backup"
    cursor.execute(display_query)
    rows = cursor.fetchall()
    column_names = [i[0] for i in cursor.description]
    print(tabulate(rows, headers=column_names, tablefmt='psql'))
#
# display()
#
# db.commit()
# cursor.close()
# db.close()

########## INSERT, UPDATE, DELETE customers table in SQL #########

print("Before merge")
display()

merge = """
INSERT INTO python_customer_backup (cid, name, email, lastChange)
SELECT cid, name, email, lastChange
FROM customer.customers
ON DUPLICATE KEY UPDATE
    name = VALUES(name),
    email = VALUES(email),
    lastChange = VALUES(lastChange);
"""
cursor.execute(merge)
db.commit()

print("After merge")
display()

cursor.close()
db.close()