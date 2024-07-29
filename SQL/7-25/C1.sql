SELECT s.customer_id, SUM(m.price) AS total_amount
FROM sales s JOIN menu m ON s.product_id = m.product_id
GROUP by s.customer_id