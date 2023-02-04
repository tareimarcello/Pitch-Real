package applicationcontroller;

import bean.RegisterBean;
import create.Createentity;
import dao.AccountDao;
import entity.Account;
import entity.Club;
import exception.CredentialException;

public class Registercontroller {
    public void registraClub(RegisterBean b){
        AccountDao registerDao=new AccountDao();
        try{
            registerDao.
        }catch(CredentialException e){

        }
    }
    public void  registraFan(RegisterBean b){
        AccountDao registerDaoFan=new AccountDao();
        Club c=null;
        try{
            registerDaoFan.cercaAccountperLog(b);
        }catch(CredentialException e){
            if(b.getClubName()!=null) {
                Createentity creatClub=Createentity.getInstance();
                c=creatClub.createClub(b.getClubName());
            }
            Createentity createAcc=new Createentity();
            Account newAcc=createAcc.createAccount(b.getNome(),b.getEmail(),b.getPasswd(),b.getType(),c);
            registerDaoFan.newInsertFan(b,newAcc);
        }
    }
}
