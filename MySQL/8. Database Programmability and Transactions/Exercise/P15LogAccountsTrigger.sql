CREATE TABLE logs(
log_id INT PRIMARY KEY AUTO_INCREMENT,
account_id INT NOT NULL,
old_sum DECIMAL(20, 4),
new_sum DECIMAL(20, 4));

DELIMITER $$

CREATE TRIGGER tr_balance_change
AFTER UPDATE
ON accounts
FOR EACH ROW
BEGIN
    IF OLD.balance <> NEW.balance THEN
    INSERT INTO logs (account_id, old_sum, new_sum)
    VALUES
    (OLD.id, ROUND(OLD.balance, 4), ROUND(NEW.balance, 4));
    END IF;
END $$