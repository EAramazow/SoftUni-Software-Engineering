SELECT 
    `department_id`, ROUND(MIN(`salary`), 2) AS `min salary`
FROM
    `employees`
GROUP BY `department_id`
HAVING `min salary` > 800;
