package Bean;
/*Classe Bean coinvolta principalmente nel caso d'Uso Buy Ticket che però uso anche in questo caso
 */
public class BuyGadgetBean {
    private String ClubName;
    public BuyGadgetBean(String Name){
        this.ClubName=Name;
    }
    public String getClubName(){
        return this.ClubName;
    }
    private void CheckInput(){
    }
}
