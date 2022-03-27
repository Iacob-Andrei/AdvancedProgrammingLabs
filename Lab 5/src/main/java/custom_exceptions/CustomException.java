package custom_exceptions;

public class CustomException extends Exception{

    public CustomException(String exception){
        super(exception);
    }

    public CustomException(String exception, Throwable cause){
        super(exception, cause);
    }
}
