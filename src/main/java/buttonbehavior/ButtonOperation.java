package buttonbehavior;

import create.Createentity;
import exception.PrivateConstructorException;
import javafx.event.ActionEvent;
import loader.Page;
//classe che racchiude i comportamenti di detreminati bottoni
public class ButtonOperation {
    private static Page pageSwitch = new Page();
    private ButtonOperation() throws PrivateConstructorException {
        throw new PrivateConstructorException("");
    }
    public static void behaviorLogOut(ActionEvent e){                       //Metodo che mi fa fare il logout
        Createentity infoAccount=Createentity.getInstance();
        infoAccount.delAccount();
        pageSwitch.switchTo("First-View/Homepage.fxml",e,"Homepage");
    }
    public static void behaviorMsgButton(){

    }
}
