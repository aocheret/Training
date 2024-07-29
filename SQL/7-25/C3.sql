WITH FirstPurch AS (
SELECT customer_id, MIN(order_date) AS first_order_date
FROM sales
GROUP BY customer_id),
FirstItem AS (
SELECT s.customer_id, s.product_id, m.product_name, ROW_NUMBER() OVER (PARTITION BY s.customer_id ORDER BY s.order_date, s.product_id) as row_num
FROM sales s
JOIN menu m ON s.product_id = m.product_id
JOIN FirstPurch fp ON s.customer_id = fp.customer_id AND s.order_date = fp.first_order_date
)
SELECT customer_id, product_id, product_name
FROM FirstItem
WHERE row_num = 1;