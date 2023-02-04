package controllergrafici;

import bean.RegisterBean;
import exception.FormatErrorException;
import exception.NullString;
import exception.ShortPassException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import loader.PageLoader;

public class RegisterViewClub extends RegisterView{
    @FXML
    private TextField nomeClubText;
    @Override
    protected void registerButtonClick() {
        try{
            RegisterBean registraClub = new RegisterBean(emailText.getText(), passwdText.getText(), nomeClubText.getText(), "Club",null);
        } catch (ShortPassException e) {
            PageLoader.pageLoader("First-View/RegisterViewClubShortPass.fxml");
        } catch (FormatErrorException e) {
            PageLoader.pageLoader("First-View/RegisterViewClubFormatError.fxml");
        } catch (NullString e) {
            PageLoader.pageLoader("First-View/RegisterViewClubNullString.fxml");
        }
    }
}
