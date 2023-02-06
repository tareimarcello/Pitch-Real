package exception;

public class SectorFullException extends Exception{
    private static final long serialVersionUID = 10L;

    public SectorFullException(String message){
        super(message);
    }
    public SectorFullException(Throwable cause) {
        super(cause);
    }

    public SectorFullException(String message, Throwable cause) {
        super(" +++ " + message + " +++ ", cause);
    }
}
