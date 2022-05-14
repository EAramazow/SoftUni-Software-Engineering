SELECT 
    *
FROM
    `towns`
WHERE
    `name` NOT REGEXP '^[RrBbDd]'
ORDER BY `name` ASC;

-- second way

SELECT 
    *
FROM
    `towns`
WHERE
    LOWER(`name`) NOT LIKE 'r%'
	AND LOWER(`name`) NOT LIKE 'b%'
	AND LOWER(`name`) NOT LIKE 'd%'
ORDER BY `name` ASC;