package controllergrafici.homepageview;

import buttonbehavior.ButtonOperation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoggedHomepage extends HomepageView {
    @FXML
    private Button logOutButton;
    @FXML
    private Button msgButton;
    @FXML
    private void logOutButtonClick(ActionEvent e){                       //Metodo che mi fa fare il logout
        ButtonOperation.behaviorLogOut(e);
    }
    @FXML
    private void msgButtonClick(){
        ButtonOperation.behaviorMsgButton();
    }
}
