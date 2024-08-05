CREATE TABLE customer_backup LIKE customer.customers;
INSERT INTO customer_backup SELECT * FROM customer.customers;
