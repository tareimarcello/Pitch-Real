package controllergrafici.cityview;

import buttonbehavior.ButtonOperation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.Page;

public abstract class ClubTicketShopView {
    private Page pageSwitch = new Page();
    @FXML
    protected Button goOnButton;
    @FXML
    protected Button goBackButton;
    @FXML
    protected Button homeButton;
    @FXML
    protected Button logOutButton;
    @FXML
    protected Button messageButton;
    @FXML
    protected void logOutButtonClick(ActionEvent e){
        ButtonOperation.behaviorLogOut(e);
    }
    @FXML
    protected void messageButtonClick(){
        ButtonOperation.behaviorMsgButton();
    }
    @FXML
    protected void homeButtonClick(ActionEvent e){
        this.pageSwitch.switchTo("First-View/LoggedHompegae.fxml",e,"LoggedHomepage");
    }
    @FXML
    protected abstract void goBackButtonClick(ActionEvent e);
}
