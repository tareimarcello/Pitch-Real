package exception;

public class FormatErrorException extends Exception{
    private static final long serialVersionUID = 3L;

    public FormatErrorException (String message){
        super(message);
    }
    public FormatErrorException (Throwable cause) {
        super(cause);
    }

    public FormatErrorException (String message, Throwable cause) {
        super(" +++ " + message + " +++ ", cause);
    }
}
