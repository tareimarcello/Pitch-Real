package controllergrafici.cityview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public abstract class ClubHomeView {
    @FXML
    protected Button ticketButton;
    @FXML
    protected Button gadgetButton;
    @FXML
    protected abstract void ticketButtonClick(ActionEvent e);
    @FXML
    protected abstract void gadgetButtonClick(ActionEvent e);
}
