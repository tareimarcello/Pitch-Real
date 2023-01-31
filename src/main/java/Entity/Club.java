package Entity;

public class Club {
    private String NomeClub;
    private int IDclub;
    public Club(String Nome,int Id){
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
