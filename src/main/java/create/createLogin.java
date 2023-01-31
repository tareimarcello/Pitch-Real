package create;


import controllerApp.loginController;
import entity.account;
import entity.club;

/* Questa classe ha responsabilità di factory e di information expert per gli ogggetti definiti nella sezione attributi
 */
public class createLogin {
    private static createLogin instance = null;

    public loginController controller;
    public account acc;
    public club c;

    public loginController createController() {
        controller=new loginController();
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
    public static createLogin getInstance() {
        if (createLogin.instance == null)
            createLogin.instance = new createLogin();
        return instance;
    }
}
