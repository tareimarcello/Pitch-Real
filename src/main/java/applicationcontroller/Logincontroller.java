package applicationcontroller;

import bean.Loginbean;
import controllergrafici.LoginView;
import dao.AccountDao;
import entity.Account;
import exception.CredentialException;

public class Logincontroller {
    public void controllaCredenziali (Loginbean b) throws CredentialException {
        AccountDao daoAcc=new AccountDao();
        Account acc=daoAcc.cercaAccountperLog(b);
        LoginView log=new LoginView();
        log.finalizzaControllo();
    }
}
