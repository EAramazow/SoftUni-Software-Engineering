ALTER TABLE `products`
ADD CONSTRAINT `cats_fk`
FOREIGN KEY (`category_id`)
REFERENCES `categories` (`id`);	