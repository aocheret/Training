SELECT s.customer_id, COUNT(product_name) AS total_items, SUM(price) AS total_amount
FROM sales s
JOIN members mem ON mem.customer_id = s.customer_id
JOIN menu m ON m.product_id = s.product_id
WHERE order_date < join_date
GROUP BY s.customer_id

