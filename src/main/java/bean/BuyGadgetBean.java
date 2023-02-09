package bean;

public class BuyGadgetBean {
    private String nomeGadget;
    private String nomeClub;
    private double prezzo;
    public BuyGadgetBean(String gadget,String club,double prezzo){
        this.nomeGadget=gadget;
        this.nomeClub=club;
        this.prezzo=prezzo;
    }
    public BuyGadgetBean(String gadget,String club){
        this.nomeGadget=gadget;
        this.nomeClub=club;
    }
    public String getGadget(){
        return this.nomeGadget;
    }
    public String getClubGadget(){
        return this.nomeClub;
    }
    public double getPrice(){
        return this.prezzo;
    }
}
