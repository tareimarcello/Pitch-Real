package applicationcontroller;

import bean.Loginbean;
import controllergrafici.loginview.LoginView;
import dao.AccountDao;
import exception.CredentialException;

public class Logincontroller {
    public void controllaCredenziali (Loginbean b) throws CredentialException {
        AccountDao daoAcc=new AccountDao();
        daoAcc.cercaAccountperLog(b);
        LoginView log=new LoginView();
        log.finalizzaControllo();
    }
}
