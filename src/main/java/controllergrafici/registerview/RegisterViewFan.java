package controllergrafici.registerview;

import applicationcontroller.Registercontroller;
import bean.RegisterBean;
import create.Createregister;
import exception.DuplicatedRecordException;
import exception.FormatErrorException;
import exception.NullString;
import exception.ShortPassException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RegisterViewFan extends RegisterView {
    @FXML
    private TextField nomeText;
    @Override
    protected void registerButtonClick(ActionEvent event){
        RegisterBean registraFan=null;
        try {
            registraFan = new RegisterBean(emailText.getText(), passwdText.getText(), null, "Fan", nomeText.getText());
        }catch(ShortPassException e){           //Eccezione lanciata nel caso in cui la pssword inserita sia più corta di 5 caratteri
            this.pageSwitch.switchTo("First-View/RegisterVIewFanShortPass.fxml", event, "RegisterViewFanShortPass");
        }catch(FormatErrorException e){        //Eccezione lanciata nel caso di formato sbagliato dell'email
            this.pageSwitch.switchTo("First-View/RegisterVIewFanFormatError.fxml", event, "RegisterViewFanFormatError");
        }catch(NullString e){                   //Eccezione che lancio nel caso in cui uno dei campi è vuoto
            this.pageSwitch.switchTo("First-View/RegisterVIewFanNullString.fxml", event, "RegisterViewFanNullString");
        }
        Createregister log=Createregister.getInstance();
        Registercontroller registra=log.createController();
        try {
            registra.registra(registraFan);                       //Lancio la registrazione
        }catch(DuplicatedRecordException ex){
            this.pageSwitch.switchTo("First-View/RegisterViewExistCredentialFan.fxml",event,"RegisterViewCredErr");
        }
    }
}
