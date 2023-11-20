package controllergrafici.loginview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.Page;

//Controller della pagina che reindirizza o al log o alla registrazione nel caso in cui dovessi acquistare da uno store
public class GoToLogOrRegisterView {
    private Page pageSwitch = new Page();
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private void goToLogin(ActionEvent e){
        this.pageSwitch.switchTo("First-View/LoginView.fxml", e, "Login");
    }
    @FXML
    private void goToRegister(ActionEvent e){
        this.pageSwitch.switchTo("First-View/RegisterView.fxml", e, "Register");
    }
}
