package exception;

public class PrivateConstructorException extends Exception {
    private static final long serialVersionUID = 5L;

    public PrivateConstructorException (String message){
        super(message);
    }
    public PrivateConstructorException (Throwable cause) {
        super(cause);
    }

    public PrivateConstructorException (String message, Throwable cause) {
        super(" +++ " + message + " +++ ", cause);
    }
}
