package applicationcontroller;

import bean.BuyGadgetBean;
import dao.GadgetDao;
import entity.Gadget;
import exception.GadgetFinishException;
import loader.PageLoader;

import java.util.ArrayList;

public class BuyGadgetController {
    private ArrayList<Gadget> listaGadget;
    public void aggiungiElemento(BuyGadgetBean gadget){
        GadgetDao cercaGadget=new GadgetDao();
        Gadget newGadget=null;
        try {
            newGadget=cercaGadget.cercaPerNomeeClub(gadget);
        }catch(GadgetFinishException e){
            PageLoader.pageLoader("First-View/GadgetFinish.fxml");
        }
        listaGadget.add(newGadget);
    }
}
