package controllergrafici;

import exception.FormatErrorException;
import exception.NullString;
import exception.ShortPassException;
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
    protected abstract void registerButtonClick() throws ShortPassException, FormatErrorException, NullString;
}
