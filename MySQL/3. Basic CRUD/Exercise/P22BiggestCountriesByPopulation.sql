SELECT 
    `country_name`, `population`
FROM
    `countries`
WHERE
    `continent_code` = 'EU'
ORDER BY `countries`.`population` DESC , `country_name`
LIMIT 30;