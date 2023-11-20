package controllergrafici.cityview;

import buttonbehavior.ButtonOperation;
import create.Createentity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.Page;
//Rivedi come caricare dinamicamente il nome della squadra
public class ClubHomeViewLogged extends ClubHomeView {
    private Page pageSwitch = new Page();
    @FXML
    private Button homeButton;
    @FXML
    private Button logOutButton;
    @FXML
    private Button msgButton;
    @FXML
    public void onHomeButtonClick(ActionEvent e){
        if(Createentity.getInstance().getaccount().equals(null)) {
            this.pageSwitch.switchTo("First-View/Homepage.fxml", e, "Homepage");
        }else{
            this.pageSwitch.switchTo("First-View/LoggedHomepage.fxml", e, "LoggedHomepage");
        }
    }
    @FXML
    private void logOutButtonClick(ActionEvent e){                       //Metodo che mi fa fare il logout
        ButtonOperation.behaviorLogOut();                   //
    }
    @FXML
    private void msgButtonClick(ActionEvent e){
        ButtonOperation.behaviorMsgButton();
    }
    @Override
    protected void ticketButtonClick(ActionEvent e) {
        this.pageSwitch.switchToClub("First-View/ClubTicketShop.fxml",e,"","ClubTicketShop","");
    }

    @Override
    protected void gadgetButtonClick(ActionEvent e) {
        this.pageSwitch.switchToClub("First-View/ClubGadgetShop.fxml", e,"", "RegisterViewFanNullString","");      //Toccherà passare il clubname
    }
}