package applicationcontroller;
//Classe controller applicativo del caso d'uso registrati

import bean.RegisterBean;
import create.Createentity;
import dao.AccountDao;
import entity.Account;
import entity.Club;
import exception.CredentialException;
import exception.DuplicatedRecordException;
import loader.Page;

public class Registercontroller {
    private Page pageSwitch = new Page();
    public void  registra(RegisterBean b) throws DuplicatedRecordException {
        AccountDao registerDaoFan = new AccountDao();
        Club c = null;
        try {
            registerDaoFan.cercaAccountperLog(b);               //Cerco se esiste un account con quelle credenziali
        } catch (
                CredentialException e) {                          //Eccezione lanciata nel caso in cui le credenziali sono errate e la uso in questo caso per vedere se ci sono già account registrati con queste credenziali
            if (b.getClubName() != null) {                         //Check se il clubName è nullo così so se l'account è di tipo club o fan
                Createentity creatClub = Createentity.getInstance();
                c = creatClub.createClub(b.getClubName());            //Creo l'istanza di club da asociare a quella di account
            }
            Createentity createAcc = new Createentity();
            Account newAcc = createAcc.createAccount(b.getNome(), b.getEmail(), b.getPasswd(), b.getType(), c);   //Creo l'istanza di accout da inserire nel database
            registerDaoFan.newInsert(b, newAcc);                  //Inserimento dell'istanza sul db
        }
    }
}
