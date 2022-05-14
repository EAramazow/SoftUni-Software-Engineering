SELECT 
    t.town_id, t.name, address_text
FROM
    addresses AS a
        JOIN
    towns AS t ON t.town_id = a.town_id
    WHERE t.name IN ('Sofia', 'San Francisco', 'Carnation')
    ORDER BY town_id ASC, a.address_id;
    
    
    /*
    SELECT 
    t.town_id, t.name, address_text
FROM
    addresses AS a
        JOIN
    towns AS t
    USING (town_id)
    WHERE t.name IN ('Sofia', 'San Francisco', 'Carnation')
        ORDER BY town_id ASC, a.address_id;

    
    */