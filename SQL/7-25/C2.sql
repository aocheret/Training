SELECT customer_id, COUNT(DISTINCT order_date) as visit_days
FROM sales 
GROUP BY customer_id