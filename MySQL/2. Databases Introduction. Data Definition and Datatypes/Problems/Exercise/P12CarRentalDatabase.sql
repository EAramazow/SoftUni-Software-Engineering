CREATE SCHEMA `car_rental`;
USE `car_rental`;

CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`category` VARCHAR(50) NOT NULL,
`daily_rate` DOUBLE,
`weekly_rate` DOUBLE,
`monthly_rate` DOUBLE,
`weekend_rate` DOUBLE
);

INSERT INTO `categories` (`id`, `category`, `daily_rate`, `monthly_rate`)
VALUES (1, 'SUV1', 8.2, 8.2),
(2, 'SUV2', 8.2, 8.2),
(3, 'SUV3', 8.2, 8.2);

CREATE TABLE `cars` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`plate_number` VARCHAR(50),
`make` VARCHAR(50),
`model` VARCHAR (30),
`car_year` YEAR,
`category_id` INT,
`doors` INT,
`picture` BLOB,
`car_condition` TEXT,
`available` BOOLEAN
);

INSERT INTO `cars` (`plate_number`, `make`, `model`, `doors`, `available`)
VALUES ('PB1111PB', 'AUDI', 'Q8', 5, TRUE),
('PB2222PB', 'AUDI', 'Q7', 5, TRUE),
('PB3333PB', 'AUDI', 'Q5', 5, TRUE);

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR (50),
`last_name` VARCHAR (50),
`title` VARCHAR(50),
`notes` TEXT
);

INSERT INTO `employees` (`first_name`, `last_name`, `title`)
VALUES ('Emil', 'Emilov', 'title'),
('Emil2', 'Emilov2', 'title'),
('Emil3', 'Emilov3', 'title');



CREATE TABLE `customers` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`driver_license_number` VARCHAR(50),
`full_name` VARCHAR (50),
`address` VARCHAR (50),
`city` VARCHAR (50),
`zip_code` INT,
`notes` TEXT
);

INSERT INTO `customers` (`driver_license_number`, `full_name`)
VALUES ('123ABC', 'Emil Emilov'),
('231ABC', 'Emil Emilov2'),
('312ABC', 'Emil Emilov3');

CREATE TABLE `rental_orders` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`employee_id` INT NOT NULL,
`customer_id` INT NOT NULL,
`car_id` INT NOT NULL,
`car_condition` VARCHAR(50),
`tank_level` INT ,
`kilometrage_start` INT ,
`kilometrage_end` INT ,
`total_kilometrage` INT ,
`start_date` DATETIME ,
`end_date` DATETIME ,
`total_days` INT ,
`rate_applied` DOUBLE,
`tax_rate` DOUBLE,
`order_status` VARCHAR(50),
`notes` TEXT
);

INSERT INTO `rental_orders` (`employee_id`, `customer_id`, `car_id`, `total_days`)
VALUES
(1, 1, 1, 10),
(1, 1, 1, 10),
(1, 1, 1, 10);



