package controllergrafici;

import applicationcontroller.Registercontroller;
import bean.RegisterBean;
import create.Createregister;
import exception.FormatErrorException;
import exception.NullString;
import exception.ShortPassException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import loader.PageLoader;

public class RegisterViewFan extends RegisterView{
    @FXML
    private TextField nomeText;
    private String type;
    @Override
    protected void registerButtonClick(){
        RegisterBean b=null;
        try {
            b = new RegisterBean(emailText.getText(), passwdText.getText(), null, type, nomeText.getText());
        }catch(ShortPassException e){           //Eccezione lanciata nel caso in cui la pssword inserita sia più corta di 5 caratteri
            PageLoader.pageLoader("First-View/RegisterVIewFanShortPass.fxml");
        }catch(FormatErrorException e){        //Eccezione lanciata nel caso di formato sbagliato dell'email
            PageLoader.pageLoader("First-View/RegisterViewFanFormatError.fxml");
        }catch(NullString e){                   //Eccezione che lancio nel caso in cui uno dei campi è vuoto
            PageLoader.pageLoader("First-View/RegisterViewFanNullString.fxml");
        }
        Createregister log=Createregister.getInstance();
        Registercontroller registra=log.createController();
        registra.registra(b);                       //Lancio la registrazione
    }
}
