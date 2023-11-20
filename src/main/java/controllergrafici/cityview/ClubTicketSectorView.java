package controllergrafici.cityview;

import bean.BuyTicketBean;
import create.CreateBuyTicket;
import exception.NullSelectionException;
import exception.SectorFullException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import loader.Page;

public class ClubTicketSectorView extends ClubTicketShopView {
    private Page pageSwitch =new Page();
    @FXML
    private ComboBox<String> sector;
    public void initialize(){               //Metodo per inizializzare la comboBox
        sector.setItems(FXCollections.observableArrayList("North Stand","East Stand","South Stand","The Collin Bell Stand"));
    }
    @FXML
    @Override
    protected void goBackButtonClick(ActionEvent e){
        this.pageSwitch.switchToClub("First-View/ClubLogged.fxml",e,"","ClubLogged","");
    }
    @FXML
    private void goToSelectSeat(ActionEvent event){
        BuyTicketBean sectorInput=new BuyTicketBean("Manchester City");
        try {
            sectorInput.setSectorName(sector.getValue());
        }catch(NullSelectionException e){
            this.pageSwitch.switchToClub("ClubSectorFull.fxml", event, "","ClubSectorFull","");
        }
        try {
            CreateBuyTicket.getInstance().createController().verificaDispSector(sectorInput);
        }catch(SectorFullException e){
            this.pageSwitch.switchToClub("ClubTicketShopNullSelection.fxml", event, "","ClubTicketShopNullSelection","");
        }
        this.pageSwitch.switchToClub("First-View/ClubSeatOrder",event,"","ClubSeatOrder","");
    }
}
