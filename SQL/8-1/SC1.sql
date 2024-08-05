WITH sal AS (
	SELECT f_name, l_name, salary,
    RANK() OVER (ORDER BY salary) AS rnk
    FROM employees
    )
SELECT f_name, l_name, salary
FROM sal
WHERE rnk = 2