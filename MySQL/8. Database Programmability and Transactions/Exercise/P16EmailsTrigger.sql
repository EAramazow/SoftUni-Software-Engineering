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

CREATE TABLE notification_emails(
id INT PRIMARY KEY AUTO_INCREMENT,
recipient INT NOT NULL,
subject VARCHAR(50) NOT NULL,
body TEXT NOT NULL);

DELIMITER $$

CREATE TRIGGER tr_notifications_emails
AFTER INSERT
ON logs
FOR EACH ROW
BEGIN
    INSERT INTO notification_emails(recipient, subject, body)
    VALUES
    (NEW.account_id,
    CONCAT('Balance change for account: ', NEW.account_id),
    CONCAT('On ', DATE_FORMAT(NOW(), '%b %d %Y at %r'), 
        ' your balance was changed from ', NEW.old_sum, ' to ', NEW.new_sum, '.'));
END $$