SELECT 
    COUNT(*) AS no_manager
FROM
    employees
WHERE
    manager_id IS NULL;