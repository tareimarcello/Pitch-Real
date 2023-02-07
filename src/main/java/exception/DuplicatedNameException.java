package exception;

public class DuplicatedNameException extends Exception{
    private static final long serialVersionUID = 12L;
    public DuplicatedNameException(String message){
        super(message);
    }
    public DuplicatedNameException (Throwable cause) {
        super(cause);
    }

    public DuplicatedNameException (String message, Throwable cause) {
        super(" +++ " + message + " +++ ", cause);
    }
}
