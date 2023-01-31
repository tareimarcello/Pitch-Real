package ControllerGrafici;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CityHomeController {
    private Button HomeButton;
    @FXML
    public void OnHomeButtonClick(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
        Parent root=loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }
}