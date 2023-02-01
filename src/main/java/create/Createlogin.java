package create;


import applicationcontroller.Logincontroller;
import entity.account;
import entity.club;

/* Questa classe ha responsabilità di factory e di information expert per gli ogggetti definiti nella sezione attributi
 */
public class Createlogin {
    private static Createlogin instance;

    private  Logincontroller controller;
    private  account acc;
    private  club c;

    public Logincontroller createController() {
            controller = new Logincontroller();
            return controller;
    }

    public account createAccount() {
        acc = new account();
        return acc;
    }
    public club createClub(String clubName, int idClub){
            c = new club(clubName, idClub);
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
    public account getaccount(){
        return this.acc;
    }
    public club getclub(){
        return this.c;
    }
}
