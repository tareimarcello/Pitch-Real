package controllergrafici;

import applicationcontroller.Registercontroller;
import bean.RegisterBean;
import create.Createregister;
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
        RegisterBean registraClub=null;
        try{
            registraClub = new RegisterBean(emailText.getText(), passwdText.getText(), nomeClubText.getText(), "Club",null);
        } catch (ShortPassException e) {
            PageLoader.pageLoader("First-View/RegisterViewClubShortPass.fxml");
        } catch (FormatErrorException e) {
            PageLoader.pageLoader("First-View/RegisterViewClubFormatError.fxml");
        } catch (NullString e) {
            PageLoader.pageLoader("First-View/RegisterViewClubNullString.fxml");
        }
        Createregister log=Createregister.getInstance();
        Registercontroller registra=log.createController();
        registra.registra(registraClub);                       //Lancio la registrazione
    }
}
