package controllergrafici;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.PageLoader;

/*Questa classe rappresenta il controller grafico della HomepageView
 */
public class HomepagUnloggedView extends HomepageView{
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;

    @FXML
    public void loginButtonClick(ActionEvent e) {
        PageLoader.pageLoader("First-View/LoginView.fxml");                  //Invoca caricamento della pagina
    }
    @FXML
    public void registerButtonClick(ActionEvent e){
        PageLoader.pageLoader("First-View/SceltaTipoView.fxml");               //Invoca caricamento della pagina
    }
}
