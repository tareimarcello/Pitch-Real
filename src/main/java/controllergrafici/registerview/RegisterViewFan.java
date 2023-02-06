package controllergrafici.registerview;

import applicationcontroller.Registercontroller;
import bean.RegisterBean;
import controllergrafici.registerview.RegisterView;
import create.Createregister;
import exception.FormatErrorException;
import exception.NullString;
import exception.ShortPassException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import loader.PageLoader;

public class RegisterViewFan extends RegisterView {
    @FXML
    private TextField nomeText;
    @Override
    protected void registerButtonClick(){
        RegisterBean registraFan=null;
        try {
            registraFan = new RegisterBean(emailText.getText(), passwdText.getText(), null, "Fan", nomeText.getText());
        }catch(ShortPassException e){           //Eccezione lanciata nel caso in cui la pssword inserita sia più corta di 5 caratteri
            PageLoader.pageLoader("First-View/RegisterVIewFanShortPass.fxml");
        }catch(FormatErrorException e){        //Eccezione lanciata nel caso di formato sbagliato dell'email
            PageLoader.pageLoader("First-View/RegisterViewFanFormatError.fxml");
        }catch(NullString e){                   //Eccezione che lancio nel caso in cui uno dei campi è vuoto
            PageLoader.pageLoader("First-View/RegisterViewFanNullString.fxml");
        }
        Createregister log=Createregister.getInstance();
        Registercontroller registra=log.createController();
        registra.registra(registraFan);                       //Lancio la registrazione
    }
}
