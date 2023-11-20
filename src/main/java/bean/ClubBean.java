package bean;

public class ClubBean {     //Ogni volta dopo la ricerca scrivere nome del club in questa classe
    //Potrebbe già essere tutto scritto nella classe createEntity il nome del club quindi è da rivedere
    public static class ClubRequest {
        public static String nomeClub;
        public static String getNomeClub() {
            return nomeClub;
        }
    }
}
