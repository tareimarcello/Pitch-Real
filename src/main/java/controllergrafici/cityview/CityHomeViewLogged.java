package controllergrafici.cityview;

import buttonbehavior.ButtonOperation;
import create.Createentity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.PageLoader;

public class CityHomeViewLogged extends CityHomeView {
    @FXML
    private Button homeButton;
    @FXML
    private Button logOutButton;
    @FXML
    private Button msgButton;
    @FXML
    public void onHomeButtonClick(ActionEvent e){
        if(Createentity.getInstance().getaccount().equals(null)) {
            PageLoader.pageLoader("Homepage.fxml");             //SE sono logggato carico la pagina loggata altrimenti quella non loggata
        }else{
            PageLoader.pageLoader("LoggedHomepage.fxml");
        }
    }
    @FXML
    private void logOutButtonClick(){                       //Metodo che mi fa fare il logout
        ButtonOperation.behaviorLogOut();                   //
    }
    @FXML
    private void msgButtonClick(){
        ButtonOperation.behaviorMsgButton();
    }
    @Override
    protected void ticketButtonClick() {
        PageLoader.pageLoader("First-View/CityTicketShop.fxml");
    }

    @Override
    protected void gadgetButtonClick() {
        PageLoader.pageLoader("First-View/CityGadgetShop.fxml");
    }
}