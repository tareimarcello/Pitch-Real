package entity;

public class Club {
    private String nomeClub;
    private int iDclub;
    public Club(String nome, int id){
        this.nomeClub = nome;
        this.iDclub= id;
    }
    public String getName(){
        return this.nomeClub;
    }
    public int getId(){
        return this.iDclub;
    }
}
