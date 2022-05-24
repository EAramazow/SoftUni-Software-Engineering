package L08ExceptionsAndErrorHandling.P02EnterNumbers;

public class InvalidRangeException extends Exception{

        public InvalidRangeException(String message) {
            super(message);
        }

}
