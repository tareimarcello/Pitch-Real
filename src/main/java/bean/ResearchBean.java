package bean;
/*Classe Bean coinvolta principalmente nel caso d'Uso Buy Ticket che però uso anche in questo caso
 */
public class ResearchBean {
    private String clubName;
    public ResearchBean(String nameClub){
        this.clubName=nameClub;
    }
    public String getClubName(){
        return this.clubName;
    }
}
