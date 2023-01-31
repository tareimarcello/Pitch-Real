package ControllerGrafici;

import BEAN.BuyGadgetBean;
import DAO.ClubDAO;
import Entity.Club;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/*Questa classe rappresenta il controller grafico della HomepageView
 */
public class HomepageView {
    @FXML
    private Button LoginButton;
    @FXML
    private Button RegisterButton;
    @FXML
    private Button SearchButton;
    @FXML
    private TextField ResearchText;
    private static void PageLoader(String Filename){            //Metodo per il caricamneto della pagina
        FXMLLoader loader = new FXMLLoader(HomepageView.class.getClassLoader().getResource(Filename));
        Parent root = null;
        try {
            root = loader.load();           //caricamento della pagina del Login
        } catch (IOException exception) {
            System.exit(0);
            /* Manca la roba per la gestione dell'errore*/
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 500, 500));
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void LoginButtonClick(ActionEvent e) {
        HomepageView.PageLoader("First-View/LoginView.fxml");                  //Invoca caricamento della pagina
    }
    @FXML
    public void RegisterButtonClick(ActionEvent e){
        HomepageView.PageLoader("First-View/RegisterView.fxml");               //Invoca caricamento della pagina
    }
    @FXML
    public void ResearchButtonClick(ActionEvent e){
        String ClubName=ResearchText.getText();                     //Cattura del testo nella barra di ricerca
        BuyGadgetBean Bean=new BuyGadgetBean(ClubName);             //Istanziazione del Bean
        ClubDAO club=new ClubDAO();
        Club ResearchClub=null;
        try {
            ResearchClub = club.CercaPerNome(Bean);                           //INvocazione della DAO per tirare fuori dallo stato di persistenza il nome del club
        }catch (Exception ex) {                                            //Lancio l'eccezione in casoo non riesca a trovare niente con quel nome sul database
            HomepageView.PageLoader("HomepageError.fxml");          //Se non trovo niente el db devo comunicarlo all'utente
        }
        if(ResearchClub!=null) {                                //Se il risultato fosse null allora già ho caricato un'altra pagina e non voglio caricarne
                                                            // una nuova mentre se non fosse null non entro nella clausola cach e devo caricare la pagina nuova
            HomepageView.PageLoader(ClubName+".fxml");
        }
    }
}
