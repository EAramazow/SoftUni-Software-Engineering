SELECT 
    r.id, r.content, r.rating, r.picture_url, r.published_at
FROM
    reviews AS r
WHERE
    content LIKE 'My%'
        AND CHAR_LENGTH(content) > 61
ORDER BY rating DESC;