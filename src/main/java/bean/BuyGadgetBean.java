package bean;

public class BuyGadgetBean {
    private String nomeGadget;
    private String nomeClub;
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
}
