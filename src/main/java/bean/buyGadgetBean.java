package bean;
/*Classe Bean coinvolta principalmente nel caso d'Uso Buy Ticket che però uso anche in questo caso
 */
public class buyGadgetBean {
    private String clubName;
    public buyGadgetBean(String name){
        this.clubName=name;
    }
    public String getClubName(){
        return this.clubName;
    }
    private void CheckInput(){
    }
}
