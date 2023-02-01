package bean;

import exception.InvalidDate;

public class Loginbean {
    private String email;
    private String passwd;
    public Loginbean(String mail,String pass) throws InvalidDate {
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
    private void checkInput() throws InvalidDate {
        if (this.email.isBlank() || this.email==null){
            throw new InvalidDate("Email o passwd errata, riprova");
        }

    }
}
