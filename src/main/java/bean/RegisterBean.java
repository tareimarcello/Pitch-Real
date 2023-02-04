package bean;

import exception.FormatErrorException;
import exception.NullString;
import exception.ShortPassException;
//Bean che uso per la registrazione di club
public class RegisterBean extends Loginbean{
    private String nome;
    private String nomeClub=null;
    private String type;
    public RegisterBean(String mail, String passwd,String nomeClub,String type, String nome) throws ShortPassException, FormatErrorException, NullString {
        super(mail,passwd);
        this.nomeClub=nomeClub;
        this.type=type;
        this.nome=nome;
    }
    public String getClubName(){
        return this.nomeClub;
    }
    public String getNome(){
        return this.nome;
    }
    public String getType(){
        return this.type;
    }
}
