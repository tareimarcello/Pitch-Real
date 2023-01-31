package ControllerGrafici;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CityTicketShopController {
    @FXML
    private ComboBox<String> Sector;
    @FXML
    private Button goOnButton;
    @FXML
    private Button goBackButton;
    @FXML
    private TextField SectorNumber;
    @FXML
    private Button HomeButton;
    @FXML
    private Button LogoutButton;
    @FXML
    private Button messageButton;

    public void initialize(){
        Sector.setItems(FXCollections.observableArrayList("North Stand","East Stand","South Stand","The Collin Bell Stand"));
    }
}
