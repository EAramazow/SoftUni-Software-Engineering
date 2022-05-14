DELIMITER $$

CREATE FUNCTION udf_customer_products_count (`name` VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN

RETURN (
SELECT COUNT(o.id) FROM customers AS c
JOIN 
orders AS o ON c.id = o.customer_id
JOIN 
orders_products AS op ON op.order_id = o.id
JOIN 
products AS p ON p.id = op.product_id
WHERE c.first_name = `name`
);

END $$
DELIMITER ;

SELECT c.first_name,c.last_name, udf_customer_products_count('Shirley') AS `total_products` FROM customers AS c
WHERE c.first_name = 'Shirley';
