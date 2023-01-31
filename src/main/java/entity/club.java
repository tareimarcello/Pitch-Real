package entity;

public class club {
    private String NomeClub;
    private int IDclub;
    public club(String Nome, int Id){
        this.NomeClub=Nome;
        this.IDclub=Id;
    }
    public String getName(){
        return this.NomeClub;
    }
    public int getId(){
        return this.IDclub;
    }
}
