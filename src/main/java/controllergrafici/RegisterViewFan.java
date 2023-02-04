package controllergrafici;

import applicationcontroller.Registercontroller;
import bean.RegisterBean;
import create.Createregister;
import exception.FormatErrorException;
import exception.NullString;
import exception.ShortPassException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RegisterViewFan extends RegisterView{
    @FXML
    private TextField nomeText;
    private String type;
    @Override
    protected void registerButtonClick() throws ShortPassException, FormatErrorException, NullString {
        RegisterBean b=new RegisterBean( emailText.getText(),passwdText.getText(),null,type,nomeText.getText());
        Createregister log=Createregister.getInstance();
        Registercontroller registra=log.createController();
        registra.registraFan(b);
    }
}
