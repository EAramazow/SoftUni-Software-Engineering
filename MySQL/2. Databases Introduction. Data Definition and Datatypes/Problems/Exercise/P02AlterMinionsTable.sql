
ALTER TABLE `minions`
ADD COLUMN `town_id` INT,
ADD CONSTRAINT `fk_minions_towns`
 FOREIGN KEY `minions` (`town_id`)
 REFERENCES `towns`(`id`);