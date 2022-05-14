TABLE `people`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` LONGBLOB ,
`height` DOUBLE (5,2) ,
`weight` DOUBLE (5,2) ,
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` LONGTEXT
);

INSERT INTO `people` (`id`, `name`, `picture`, `height`, `weight`, `gender`, `birthdate`, `biography`)
VALUES (1, 'Emil', NULL, 179, 76, 'm', '1993-10-23', 'Hello there!'),
 (2, 'Emil', NULL, 179, 76, 'm', '1993-10-24', 'Hello there!'),
 (3, 'Ivan', NULL, 179, 76, 'm', '1993-10-25', 'Hello there!'),
 (4, 'Petkan', NULL, 179, 76, 'm', '1993-10-26', 'Hello there!'),
 (5, 'Dragan', NULL, 179, 76, 'm', '1993-10-27', 'Hello there!');

