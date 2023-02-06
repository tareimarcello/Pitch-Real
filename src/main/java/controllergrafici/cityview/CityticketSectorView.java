package controllergrafici.cityview;

import bean.BuyTicketBean;
import create.CreateBuyTicket;
import exception.NullSelectionException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import loader.PageLoader;

public class CityticketSectorView extends CityTicketShopView{
    @FXML
    private ComboBox<String> sector;
    public void initialize(){               //Metodo per inizializzare la comboBox
        sector.setItems(FXCollections.observableArrayList("North Stand","East Stand","South Stand","The Collin Bell Stand"));
    }
    @FXML @Override
    protected void goBackButtonClick(){
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
        PageLoader.pageLoader("First-View/CitySelectSeat.fxml");
    }
}
