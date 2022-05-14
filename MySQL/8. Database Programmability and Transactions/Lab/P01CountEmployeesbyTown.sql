DELIMITER ###

CREATE FUNCTION udf_count_employees_in_city	(city_name VARCHAR(100)) 
RETURNS INT
DETERMINISTIC

BEGIN
RETURN
(SELECT COUNT(*)	 
FROM towns AS t 
LEFT JOIN addresses AS a ON t.town_id = a.town_id
LEFT JOIN employees AS e ON e.address_id = a.address_id
WHERE t.name = city_name);
END
###
DELIMITER ;