package controllergrafici.cityview;

import bean.BuyTicketBean;
import create.CreateBuyTicket;
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
        seat.setSeatNum(seatNumber.getText());
        CreateBuyTicket.getInstance().getcontroller().verificaDispSeat(seat);
    }
}
