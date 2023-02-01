package bean;

import exception.FormatErrorException;
import exception.NullString;
import exception.ShortPassException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (this.email.isBlank() || this.email==null || this.passwd==null || this.passwd.isBlank()){
            throw new NullString("Campo mail o password vuoto, riprova");
        }
        String espressione = "^[0-9a-z]([-_.]?[0-9a-z])*@[0-9a-z]([0-9a-z])*\\.[a-z]{2,4}$";
        Pattern p = Pattern.compile(espressione);
        Matcher m = p.matcher(email);
        boolean matchFound = m.matches();
        if (!matchFound){
            throw new FormatErrorException("Formato email errato,riprova");
        }
        if(this.passwd.length()<5){
            throw new ShortPassException("Password troppo corta");
        }
    }
}
