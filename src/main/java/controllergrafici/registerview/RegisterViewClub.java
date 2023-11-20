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
import loader.Page;

public class RegisterViewClub extends RegisterView {
    private Page pageSwitch = new Page();
    @FXML
    private TextField nomeClubText;
    @Override
    protected void registerButtonClick(ActionEvent event) {
        RegisterBean registraClub=null;
        try{
            registraClub = new RegisterBean(emailText.getText(), passwdText.getText(), nomeClubText.getText(), "Club",null);
        } catch (ShortPassException e) {
            this.pageSwitch.switchTo("First-View/RegisterViewClubShortPass.fxml", event, "RegisterViewClubShortPass");
        } catch (FormatErrorException e) {
            this.pageSwitch.switchTo("First-View/RegisterViewClubFormatError.fxml", event, "RegisterViewClubFormatError");
        } catch (NullString e) {
            this.pageSwitch.switchTo("First-View/RegisterViewClubNullString.fxml", event, "RegisterViewClubNullString");
        }
        Createregister log=Createregister.getInstance();
        Registercontroller registra=log.createController();
        try {
            registra.registra(registraClub);                       //Lancio la registrazione
        }catch(DuplicatedRecordException ex){
            this.pageSwitch.switchTo("First-View/RegisterViewExistCredentialClub.fxml",event,"RegisterViewExistCredErr");
        }
    }
}
