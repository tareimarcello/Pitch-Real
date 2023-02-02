package create;


import applicationcontroller.Logincontroller;
import entity.Account;
import entity.Club;

/* Questa classe ha responsabilità di factory e di information expert per gli ogggetti definiti nella sezione attributi
 */
public class Createlogin {
    private static Createlogin instance;

    private  Logincontroller controller;
    private Account acc;
    private Club c;

    public Logincontroller createController() {
            controller = new Logincontroller();
            return controller;
    }

    public Account createAccount(String nome,String email,String passwd,String type) {
        acc = new Account(nome,email,passwd,type);
        return acc;
    }
    public Club createClub(String clubName, int idClub){
            c = new Club(clubName, idClub);
            return c;
    }
    public static Createlogin getInstance() {
        if (Createlogin.instance == null)
            Createlogin.instance = new Createlogin();
        return instance;
    }
    public Logincontroller getcontroller(){
        return this.controller;
    }
    public Account getaccount(){
        return this.acc;
    }
    public Club getclub(){
        return this.c;
    }
}
