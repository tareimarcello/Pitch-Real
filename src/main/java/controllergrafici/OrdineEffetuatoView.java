package controllergrafici;

import buttonbehavior.ButtonOperation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.PageLoader;

public class OrdineEffetuatoView {
    @FXML
    private Button logOutButton;
    @FXML
    private Button homeButton;
    @FXML
    private Button msgButton;
    @FXML
    private Button goSquadHome;
    @FXML
    private void logOut(){
        ButtonOperation.behaviorLogOut();
    }
    @FXML
    private void goBack(){
        PageLoader.pageLoader("First-View/ManchesterCityLogged.fxml");
    }
    @FXML
    private void goMsg(){
        ButtonOperation.behaviorMsgButton();
    }
    @FXML
    private void goHome(){
        PageLoader.pageLoader("First-View/LoggedHomepage.fxml");
    }
}
