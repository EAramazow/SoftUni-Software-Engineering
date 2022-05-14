CREATE SCHEMA `movies`;
USE `movies`;

CREATE TABLE `directors` (
`id` INT PRIMARY KEY AUTO_INCREMENT ,
`director_name` VARCHAR(50) NOT NULL,
`notes` TEXT
);

INSERT INTO `directors` (`id`, `director_name`, `notes`)
VALUES (1, 'Emil Aramazov', 'notes'),
(2, 'Emil', 'notes'),
(3, 'Emil', 'notes'),
(4, 'Emil', 'notes'),
(5, 'Emil', 'notes');

CREATE TABLE `genres`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(50) NOT NULL,
`notes` TEXT
);

INSERT INTO `genres` (`id`, `genre_name`, `notes`)
VALUES (1, 'fantasy', 'notes'),
(2, 'fantasy', 'notes'),
(3, 'fantasy', 'notes'),
(4, 'fantasy', 'notes'),
(5, 'fantasy', 'notes');

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(50) NOT NULL,
`notes` TEXT
);

INSERT INTO `categories` (`id`, `category_name`, `notes`)
VALUES (1, 'best role', 'notes'),
(2, 'best role', 'notes'),
(3, 'best role', 'notes'),
(4, 'best role', 'notes'),
(5, 'best role', 'notes');

CREATE TABLE `movies` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(50) NOT NULL,
`director_id` INT,
`copyright_year` YEAR,
`length` TIME,
`genre_id` INT,
`category_id` INT,
`rating` DOUBLE ,
`notes` TEXT
);

INSERT INTO `movies` (`id`, `title`, `director_id`, `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`)
VALUES (1, 'Interstellar', 1, 2021, '01:50:00', 1, 1, 8.3, 'notes'),
(2, 'Interstellar', 1, 2021, '01:50:00', 1, 1, 8.3, 'notes'),
(3, 'Interstellar', 1, 2021, '01:50:00', 1, 1, 8.3, 'notes'),
(4, 'Interstellar', 1, 2021, '01:50:00', 1, 1, 8.3, 'notes'),
(5, 'Interstellar', 1, 2021, '01:50:00', 1, 1, 8.3, 'notes');
