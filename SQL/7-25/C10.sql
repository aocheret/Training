SELECT s.customer_id,
SUM(CASE
WHEN order_date BETWEEN mem.join_date AND DATE_ADD(mem.join_date, INTERVAL 6 DAY) THEN price * 10 * 2
WHEN product_name = 'sushi' THEN price * 10 * 2
ELSE price * 10
END) as points
FROM menu m
JOIN sales s ON s.product_id = m.product_id
JOIN members mem ON mem.customer_id = s.customer_id
GROUP BY customer_id