package exception;

public class DuplicatedRecordException extends Exception {
    private static final long serialVersionUID = 7L;
    public DuplicatedRecordException(String message){
        super(message);
    }
    public DuplicatedRecordException (Throwable cause) {
        super(cause);
    }

    public DuplicatedRecordException (String message, Throwable cause) {
        super(" +++ " + message + " +++ ", cause);
    }
}
