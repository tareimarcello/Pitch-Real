package controllergrafici.homepageview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.Page;

/*Questa classe rappresenta il controller grafico della HomepageView
 */
public class HomepagUnloggedView extends HomepageView {
    private Page pageSwitch = new Page();
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;

    @FXML
    public void loginButtonClick(ActionEvent e) {
        this.pageSwitch.switchToClub("First-View/ClubGadgetShop.fxml", e,"Manchester City" ,"Login","");
        //this.pageSwitch.switchTo("First-View/LoginView.fxml", e, "Login");              //Invoca caricamento della pagina
    }
    @FXML
    public void registerButtonClick(ActionEvent e){
        this.pageSwitch.switchTo("First-View/RegisterView.fxml", e, "Login");               //Invoca caricamento della pagina
    }
}
