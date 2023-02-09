package entity;

public class Gadget {
    private String nomeGadget;
    private String club;
    private double prezzo;
    public Gadget(String nome,String club,double prezzo){
        this.nomeGadget=nome;
        this.club=club;
        this.prezzo=prezzo;
    }
    public String getNomeGadget(){
        return this.nomeGadget;
    }
    public String getNomeClubGadget(){
        return this.club;
    }
    public double getPrezzo(){
        return this.prezzo;
    }
}
