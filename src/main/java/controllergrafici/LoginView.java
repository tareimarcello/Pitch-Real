package controllergrafici;

import applicationcontroller.Logincontroller;
import bean.Loginbean;
import create.Createlogin;
import exception.CredentialException;
import exception.FormatErrorException;
import exception.NullString;
import exception.ShortPassException;
import interfacce.Credenziali;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
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
            this.loginPageLoader("First-View/LoginViewNullString.fxml");
        }catch(FormatErrorException e){
            credenzialiInput=null;
            this.loginPageLoader("First-View/LoginViewFormatError.fxml");
        }catch (ShortPassException e){
            credenzialiInput=null;
            this.loginPageLoader("First-View/loginViewShortPass.fxml");
        }
        if(credenzialiInput!=null) {
                Createlogin create = Createlogin.getInstance();
                Logincontroller controller = create.createController();
                try {
                    controller.controllaCredenziali(credenzialiInput);
                }catch(CredentialException e){
                    this.loginPageLoader("First-View/LoginViewCredError.fxml");
                }
        }
    }

    private void loginPageLoader(String filename){
        FXMLLoader loader = new FXMLLoader(LoginView.class.getClassLoader().getResource(filename));
        Parent root = null;
        try {
            root = loader.load();           //caricamento della pagina del Login
        } catch (IOException exception) {
            System.exit(0);           //SE non trovo la pagina chiudo l'applicazione
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 500, 500));
        stage.setResizable(false);
        stage.show();
    }
    @Override
    public void catturaCredenziali() {
        credenziali=new ArrayList<String>();       //Creo una lista dove mettere le crdenziali da passare poi al bean
        credenziali.add(emailText.getText());
        credenziali.add(passwdText.getText());
    }

    public void finalizzaControllo() {
        this.loginPageLoader("First-View/LoggedHomepage.fxml");
    }
}
