package entity;

public class Account {
    public String nome;
    public String email;
    public String passwd;
    public String type;
    public Club nomeClub;
    public Account (String nome,String email, String passwd,String type){
        this.nome=nome;
        this.email=email;
        this.passwd=passwd;
        this.type=type;
    }
}
