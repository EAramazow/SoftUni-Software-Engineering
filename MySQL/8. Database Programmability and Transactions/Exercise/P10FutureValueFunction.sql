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
END $$

SELECT UFN_CALCULATE_FUTURE_VALUE(1000, 0.50, 5) AS `output`;