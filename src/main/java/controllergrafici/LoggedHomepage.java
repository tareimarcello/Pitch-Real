package controllergrafici;

import create.Createentity;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.PageLoader;

public class LoggedHomepage extends HomepageView{
    @FXML
    private Button logOutButton;
    @FXML
    private Button msgButton;
    @FXML
    private void logOutButtonClick(){
        Createentity infoAccount=Createentity.getInstance();
        infoAccount.delAccount();
        PageLoader.pageLoader("First-View/Homepage.fxml");
    }
    @FXML
    private void msgButtonClick(){

    }
}
