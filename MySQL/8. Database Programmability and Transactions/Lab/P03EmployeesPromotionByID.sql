DELIMITER $$$

CREATE PROCEDURE usp_raise_salary_by_id (userid INT)
BEGIN
IF ( (SELECT COUNT(*) FROM employees WHERE employee_id = userid) > 0 )
THEN 
UPDATE employees SET salary = salary * 1.05 WHERE employee_id = userid;
END IF ;

END
$$$


CALL udp_promote (12);



