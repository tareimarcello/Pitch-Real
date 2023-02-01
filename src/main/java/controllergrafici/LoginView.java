package controllergrafici;

import bean.Loginbean;
import exception.InvalidDate;
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
        }catch (InvalidDate e){
            credenzialiInput=null;
            FXMLLoader loader = new FXMLLoader(LoginView.class.getClassLoader().getResource("First-View/LoginViewError.fxml"));
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
        }

    @Override
    public void catturaCredenziali() {
        credenziali=new ArrayList<String>();       //Creo una lista dove mettere le crdenziali da passare poi al bean
        credenziali.add(emailText.getText());
        credenziali.add(passwdText.getText());
    }
}
