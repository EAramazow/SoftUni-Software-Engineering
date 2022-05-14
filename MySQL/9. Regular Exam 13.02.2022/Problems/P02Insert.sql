INSERT INTO reviews (content,picture_url, published_at, rating)
SELECT LEFT(p.description, 15), REVERSE(p.name), '2010-10-10',  ROUND(price / 8, 2)  
FROM products AS p
WHERE p.id >=5;