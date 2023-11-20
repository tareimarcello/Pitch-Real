package controllergrafici;

import bean.ClubBean;
import buttonbehavior.ButtonOperation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.Page;

public class OrdineEffetuatoView {
    private Page pageSwitch = new Page();
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
    private void goBack(ActionEvent event){      //Implementa Bean con nome club in cui sto nella home
        this.pageSwitch.switchTo("First-View/" + ClubBean.ClubRequest.getNomeClub() + "Logged.fxml", event, "ClubSearchView");
    }
    @FXML
    private void goMsg(){
        ButtonOperation.behaviorMsgButton();
    }
    @FXML
    private void goHome(ActionEvent event){
        this.pageSwitch.switchTo("First-View/LoggedHomepage.fxml", event, "LoggedHomepage");
    }
}
