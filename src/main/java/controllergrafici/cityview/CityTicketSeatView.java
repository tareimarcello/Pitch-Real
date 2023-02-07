package controllergrafici.cityview;

import bean.BuyTicketBean;
import create.CreateBuyTicket;
import exception.DuplicatedNameException;
import exception.FormatErrorException;
import exception.NullSelectionException;
import exception.OccupedSeatException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import loader.PageLoader;

public class CityTicketSeatView extends CityTicketShopView{
    @FXML
    private TextField seatNumber;
    @FXML
    @Override
    protected void goBackButtonClick() {
        PageLoader.pageLoader("First-View/CityTicketShop.fxml");
    }
    @FXML
    private void goToOrder(){
        BuyTicketBean seat=new BuyTicketBean("Manchester City");
        try {
            seat.setSeatNum(seatNumber.getText());
        }catch(NullSelectionException e){               //Catch dell'eccezione in caso di inserimento nullo
            PageLoader.pageLoader("First-View/CitySelectedSeatNullSelection.fxml");
        }catch(FormatErrorException e){                 //Catch dell'eccezione in caso di formato errato
            PageLoader.pageLoader("First-View/CitySelectedSeatFormatError.fxml");
        }
        try {
            CreateBuyTicket.getInstance().getcontroller().verificaDispSeat(seat);
        }catch(OccupedSeatException e){
            PageLoader.pageLoader("First-View/CitySelectSeatWrong.fxml");
        }
        try {
            CreateBuyTicket.getInstance().getcontroller().creaBiglietto();
        }catch(DuplicatedNameException e){
            PageLoader.pageLoader("First-View/ErrorNameExisting.fxml");
        }
    }
}
