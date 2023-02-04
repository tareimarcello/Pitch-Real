package controllergrafici;
//Questa è la classe che rappresenta il cpntroller grafico del caso d'uso registrati

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.PageLoader;
public class SceltaTipoView {
    @FXML
    private Button clubButton;
    @FXML
    private Button fanButton;
    @FXML
    private void clubButtonClick(){
        PageLoader.pageLoader("First-View/RegisterViewClub.fxml");
    }
    @FXML
    private void fanButtonClick(){
        PageLoader.pageLoader("First-View/RegisterViewFan.fxml");
    }
}
