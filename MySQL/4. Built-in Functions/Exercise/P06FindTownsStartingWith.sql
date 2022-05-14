SELECT 
    *
FROM
    `towns`
WHERE
    `name` REGEXP '^[MmKkBbEe]'
ORDER BY `name` ASC;

-- second way

SELECT 
    *
FROM
    `towns`
WHERE
    LOWER(`name`) LIKE 'm%' 
    OR LOWER(`name`) LIKE 'b%' 
    OR LOWER(`name`) LIKE 'e%'
	OR LOWER (`name`) LIKE 'k%'
ORDER BY `name` ASC;