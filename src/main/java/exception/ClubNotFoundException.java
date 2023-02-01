package exception;
/* Questa è l'eccezione che genero nel caso si digita un nome di un club non presente nel database
 */
public class ClubNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public ClubNotFoundException (String message){
        super(message);
    }

    public ClubNotFoundException (Throwable cause) {
        super(cause);
    }

    public ClubNotFoundException (String message, Throwable cause) {
        super(" +++ " + message + " +++ ", cause);
    }
}
