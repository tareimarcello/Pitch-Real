package exception;

public class NullSelectionException extends Exception{
    private static final long serialVersionUID = 8L;
    public NullSelectionException(String message){
        super(message);
    }

    public NullSelectionException(Throwable cause) {
        super(cause);
    }

    public NullSelectionException(String message, Throwable cause) {
        super(" +++ " + message + " +++ ", cause);
    }
}
