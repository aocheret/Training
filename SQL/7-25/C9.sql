SELECT customer_id,
SUM(CASE
WHEN product_name = 'sushi' THEN price * 10 * 2
ELSE price * 10
END) as points
FROM menu m
JOIN sales s ON s.product_id = m.product_id
GROUP BY customer_id