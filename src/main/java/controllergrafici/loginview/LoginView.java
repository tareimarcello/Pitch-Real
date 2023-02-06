package controllergrafici.loginview;

import applicationcontroller.Logincontroller;
import bean.Loginbean;
import create.Createlogin;
import exception.CredentialException;
import exception.FormatErrorException;
import exception.NullString;
import exception.ShortPassException;
import interfacce.Credenziali;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import loader.PageLoader;

import java.util.ArrayList;

public class LoginView implements Credenziali {
    @FXML
    private Button loginButton;
    @FXML
    private TextField emailText;
    @FXML
    private TextField passwdText;
    private ArrayList<String> credenziali;
    @FXML
    private void startLogin(){
        this.catturaCredenziali();
        Loginbean credenzialiInput=null;
        try {
            credenzialiInput=new Loginbean(credenziali.get(0),credenziali.get(1));
        }catch (NullString e){                                      //Eccezione che lancio in caso i campi email e password vengano lasciati vuoti
            credenzialiInput=null;
            PageLoader.loginPageLoader("First-View/LoginViewNullString.fxml");
        }catch(FormatErrorException e){
            credenzialiInput=null;
            PageLoader.loginPageLoader("First-View/LoginViewFormatError.fxml");
        }catch (ShortPassException e){
            credenzialiInput=null;
            PageLoader.loginPageLoader("First-View/loginViewShortPass.fxml");
        }
        if(credenzialiInput!=null) {
                Createlogin create = Createlogin.getInstance();
                Logincontroller controller = create.createController();
                try {
                    controller.controllaCredenziali(credenzialiInput);
                }catch(CredentialException e){
                    PageLoader.loginPageLoader("First-View/LoginViewCredError.fxml");
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
        PageLoader.loginPageLoader("First-View/LoggedHomepage.fxml");
    }
}
