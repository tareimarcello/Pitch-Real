package buttonbehavior;

import create.Createentity;
import loader.PageLoader;
//classe che racchiude i comportamenti di detreminati bottoni
public class ButtonOperation {
    public static void behaviorLogOut(){                       //Metodo che mi fa fare il logout
        Createentity infoAccount=Createentity.getInstance();
        infoAccount.delAccount();
        PageLoader.pageLoader("First-View/Homepage.fxml");
    }
    public static void behaviorMsgButton(){

    }
}
