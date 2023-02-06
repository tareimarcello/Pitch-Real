package controllergrafici.loginview;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.PageLoader;

//Controller della pagina che reindirizza o al log o alla registrazione nel caso in cui dovessi acquistare da uno store
public class GoToLogOrRegisterView {
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private void goToLogin(){
        PageLoader.pageLoader("First-View/LoginView.fxml");
    }
    @FXML
    private void goToRegister(){
        PageLoader.pageLoader("First-View/SceltaTipoView.fxml");
    }
}
