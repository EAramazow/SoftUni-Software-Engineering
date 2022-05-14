CREATE VIEW `top_paid` AS
SELECT * FROM `employees`
WHERE `salary` > 2000;

SELECT * FROM `employees`
ORDER BY `salary` DESC
LIMIT 1;