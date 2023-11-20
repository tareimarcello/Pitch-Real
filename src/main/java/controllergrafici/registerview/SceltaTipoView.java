package controllergrafici.registerview;
//Questa è la classe che rappresenta il cpntroller grafico del caso d'uso registrati

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.Page;
public class SceltaTipoView {
    private Page pageSwitch=new Page();
    @FXML
    private Button clubButton;
    @FXML
    private Button fanButton;
    @FXML
    private void clubButtonClick(ActionEvent event){
        this.pageSwitch.switchTo("First-View/RegisterViewClub.fxml", event, "RegisterViewClub");
    }
    @FXML
    private void fanButtonClick(ActionEvent event){
        this.pageSwitch.switchTo("First-View/RegisterViewFan.fxml", event, "RegisterViewFan");
    }
}
