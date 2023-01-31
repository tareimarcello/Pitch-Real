package bean;
/*Classe Bean coinvolta principalmente nel caso d'Uso Buy Ticket che però uso anche in questo caso
 */
public class buygadgetbean {
    private String clubName;
    public buygadgetbean(String name){
        this.clubName=name;
    }
    public String getClubName(){
        return this.clubName;
    }
    private void checkinput(){
    }
}
