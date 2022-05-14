UPDATE products AS p 
SET 
    p.quantity_in_stock = p.quantity_in_stock - 5
WHERE
    p.quantity_in_stock >= 60
        AND p.quantity_in_stock <= 70;