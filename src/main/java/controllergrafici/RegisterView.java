package controllergrafici;

import exception.FormatErrorException;
import exception.NullString;
import exception.ShortPassException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import loader.PageLoader;

public abstract class RegisterView {
    @FXML
    protected Button registerButton;
    @FXML
    protected TextField emailText;
    @FXML
    protected TextField passwdText;
    @FXML
    protected Button homeButton;
    @FXML
    protected void homeButtonClick(){
        PageLoader.pageLoader("First-View/Homepage.fxml");
    }
    protected abstract void registerButtonClick() throws ShortPassException, FormatErrorException, NullString;
}
