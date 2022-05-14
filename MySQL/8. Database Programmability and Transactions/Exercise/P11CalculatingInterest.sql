DELIMITER $$

CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(20, 4), 
yearly_interest_rate DECIMAL(20, 4), 
years INT)
RETURNS DECIMAL(20, 4)
DETERMINISTIC
BEGIN
    DECLARE result DECIMAL(20, 4);
    SET result = sum * POWER(1 + yearly_interest_rate, years);
    RETURN result;
END;

CREATE PROCEDURE usp_calculate_future_value_for_account(account_id INT, interest DECIMAL(20, 4))
BEGIN
SELECT 
    a.id,
    ah.first_name,
    ah.last_name,
    a.balance AS current_balance,
    ufn_calculate_future_value(a.balance, interest, 5) AS balance_in_5_years
FROM
    account_holders AS ah
        JOIN
    accounts AS a ON ah.id = a.account_holder_id
WHERE
    a.id = account_id;
END $$

CALL usp_calculate_future_value_for_account(1, 0.1);