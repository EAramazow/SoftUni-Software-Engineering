package bg.softuni.supermarket.util;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidationUtil {

    <T> Set<ConstraintViolation<T>> violation(T entity);

}
