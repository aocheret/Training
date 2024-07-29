WITH ranking AS(
SELECT s.customer_id, m.product_name, COUNT(s.product_id) as count, DENSE_RANK() OVER (
PARTITION BY s.customer_id ORDER BY COUNT(s.product_id) DESC) AS ranking
FROM menu m
JOIN sales s ON s.product_id = m.product_id
GROUP BY s.customer_id, s.product_id, m.product_name)
SELECT customer_id, product_name, count
FROM ranking
WHERE ranking = 1
