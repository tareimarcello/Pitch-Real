module pitch {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports Main;
    opens Main to javafx.fxml;
    exports ControllerGrafici;
    opens ControllerGrafici to javafx.fxml;
    exports ControllerApp;
    opens ControllerApp to javafx.fxml;
}