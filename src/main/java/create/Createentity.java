package create;

import entity.Account;
import entity.Club;
import entity.Seat;
import entity.Sector;

public class Createentity {
    private Account acc=null;                    //Questo rappresenta l'account loggato
    private Account accountOrder=null;        //Questo è il riferimento all'account che deve ricevere la notifica in caso di ordine di un gadget
    private Club c;
    private Sector s;
    private Seat seat;
    private static Createentity instance;
    public Account createAccount(String nome, String email, String passwd, String type, Club c) {  //metodo di creazione di istanza di account
        acc = new Account(nome,email,passwd,type,c);
        return acc;
    }
    public Sector createSector(String nomeSettore,String nomeClub){
        return this.s=new Sector(nomeSettore,nomeClub);
    }
    public Account createAccountOrder(String nome, String email, String passwd,String type,Club c,boolean isOrder){
        accountOrder=new Account(nome,email,passwd,type,null,false);
        return accountOrder;
    }
    public Club createClub(String clubName){                //metodo di creazione di istanza di club
        c = new Club(clubName);
        return c;
    }
    public Seat createSeat(String num,String settore,String club){
        this.seat=new Seat(num,settore,club);
        return seat;
    }
    public static Createentity getInstance() {              //metodo per farsi restituire l'istazna di Createentity dato che è suna singleton class
        if (Createentity.instance == null)
            Createentity.instance = new Createentity();
        return instance;
    }
    public Sector getSector(){
        return this.s;
    }
    public Account getaccount(){
        return this.acc;
    }
    public Account getAccOrder(){
        return this.accountOrder;
    }
    public Club getclub(){
        return this.c;
    }     //getter di account e club
    public void delAccount(){               //metodo per cancellare l'istanza di account
        this.acc=null;
    }
    public void delClub(){                  //merodo per cancellare l'istanza di club
        this.c=null;
    }
}
