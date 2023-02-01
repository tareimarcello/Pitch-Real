package exception;

public class InvalidDate extends Exception{
    private static final long serialVersionUID = 1885653349235601203L;
    public InvalidDate (String message){
        super(message);
    }

    public InvalidDate (Throwable cause) {
        super(cause);
    }

    public InvalidDate (String message, Throwable cause) {
        super(" +++ " + message + " +++ ", cause);
    }
}
