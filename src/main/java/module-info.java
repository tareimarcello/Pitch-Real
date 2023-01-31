module pitch {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports main;
    opens main to javafx.fxml;
    exports ControllerGrafici;
    opens ControllerGrafici to javafx.fxml;
    exports controllerApp;
    opens controllerApp to javafx.fxml;
}