SELECT COUNT(product_name) AS count, product_name
FROM sales s
JOIN menu m ON s.product_id = m.product_id
GROUP BY product_name
ORDER BY count DESC
LIMIT 1