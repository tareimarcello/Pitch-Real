package controllergrafici;

import bean.BuyTicketBean;
import buttonbehavior.ButtonOperation;
import create.CreateBuyTicket;
import exception.NullSelectionException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import loader.PageLoader;

public class CityticketshopView {
    @FXML
    private ComboBox<String> sector;
    @FXML
    private Button goOnButton;
    @FXML
    private Button goBackButton;
    @FXML
    private Button homeButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button messageButton;

    public void initialize(){               //Metodo per inizializzare la comboBox
        sector.setItems(FXCollections.observableArrayList("North Stand","East Stand","South Stand","The Collin Bell Stand"));
    }
    @FXML
    private void logOutButtonClick(){
        ButtonOperation.behaviorLogOut();
    }
    @FXML
    private void messageButtonClick(){
        ButtonOperation.behaviorMsgButton();
    }
    @FXML
    private void homeButtonClick(){
        PageLoader.pageLoader("First-View/LoggedHomepage.fxml");
    }
    @FXML
    private void goBackButtonClick(){
        PageLoader.pageLoader("First-View/ManchesterCityLogged.fxml");
    }
    @FXML
    private void goToSelectSeat(){
        BuyTicketBean sectorInput=new BuyTicketBean("Manchester City");
        try {
            sectorInput.setSectorName(sector.getValue());
        }catch(NullSelectionException e){
            PageLoader.pageLoader("First-View/CityTicketShopNullSelection.fxml");
        }
        CreateBuyTicket.getInstance().createController().verificaDispSector(sectorInput);
    }
}
