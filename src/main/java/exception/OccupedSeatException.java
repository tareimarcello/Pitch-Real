package exception;

public class OccupedSeatException extends Exception{
    private static final long serialVersionUID = 11L;
    public OccupedSeatException(String message){
        super(message);
    }

    public OccupedSeatException(Throwable cause) {
        super(cause);
    }

    public OccupedSeatException(String message, Throwable cause) {
        super(" +++ " + message + " +++ ", cause);
    }
}
