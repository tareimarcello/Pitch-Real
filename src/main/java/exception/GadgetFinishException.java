package exception;

public class GadgetFinishException extends Exception{
    private static final long serialVersionUID = 13L;

    public GadgetFinishException (String message){
        super(message);
    }

    public GadgetFinishException (Throwable cause) {
        super(cause);
    }

    public GadgetFinishException (String message, Throwable cause) {
        super(" +++ " + message + " +++ ", cause);
    }
}
