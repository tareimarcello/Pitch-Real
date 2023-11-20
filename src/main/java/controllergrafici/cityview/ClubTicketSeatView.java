package controllergrafici.cityview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.Page;

public class ClubTicketSeatView extends ClubTicketShopView {
    private Page pageSwitch = new Page();
    @FXML
    private Button sendMail;
    @FXML
    private Button goSquadHome;
    @FXML
    @Override
    protected void goBackButtonClick(ActionEvent e) {
        this.pageSwitch.switchToClub("First-View/ClubTicketShop.fxml",e,"","ClubTicketShop","");
    }
    @FXML
    private void sendMailButtonClick(ActionEvent e){
       this.pageSwitch.switchToClub("First-View/ClubSeatOrder.fxml",e,"","GadgetShopOrder","Biglietto inviato via mail");
    }
    @FXML
    private void goSquadHomeButtonClick(ActionEvent e){
        this.pageSwitch.switchToClub("First-View/ClubLogged",e,"","Club Logged","");
    }
    /*
    @FXML
    private void goToOrder(){
        BuyTicketBean seat=new BuyTicketBean("Manchester City");
        try {
            seat.setSeatNum(seatNumber.getText());
        }catch(NullSelectionException e){               //Catch dell'eccezione in caso di inserimento nullo

        }catch(FormatErrorException e){                 //Catch dell'eccezione in caso di formato errato

        }
        try {
            CreateBuyTicket.getInstance().getcontroller().verificaDispSeat(seat);
        }catch(OccupedSeatException e){
        }
        try {
            CreateBuyTicket.getInstance().getcontroller().creaBiglietto();
        }catch(DuplicatedNameException e){

        }
    }
    */

}
