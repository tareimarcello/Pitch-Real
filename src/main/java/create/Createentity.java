package create;

import entity.Account;
import entity.Club;

public class Createentity {
    private Account acc=null;                    //Questo rappresenta l'account loggato
    private Account accountOrder=null;        //Questo è il riferimento all'account che deve ricevere la notifica in caso di ordine di un gadget
    private Club c;
    private static Createentity instance;
    public Account createAccount(String nome, String email, String passwd, String type, Club c) {  //metodo di creazione di istanza di account
        acc = new Account(nome,email,passwd,type,c);
        return acc;
    }
    public Account createAccountOrder(String nome, String email, String passwd,String type,Club c,boolean isOrder){
        accountOrder=new Account(nome,email,passwd,type,null,false);
        return accountOrder;
    }
    public Club createClub(String clubName){                //metodo di creazione di istanza di club
        c = new Club(clubName);
        return c;
    }
    public static Createentity getInstance() {              //metodo per farsi restituire l'istazna di Createentity dato che è suna singleton class
        if (Createentity.instance == null)
            Createentity.instance = new Createentity();
        return instance;
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
