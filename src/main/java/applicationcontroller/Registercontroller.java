package applicationcontroller;
//Classe controller applicativo del caso d'uso registrati
import bean.RegisterBean;
import create.Createentity;
import dao.AccountDao;
import entity.Account;
import entity.Club;
import exception.CredentialException;
import exception.DuplicatedRecordException;
import loader.PageLoader;

public class Registercontroller {
    public void  registra(RegisterBean b) {
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
            try {
                registerDaoFan.newInsert(b, newAcc);                  //Inserimento dell'istanza sul db
            } catch (DuplicatedRecordException duplicEx) {
                if (newAcc.getClub() != null) {
                    PageLoader.pageLoader("First-View/RegisterViewExistCredentialClub.fxml");
                } else {
                    PageLoader.pageLoader("First-View/RegisterViewExistCredentialFan.fxml");
                }
            }
        }
    }
}
