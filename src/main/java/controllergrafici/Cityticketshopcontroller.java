package controllergrafici;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Cityticketshopcontroller {
    @FXML
    private ComboBox<String> sector;
    @FXML
    private Button goOnButton;
    @FXML
    private Button goBackButton;
    @FXML
    private TextField sectorNumber;
    @FXML
    private Button homeButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button messageButton;

    public void initialize(){
        sector.setItems(FXCollections.observableArrayList("North Stand","East Stand","South Stand","The Collin Bell Stand"));
    }
}
