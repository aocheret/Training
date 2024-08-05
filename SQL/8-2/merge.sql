INSERT INTO customer_backup (cid, name, email, lastChange)
SELECT cid, name, email, lastChange
FROM customer.customers
ON DUPLICATE KEY UPDATE
    name = VALUES(name),
    email = VALUES(email),
    lastChange = VALUES(lastChange)
