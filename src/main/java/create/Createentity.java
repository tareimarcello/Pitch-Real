package create;

import entity.Account;
import entity.Club;

public class Createentity {
    private Account acc;
    private Club c;
    private static Createentity instance;
    public Account createAccount(String nome, String email, String passwd, String type, Club c) {
        acc = new Account(nome,email,passwd,type,c);
        return acc;
    }
    public Club createClub(String clubName){
        c = new Club(clubName);
        return c;
    }
    public static Createentity getInstance() {
        if (Createentity.instance == null)
            Createentity.instance = new Createentity();
        return instance;
    }
    public Account getaccount(){
        return this.acc;
    }
    public Club getclub(){
        return this.c;
    }
}
