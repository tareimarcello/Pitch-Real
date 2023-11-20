package controllergrafici.cityview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.Page;

public class UnloggedClubHomeView extends ClubHomeView {
    private Page pageSwitch=new Page();
    @FXML
    private Button loginButton;
    @FXML
    private void loginButtonClick(ActionEvent e){
        this.pageSwitch.switchTo("First-View/LoginView.fxml",e,"Login");
    }
    @Override
    protected void ticketButtonClick(ActionEvent e) {
        this.pageSwitch.switchTo("First-View/GoToLogOrRegister.fxml",e,"LogOrRegister");
    }

    @Override
    protected void gadgetButtonClick(ActionEvent e) {
        this.pageSwitch.switchTo("First-View/GoToLogOrRegister.fxml",e,"LogOrRegister");
    }
}
