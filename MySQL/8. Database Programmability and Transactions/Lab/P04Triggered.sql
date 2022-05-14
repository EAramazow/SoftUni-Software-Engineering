CREATE TABLE `deleted_employees` (
    `employee_id` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `middle_name` VARCHAR(50) DEFAULT NULL,
    `job_title` VARCHAR(50) NOT NULL,
    `department_id` INT(10) NOT NULL,
    `salary` DECIMAL(19 , 4 ) NOT NULL
);

CREATE 
    TRIGGER  trigger_employee
 BEFORE DELETE ON employees FOR EACH ROW 
    INSERT INTO deleted_employees (first_name , last_name , middle_name , job_title , department_id , salary) VALUES (OLD.first_name , OLD.last_name , OLD.middle_name , OLD.job_title , OLD.department_id , OLD.salary);

