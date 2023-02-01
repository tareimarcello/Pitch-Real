package exception;

public class NullString extends Exception{
    private static final long serialVersionUID = 2L;
    public NullString(String message){
        super(message);
    }

    public NullString(Throwable cause) {
        super(cause);
    }

    public NullString(String message, Throwable cause) {
        super(" +++ " + message + " +++ ", cause);
    }
}
