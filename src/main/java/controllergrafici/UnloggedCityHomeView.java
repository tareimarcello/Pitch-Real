package controllergrafici;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import loader.PageLoader;

public class UnloggedCityHomeView extends CityHomeView{
    @FXML
    private Button loginButton;
    @FXML
    private void loginButtonClick(){
        PageLoader.pageLoader("First-View/LoginView.fxml");
    }
    @Override
    protected void ticketButtonClick() {
        PageLoader.pageLoader("First-View/GoToLogOrRegister.fxml");
    }

    @Override
    protected void gadgetButtonClick() {
        PageLoader.pageLoader("First-View/GoToLogOrRegister.fxml");
    }
}
