WITH dept_avg_sal AS (
	SELECT dept_id, AVG(salary) AS avg_salary
    FROM employees
    GROUP BY dept_id
    )
SELECT e.f_name, e.l_name, e.salary, d.dept_name
FROM employees e
JOIN dept_avg_sal a ON e.dept_id = a.dept_id
JOIN departments d ON e.dept_id = d.dept_id
WHERE e.salary > a.avg_salary