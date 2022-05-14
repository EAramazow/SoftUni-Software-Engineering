DELIMITER $$

CREATE PROCEDURE udp_reduce_price(category_name VARCHAR(50))
BEGIN
	UPDATE products AS p
        JOIN
    categories AS c ON c.id = p.category_id
        JOIN
    reviews AS r ON r.id = p.review_id 
SET 
    p.price = p.price * 0.7
WHERE
    r.rating < 4 AND c.name = category_name;
END$$

DELIMITER ;

CALL udp_reduce_price('Phones and tablets');

SELECT * 
FROM `products` AS `p`
JOIN `categories` AS `c` ON `p`.`category_id` = `c`.`id`
WHERE `c`.`name` = 'Phones and tablets';