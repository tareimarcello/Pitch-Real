package CREATE;


import ControllerApp.LoginController;
import Entity.Account;
import Entity.Club;

/* Questa classe ha responsabilità di factory e di information expert per gli ogggetti definiti nella sezione attributi
 */
public class CreateLogin {
    private static CreateLogin instance = null;

    public LoginController Controller;
    public Account Acc;
    public Club c;

    public LoginController CreateController() {
        Controller=new LoginController();
        return Controller;
    }

    public Account CreateAccount() {
        Acc=new Account();
        return  Acc;
    }
    public Club CreateClub(String ClubName, int IdClub){
        c=new Club(ClubName,IdClub);
        return c;
    }
    public static CreateLogin getInstance() {
        if (CreateLogin.instance == null)
            CreateLogin.instance = new CreateLogin();
        return instance;
    }
}
