package controllergrafici;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class RegisterView {
    @FXML
    protected Button RegisterButton;
    @FXML
    protected TextField emailText;
    @FXML
    protected TextField passwdText;
    protected abstract void registerButtonClick();
}
