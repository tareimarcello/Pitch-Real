package bean;

import exception.FormatErrorException;
import exception.NullString;
import exception.ShortPassException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Bean che uso per passare i parametri sia nel caso d'uso Login sia nella fase di registrazione per il fan
public class Loginbean {
    private String email;
    private String passwd;
    public Loginbean(String mail,String pass) throws NullString, ShortPassException, FormatErrorException {
        this.email=mail;
        this.passwd=pass;
        this.checkInput();
    }
    public String getEmail(){
        return this.email;
    }
    public String getPasswd(){
        return this.passwd;
    }
    private void checkInput() throws NullString, FormatErrorException, ShortPassException {
        if (this.email.isBlank() || this.email==null || this.passwd==null || this.passwd.isBlank()){ //Controllo se uno dei due campi riaane vuoto e lancio l'eccezione corrispondente
            throw new NullString("Campo mail o password vuoto, riprova");
        }
        String regExMail = "[A-z0-9\\.\\+_-]+@[A-z0-9\\._-]+\\.[A-z]{2,6}";     //Espressione regolare della email
        Pattern p = Pattern.compile(regExMail);
        Matcher m = p.matcher(email);
        boolean matchFound = m.matches();
        if (!matchFound){         //Controllo se il formato email sia corretto
            throw new FormatErrorException("Formato email errato,riprova");
        }
        if(this.passwd.length()<5){   //Controllo che la password sia lunga almeno 5 caratteri
            throw new ShortPassException("Password troppo corta");
        }
    }
}
