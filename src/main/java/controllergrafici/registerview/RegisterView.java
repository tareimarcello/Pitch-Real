package controllergrafici.registerview;

import exception.FormatErrorException;
import exception.NullString;
import exception.ShortPassException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import loader.Page;

public abstract class RegisterView {
    protected Page pageSwitch = new Page();
    @FXML
    protected Button registerButton;
    @FXML
    protected TextField emailText;
    @FXML
    protected TextField passwdText;
    @FXML
    protected Button homeButton;
    @FXML
    protected void homeButtonClick(ActionEvent e){
        this.pageSwitch.switchTo("First-View/Homepage.fxml", e, "Homepage");
    }
    protected abstract void registerButtonClick(ActionEvent e) throws ShortPassException, FormatErrorException, NullString;
}
