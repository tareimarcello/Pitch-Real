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
    private Button addButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button logOutButton;
    @FXML
    private Button msgButton;
    @FXML
    private Button goBackButton;
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
        BuyGadgetBean gadget=new BuyGadgetBean("Maglia Home 22/23","Manchester City");
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungiMagliaAway(){
        BuyGadgetBean gadget=new BuyGadgetBean("Maglia Away 22/23","Manchester City");
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungiKitHome(){
        BuyGadgetBean gadget=new BuyGadgetBean("Kit Home 22/23","Manchester City");
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungiKitAway(){
        BuyGadgetBean gadget=new BuyGadgetBean("Kit Away  22/23","Manchester City");
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungiPantsHome(){
        BuyGadgetBean gadget=new BuyGadgetBean("Pants Home 22/23","Manchester City");
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungiPantsAway(){
        BuyGadgetBean gadget=new BuyGadgetBean("Pants Away 22/23","Manchester City");
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungiCappelloVisiera(){
        BuyGadgetBean gadget=new BuyGadgetBean("Cappello Visiera","Manchester City");
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungiCappelloLana(){
        BuyGadgetBean gadget=new BuyGadgetBean("Cappello Lana 22/23","Manchester City");
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungiSocksAway(){
        BuyGadgetBean gadget=new BuyGadgetBean("Socks Away 22/23","Manchester City");
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void aggiungisocksHome() {
        BuyGadgetBean gadget=new BuyGadgetBean("Socks Home 22/23","Manchester City");
        CreateBuyGadget.getInstance().createController().aggiungiElemento(gadget);
    }
    @FXML
    private void rimuoviMagliaHome(){

    }
    @FXML
    private void rimuoviMagliaAway(){

    }
    @FXML
    private void rimuoviKitHome(){

    }
    @FXML
    private void rimuoviKitAway(){

    }
    @FXML
    private void rimuoviPantsHome(){

    }
    @FXML
    private void rimuoviPantsAway(){

    }
    @FXML
    private void rimmuoviCappelloVisiera(){

    }
    @FXML
    private void rimuoviCappelloLana(){

    }
    @FXML
    private void rimuoviSocksAway(){

    }
    @FXML
    private void rimuovisocksHome() {

    }
}
