package L08ExceptionsAndErrorHandling.P05CustomException;

import L08ExceptionsAndErrorHandling.P02EnterNumbers.InvalidPersonNameException;

public class Validate {

    public static void validateName(String name) {
        for (char c : name.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                throw new InvalidPersonNameException("Invalid name: " + name + ". Please, enter valid name!");
            }
        }
    }

    public static void validateEmail(String email) {
        if (!email.contains("@")) {
            throw new InvalidPersonNameException("Invalid email: " + email + ". Please, enter a valid email!");
        }
    }
}
