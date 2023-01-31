package create;


import applicationcontroller.logincontroller;
import entity.account;
import entity.club;

/* Questa classe ha responsabilità di factory e di information expert per gli ogggetti definiti nella sezione attributi
 */
public class createlogin {
    private static createlogin instance = null;

    public logincontroller controller;
    public account acc;
    public club c;

    public logincontroller createController() {
        controller=new logincontroller();
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
    public static createlogin getInstance() {
        if (createlogin.instance == null)
            createlogin.instance = new createlogin();
        return instance;
    }
}
