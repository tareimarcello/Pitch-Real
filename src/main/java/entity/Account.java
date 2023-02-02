package entity;

public class Account {
    private String nome;
    private String email;
    private String passwd;
    private String type;
    private Club nomeClub;
    public Account (String nome, String email, String passwd, String type, Club c){
        this.nome=nome;
        this.email=email;
        this.passwd=passwd;
        this.type=type;
        this.nomeClub=c;
    }
    public String getNome(){
        return this.nome;
    }
    public String getemail(){
        return this.email;
    }
    public String getPaswd(){
        return this.passwd;
    }
    public String getType(){
        return this.type;
    }
    public Club getClub(){
        return this.nomeClub;
    }
}
