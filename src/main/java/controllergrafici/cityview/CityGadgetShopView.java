package controllergrafici.cityview;

import buttonbehavior.ButtonOperation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.PageLoader;

public class CityGadgetShopView {
    @FXML
    private Button homeButton;
    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button logOutButton;
    @FXML
    private Button msgButton;
    @FXML
    private Button goBackButton;
    @FXML
    private void goHome(){
        PageLoader.pageLoader("First-View/LoggedHomepage.fxml");
    }
    @FXML
    private void logOut(){
        ButtonOperation.behaviorLogOut();
    }
    @FXML
    private void goToMsg(){
        ButtonOperation.behaviorMsgButton();
    }
    @FXML
    private void goBack(){
        PageLoader.pageLoader("First-View/ManchesterCityLogged.fxml");
    }
}
