WITH ranking AS (
SELECT s.customer_id, order_date, product_name, join_date,
RANK() OVER(PARTITION BY s.customer_id ORDER BY order_date DESC) AS ranking,
ROW_NUMBER() OVER(PARTITION BY s.customer_id ORDER BY order_date DESC) AS rn
FROM sales s
JOIN members mem ON mem.customer_id = s.customer_id
JOIN menu m ON m.product_id = s.product_id
WHERE order_date < join_date
)
SELECT customer_id, product_name
FROM ranking
WHERE ranking = 1
