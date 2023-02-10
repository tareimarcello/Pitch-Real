package controllergrafici.cityview;

import bean.BuyGadgetBean;
import buttonbehavior.ButtonOperation;
import create.CreateBuyGadget;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.PageLoader;

public class CityGadgetShopView {
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
    private Button addCappelloVisieraButton;
    @FXML
    private Button addCappelloLanaButton;
    @FXML
    private Button addSocksHomeButton;
    @FXML
    private Button addSocksAwayButton;
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
    private Button removeCappelloVisieraButton;
    @FXML
    private Button removeCappelloLanaButton;
    @FXML
    private Button removeSocksHomeButton;
    @FXML
    private Button removeSocksAwayButton;
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
    private void goHome(){
        PageLoader.pageLoader("First-View/LoggedHomepage.fxml");
    }
    @FXML
    private void logOut(){
        ButtonOperation.behaviorLogOut();
    }
    @FXML
    private void goToMsg(){
        ButtonOperation.behaviorMsgButton();
    }
    @FXML
    private void goBack(){
        PageLoader.pageLoader("First-View/ManchesterCityLogged.fxml");
    }
    @FXML
    private void aggiungiMagliaHome(){
        BuyGadgetBean gadget=new BuyGadgetBean("Maglia Home 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungiMagliaAway(){
        BuyGadgetBean gadget=new BuyGadgetBean("Maglia Away 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungiKitHome(){
        BuyGadgetBean gadget=new BuyGadgetBean("Kit Home 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungiKitAway(){
        BuyGadgetBean gadget=new BuyGadgetBean("Kit Away  22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungiPantsHome(){
        BuyGadgetBean gadget=new BuyGadgetBean("Pants Home 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungiPantsAway(){
        BuyGadgetBean gadget=new BuyGadgetBean("Pants Away 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungiCappelloVisiera(){
        BuyGadgetBean gadget=new BuyGadgetBean("Cappello Visiera",nomeClubShop);
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungiCappelloLana(){
        BuyGadgetBean gadget=new BuyGadgetBean("Cappello Lana 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungiSocksAway(){
        BuyGadgetBean gadget=new BuyGadgetBean("Socks Away 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungiSocksHome() {
        BuyGadgetBean gadget=new BuyGadgetBean("Socks Home 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
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
    private void rimuoviCappelloVisiera(){
        BuyGadgetBean gadget=new BuyGadgetBean("Cappello Visiera 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().rimuoviElemento(gadget);
    }
    @FXML
    private void rimuoviCappelloLana(){
        BuyGadgetBean gadget=new BuyGadgetBean("Cappello Lana 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().rimuoviElemento(gadget);
    }
    @FXML
    private void rimuoviSocksAway(){
        BuyGadgetBean gadget=new BuyGadgetBean("Socks Away 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().rimuoviElemento(gadget);
    }
    @FXML
    private void rimuoviSocksHome() {
        BuyGadgetBean gadget=new BuyGadgetBean("Socks Home 22/23",nomeClubShop);
        CreateBuyGadget.getInstance().createController().rimuoviElemento(gadget);
    }
    @FXML
    private void goToCarrello(){
        CreateBuyGadget.getInstance().getcontroller().goToOrdine();
    }
}
