package controllergrafici;

import bean.Buygadgetbean;
import dao.ClubDAO;
import entity.Club;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import loader.PageLoader;

/*Questa classe rappresenta il controller grafico della HomepageView
 */
public class Homepageview {
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private Button searchButton;
    @FXML
    private TextField researchText;
    @FXML
    public void loginButtonClick(ActionEvent e) {
        PageLoader.pageLoader("First-View/LoginView.fxml");                  //Invoca caricamento della pagina
    }
    @FXML
    public void registerButtonClick(ActionEvent e){
        PageLoader.pageLoader("First-View/SceltaTipoView.fxml");               //Invoca caricamento della pagina
    }
    @FXML
    public void researchButtonClick(ActionEvent e){
        String clubName = researchText.getText();                     //Cattura del testo nella barra di ricerca
        Buygadgetbean bean =new Buygadgetbean(clubName);             //Istanziazione del Bean
        ClubDAO club=new ClubDAO();
        Club researchClub =null;
        try {
            researchClub = club.cercaPerNome(bean);                           //INvocazione della DAO per tirare fuori dallo stato di persistenza il nome del club
        }catch (Exception ex) {                                            //Lancio l'eccezione in casoo non riesca a trovare niente con quel nome sul database
            PageLoader.pageLoader("First-View/HomepageError.fxml");          //Se non trovo niente el db devo comunicarlo all'utente
        }
        if(researchClub !=null) {                                //Se il risultato fosse null allora già ho caricato un'altra pagina e non voglio caricarne
                                                            // una nuova mentre se non fosse null non entro nella clausola cach e devo caricare la pagina nuova
            PageLoader.pageLoader(clubName +".fxml");
        }
    }
}
