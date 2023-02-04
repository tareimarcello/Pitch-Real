package bean;

import exception.FormatErrorException;
import exception.NullString;
import exception.ShortPassException;
//Bean che uso per la registrazione di club
public class RegisterBean extends Loginbean{
    private String nome;
    private String nomeClub=null;
    private String type;
    public RegisterBean(String mail, String passwd,String nomeInputClub,String tipoAcc, String nomeAcc) throws ShortPassException, FormatErrorException, NullString {
        super(mail,passwd);
        if(nomeInputClub==null) {
            checkName(nomeAcc);
        }else{
            checkName(nomeInputClub);
        }
        this.nomeClub=nomeInputClub;
        this.type=tipoAcc;
        this.nome=nomeAcc;
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
    private void checkName(String nome) throws NullString {
        if(nome==null){
            throw new NullString("Uno dei campi è vuoto");
        }
    }
}
