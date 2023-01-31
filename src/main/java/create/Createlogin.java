package create;


import applicationcontroller.Logincontroller;
import entity.account;
import entity.club;

/* Questa classe ha responsabilità di factory e di information expert per gli ogggetti definiti nella sezione attributi
 */
public class Createlogin {
    private static Createlogin instance = null;

    public static Logincontroller controller=null;
    public static account acc=null;
    public static club c=null;

    public Logincontroller createController() {
        if(this.controller==null) {
            controller = new Logincontroller();
            return controller;
        }
        return controller;
    }

    public account createAccount() {
        if(this.acc==null) {
            acc = new account();
            return acc;
        }
        return acc;
    }
    public club createClub(String ClubName, int IdClub){
        if(this.c==null) {
            c = new club(ClubName, IdClub);
            return c;
        }
        return c;
    }
    public static Createlogin getInstance() {
        if (Createlogin.instance == null)
            Createlogin.instance = new Createlogin();
        return instance;
    }
}
