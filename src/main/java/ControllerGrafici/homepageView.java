package ControllerGrafici;

import bean.buyGadgetBean;
import dao.clubDAO;
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
public class homepageView {
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private Button searchButton;
    @FXML
    private TextField researchText;
    private static void pageLoader(String Filename){            //Metodo per il caricamneto della pagina
        FXMLLoader loader = new FXMLLoader(homepageView.class.getClassLoader().getResource(Filename));
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
    public void loginButtonClick(ActionEvent e) {
        homepageView.pageLoader("First-View/LoginView.fxml");                  //Invoca caricamento della pagina
    }
    @FXML
    public void registerButtonClick(ActionEvent e){
        homepageView.pageLoader("First-View/RegisterView.fxml");               //Invoca caricamento della pagina
    }
    @FXML
    public void researchButtonClick(ActionEvent e){
        String clubName = researchText.getText();                     //Cattura del testo nella barra di ricerca
        buyGadgetBean Bean=new buyGadgetBean(clubName);             //Istanziazione del Bean
        clubDAO club=new clubDAO();
        entity.club researchClub =null;
        try {
            researchClub = club.CercaPerNome(Bean);                           //INvocazione della DAO per tirare fuori dallo stato di persistenza il nome del club
        }catch (Exception ex) {                                            //Lancio l'eccezione in casoo non riesca a trovare niente con quel nome sul database
            homepageView.pageLoader("HomepageError.fxml");          //Se non trovo niente el db devo comunicarlo all'utente
        }
        if(researchClub !=null) {                                //Se il risultato fosse null allora già ho caricato un'altra pagina e non voglio caricarne
                                                            // una nuova mentre se non fosse null non entro nella clausola cach e devo caricare la pagina nuova
            homepageView.pageLoader(clubName +".fxml");
        }
    }
}
