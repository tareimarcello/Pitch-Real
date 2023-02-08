package controllergrafici.cityview;

import buttonbehavior.ButtonOperation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.PageLoader;

public class TicketOrderView {
    @FXML
    private Button squadhomeButton;
    @FXML
    private Button homeButton;
    @FXML
    private Button msgButton;
    @FXML
    private Button logOutButton;
    @FXML
    private Button mailButton;
    @FXML
    private void goSquadHome(){
        PageLoader.pageLoader("First-View/ManchesterCityLogged.fxml");
    }
    @FXML
    private void logOutClick(){
        ButtonOperation.behaviorLogOut();
    }
    @FXML
    private void goHomepage(){
        PageLoader.pageLoader("First-View/LoggedHomepage.fxml");
    }
    @FXML
    private void goToMsg(){
        ButtonOperation.behaviorMsgButton();
    }
    @FXML
    private void sendEmail(){
        PageLoader.ticketPageLoader("First-View/CitySelectSeatOrder.fxml","Biglietto inviato via mail");
    }
}
