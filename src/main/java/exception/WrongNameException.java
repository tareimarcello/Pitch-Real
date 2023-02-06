package exception;

public class WrongNameException extends Exception{
    private static final long serialVersionUID = 9L;

    public WrongNameException (String message){
        super(message);
    }
    public WrongNameException (Throwable cause) {
        super(cause);
    }

    public WrongNameException (String message, Throwable cause) {
        super(" +++ " + message + " +++ ", cause);
    }
}
