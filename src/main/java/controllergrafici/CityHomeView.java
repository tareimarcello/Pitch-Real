package controllergrafici;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public abstract class CityHomeView {
    @FXML
    protected Button ticketButton;
    @FXML
    protected Button gadgetButton;
    @FXML
    protected abstract void ticketButtonClick();
    @FXML
    protected abstract void gadgetButtonClick();
}
