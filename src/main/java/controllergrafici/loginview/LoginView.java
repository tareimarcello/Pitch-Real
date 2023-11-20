package controllergrafici.loginview;

import applicationcontroller.Logincontroller;
import bean.Loginbean;
import create.Createlogin;
import exception.CredentialException;
import exception.FormatErrorException;
import exception.NullString;
import exception.ShortPassException;
import interfacce.Credenziali;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import loader.Page;

import java.util.ArrayList;

public class LoginView implements Credenziali {
    private Page pageSwitch= new Page();
    @FXML
    private Button loginButton;
    @FXML
    private TextField emailText;
    @FXML
    private TextField passwdText;
    private ArrayList<String> credenziali;
    @FXML
    private void startLogin(ActionEvent e){
        this.catturaCredenziali();
        Loginbean credenzialiInput=null;
        try {
            credenzialiInput=new Loginbean(credenziali.get(0),credenziali.get(1));
        }catch (NullString ex){                                      //Eccezione che lancio in caso i campi email e password vengano lasciati vuoti
            credenzialiInput=null;
            this.pageSwitch.switchTo("First-View/LoginViewNullString.fxml", e, "LoginNullString");
        }catch(FormatErrorException ex){
            credenzialiInput=null;
            this.pageSwitch.switchTo("First-View/LoginViewFormatError.fxml", e, "LoginViewFormatError");
        }catch (ShortPassException ex){
            credenzialiInput=null;
            this.pageSwitch.switchTo("First-View/loginViewShortPass.fxml", e, "LoginViewShortPass");
        }
        if(credenzialiInput!=null) {
                Createlogin create = Createlogin.getInstance();
                Logincontroller controller = create.createController();
                try {
                    controller.controllaCredenziali(credenzialiInput);
                }catch(CredentialException ex){
                    this.pageSwitch.switchTo("First-View/LoginViewCredError.fxml", e, "LoginViewCredError");
                }
        }
    }

    @Override
    public void catturaCredenziali() {
        credenziali=new ArrayList<String>();       //Creo una lista dove mettere le crdenziali da passare poi al bean
        credenziali.add(emailText.getText());
        credenziali.add(passwdText.getText());
    }

    public void finalizzaControllo() {
        this.pageSwitch.switchTo("First-View/LoggedHomepage.fxml", null, "LoggedHomepage");     //è da provare se non funziona qualcosa torna qui
    }
}
