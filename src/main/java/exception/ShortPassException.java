package exception;
//Eccezione che lancio quando la password immessa è troppo corta
public class ShortPassException extends Exception{
    private static final long serialVersionUID = 4L;

    public ShortPassException (String message){
        super(message);
    }
    public ShortPassException (Throwable cause) {
        super(cause);
    }

    public ShortPassException (String message, Throwable cause) {
        super(" +++ " + message + " +++ ", cause);
    }
}
