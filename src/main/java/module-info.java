module pitch {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports main;
    opens main to javafx.fxml;
    exports applicationcontroller;
    opens applicationcontroller to javafx.fxml;
    exports controllergrafici.cityview;
    opens controllergrafici.cityview to javafx.fxml;
    exports controllergrafici.homepageview;
    opens controllergrafici.homepageview to javafx.fxml;
    exports controllergrafici.registerview;
    opens controllergrafici.registerview to javafx.fxml;
    exports controllergrafici.loginview;
    opens controllergrafici.loginview to javafx.fxml;
}