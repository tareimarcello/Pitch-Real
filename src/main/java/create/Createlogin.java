package create;


import applicationcontroller.Logincontroller;
import entity.account;
import entity.club;

/* Questa classe ha responsabilità di factory e di information expert per gli ogggetti definiti nella sezione attributi
 */
public class Createlogin {
    private static Createlogin instance = null;

    public Logincontroller controller;
    public account acc;
    public club c;

    public Logincontroller createController() {
        controller=new Logincontroller();
        return controller;
    }

    public account CreateAccount() {
        acc=new account();
        return  acc;
    }
    public club CreateClub(String ClubName, int IdClub){
        c=new club(ClubName,IdClub);
        return c;
    }
    public static Createlogin getInstance() {
        if (Createlogin.instance == null)
            Createlogin.instance = new Createlogin();
        return instance;
    }
}
