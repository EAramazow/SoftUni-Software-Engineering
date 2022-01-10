package L08ExceptionsAndErrorHandling.P02EnterNumbers;

public class InvalidPersonNameException extends RuntimeException{
    public InvalidPersonNameException(String message) {
        super(message);
    }
}
