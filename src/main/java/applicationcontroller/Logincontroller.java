package applicationcontroller;

import bean.Loginbean;
import controllergrafici.loginview.LoginView;
import dao.AccountDao;
import exception.CredentialException;
//Classe che rappresenta il controller del login
public class Logincontroller {
    public void controllaCredenziali (Loginbean b) throws CredentialException {
        AccountDao daoAcc=new AccountDao();
        daoAcc.cercaAccountperLog(b);               //Invoco la dao per cercare corrispondenza s database
        LoginView log=new LoginView();
        log.finalizzaControllo();               //Chiamo la view per finalizzare il fatto che ho registrato l'accesso
    }
}
