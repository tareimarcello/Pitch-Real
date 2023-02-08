package entity;

public class Gadget {
    private String nomeGadget;
    private String club;
    public Gadget(String nome,String club){
        this.nomeGadget=nome;
        this.club=club;
    }
    public String getNomeGadget(){
        return this.nomeGadget;
    }
    public String getNomeClubGadget(){
        return this.club;
    }
}
