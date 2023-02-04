package exception;
//Eccezione che lancio quando la mail è del formato errato
public class FormatErrorException extends Exception{
    private static final long serialVersionUID = 4L;

    public FormatErrorException (String message){
        super(message);
    }
    public FormatErrorException (Throwable cause) {
        super(cause);
    }

    public FormatErrorException (String message, Throwable cause) {
        super(" +++ " + message + " +++ ", cause);
    }
}
