package controllergrafici.cityview;

import buttonbehavior.ButtonOperation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.PageLoader;

public abstract class CityTicketShopView {
    @FXML
    protected Button goOnButton;
    @FXML
    protected Button goBackButton;
    @FXML
    protected Button homeButton;
    @FXML
    protected Button logoutButton;
    @FXML
    protected Button messageButton;
    @FXML
    protected void logOutButtonClick(){
        ButtonOperation.behaviorLogOut();
    }
    @FXML
    protected void messageButtonClick(){
        ButtonOperation.behaviorMsgButton();
    }
    @FXML
    protected void homeButtonClick(){
        PageLoader.pageLoader("First-View/LoggedHomepage.fxml");
    }
    @FXML
    protected abstract void goBackButtonClick();
}
