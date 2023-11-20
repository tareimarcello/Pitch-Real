package controllergrafici.cityview;

import bean.BuyGadgetBean;
import buttonbehavior.ButtonOperation;
import create.CreateBuyGadget;
import exception.GadgetFinishException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.Page;

public class ClubGadgetShopView {
    private Page pageSwitch=new Page();
    private String finish = "GadgetFinish";
    private String finishView = "First-View/GadgetFinish.fxml";
    @FXML
    private Button homeButton;
    @FXML
    private Button addMagliaHomeButton;
    @FXML
    private Button addMagliaAwayButton;
    @FXML
    private Button addKitHomeButton;
    @FXML
    private Button addKitAwayButton;
    @FXML
    private Button addPantsHomeButton;
    @FXML
    private Button addPantsAwayButton;
    @FXML
    private Button removeMagliaHomeButton;
    @FXML
    private Button removeMagliaAwayButton;
    @FXML
    private Button removeKitHomeButton;
    @FXML
    private Button removeKitAwayButton;
    @FXML
    private Button removePantsHomeButton;
    @FXML
    private Button removePantsAwayButton;
    @FXML
    private Button logOutButton;
    @FXML
    private Button msgButton;
    @FXML
    private Button goBackButton;
    @FXML
    private Button goOnButton;
    private String nomeClubShop;
    @FXML
    private void goHome(ActionEvent e){
        this.pageSwitch.switchTo("First-View/LoggedHomepage.fxml",e,"Homepage");
    }
    @FXML
    private void logOut(ActionEvent e){
        ButtonOperation.behaviorLogOut(e);
    }
    @FXML
    private void goToMsg(){
        ButtonOperation.behaviorMsgButton();
    }
    @FXML
    private void goBack(ActionEvent e){
        this.pageSwitch.switchToClub("FirstView/ClubLogged.fxml",e,"","ClubLogged","");
    }
    @FXML
    private void aggiungiMagliaHome(ActionEvent e){
        BuyGadgetBean gadget=new BuyGadgetBean("Maglia Home 22/23",nomeClubShop);
        try {
            CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
        }catch(GadgetFinishException ex){
            this.pageSwitch.switchToClub(finishView,e,"",finish,"");
        }
    }
    @FXML
    private void aggiungiMagliaAway(ActionEvent e){
        BuyGadgetBean gadget=new BuyGadgetBean("Maglia Away 22/23",nomeClubShop);
        try {
            CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
        }catch(GadgetFinishException ex){
            this.pageSwitch.switchToClub(finishView,e,"",finish,"");
        }
    }
    @FXML
    private void aggiungiKitHome(ActionEvent e) {
        BuyGadgetBean gadget = new BuyGadgetBean("Kit Home 22/23", nomeClubShop);
        try {
            CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);

        } catch (GadgetFinishException ex) {
            this.pageSwitch.switchToClub(finishView,e,"",finish,"");
        }
    }
    @FXML
    private void aggiungiKitAway(ActionEvent e){
        BuyGadgetBean gadget=new BuyGadgetBean("Kit Away  22/23",nomeClubShop);
        try {
            CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
        }catch(GadgetFinishException ex){
            this.pageSwitch.switchToClub(finishView,e,"",finish,"");
        }
    }
    @FXML
    private void aggiungiPantsHome(ActionEvent e) {
        BuyGadgetBean gadget = new BuyGadgetBean("Pants Home 22/23", nomeClubShop);
        try {
            CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);

        }catch(GadgetFinishException ex){
            this.pageSwitch.switchToClub(finishView,e,"",finish,"");
        }
    }
    @FXML
    private void aggiungiPantsAway(ActionEvent e){
        BuyGadgetBean gadget=new BuyGadgetBean("Pants Away 22/23",nomeClubShop);
        try {
            CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
        }catch(GadgetFinishException ex){
            this.pageSwitch.switchToClub(finishView,e,"",finish,"");
        }
    }
    @FXML
    private void rimuoviMagliaHome(){
        BuyGadgetBean gadget=new BuyGadgetBean("Maglia Home 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().rimuoviElemento(gadget);
    }
    @FXML
    private void rimuoviMagliaAway(){
        BuyGadgetBean gadget=new BuyGadgetBean("Maglia Away 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().rimuoviElemento(gadget);
    }
    @FXML
    private void rimuoviKitHome(){
        BuyGadgetBean gadget=new BuyGadgetBean("Kit Home 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().rimuoviElemento(gadget);
    }
    @FXML
    private void rimuoviKitAway(){
        BuyGadgetBean gadget=new BuyGadgetBean("Kit Away 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().rimuoviElemento(gadget);
    }
    @FXML
    private void rimuoviPantsHome(){
        BuyGadgetBean gadget=new BuyGadgetBean("Pants Home 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().rimuoviElemento(gadget);
    }
    @FXML
    private void rimuoviPantsAway(){
        BuyGadgetBean gadget=new BuyGadgetBean("Pants Away 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().rimuoviElemento(gadget);
    }
    @FXML
    private void goToCarrello(){
        CreateBuyGadget.getInstance().getcontroller().goToOrdine();
    }
}
