CREATE DATABASE `soft_uni`;
USE `soft_uni`;

CREATE TABLE `towns` (
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`name` VARCHAR(50)
);

INSERT INTO `towns` (`name`)
VALUES ('Sofia'),
 ('Plovdiv'),
 ('Varna'),
 ('Burgas');

CREATE TABLE `addresses` (
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`address_text` TEXT,
`town_id` INT
);

CREATE TABLE `departments` (
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`name` VARCHAR (50)
);

INSERT INTO `departments` (`name`)
VALUES ('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`first_name` VARCHAR (50),
`middle_name` VARCHAR (50),
`last_name` VARCHAR (50),
`job_title` VARCHAR (50),
`department_id` INT,
`hire_date` DATE,
`salary` DOUBLE,
`address_id` INT,
CONSTRAINT fk_employees_departments
FOREIGN KEY `employees`(`department_id`)
REFERENCES `departments`(`id`),
CONSTRAINT fk_employees_addresses
FOREIGN KEY `employees`(`address_id`)
REFERENCES `addresses`(`id`)
);

INSERT INTO `employees` (`first_name`, `middle_name`, `last_name`, `job_title`, `department_id`, `hire_date`, `salary`)
VALUES ('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', '4', '2013-02-01', '3500.00'),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', '1', '2004-03-02', '4000.00'),
('Maria', 'Petrova', 'Ivanova', 'Intern', '5', '2016-08-28', '525.25'),
('Georgi', 'Terziev', 'Ivanov', 'CEO', '2', '2007-12-09', '3000.00'),
('Peter', 'Pan', 'Pan', 'Intern', '3', '2016-08-28', '599.88');

