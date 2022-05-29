package bg.softuni.supermarket.util.impl;

import bg.softuni.supermarket.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class ValidationUtilImpl implements ValidationUtil {


    private final Validator validator;

    public ValidationUtilImpl() {
        validator = Validation
                .buildDefaultValidatorFactory()
                .getValidator();
    }

    @Override
    public <T> Set<ConstraintViolation<T>> violation(T entity) {
        return validator.validate(entity);
    }
}
