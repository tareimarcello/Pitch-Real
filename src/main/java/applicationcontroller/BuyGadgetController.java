package applicationcontroller;

import bean.BuyGadgetBean;
import dao.GadgetDao;
import entity.Gadget;
import exception.GadgetFinishException;
import loader.PageLoader;
import patterndecorator.AggiungiGadget;
import patterndecorator.Carrello;
import patterndecorator.EliminaGadget;

public class BuyGadgetController {
    public Carrello carrello;
    public BuyGadgetController(){
        this.carrello=new Carrello();
    }
    private Gadget cercaElemento(BuyGadgetBean gadget){
        GadgetDao cercaGadget=new GadgetDao();
        Gadget newGadget=null;
        try {
            newGadget=cercaGadget.cercaPerNomeeClub(gadget);
        }catch(GadgetFinishException e){
            PageLoader.pageLoader("First-View/GadgetFinish.fxml");
        }
        return newGadget;
    }
    public void aggiungiElemento(BuyGadgetBean gadget){
        Gadget foundGadget=this.cercaElemento(gadget);
        AggiungiGadget modifCarrello=new AggiungiGadget(this.carrello);
        modifCarrello.aggiungialCarrello(foundGadget);
    }
    public void rimuoviElemento(BuyGadgetBean gadget){
        Gadget foundGadget=this.cercaElemento(gadget);
        EliminaGadget modifCarrello=new EliminaGadget(this.carrello);
        modifCarrello.rimuoviDalCarrello(foundGadget);
    }
    public void goToOrdine(){
        this.carrello.mostraCarrello();
    }
}
