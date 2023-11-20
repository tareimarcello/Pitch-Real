package applicationcontroller;

import bean.BuyGadgetBean;
import bean.OrderBean;
import dao.GadgetDao;
import dao.OrderDao;
import entity.Gadget;
import exception.GadgetFinishException;
import loader.Page;
import patterndecorator.AggiungiGadget;
import patterndecorator.Carrello;
import patterndecorator.EliminaGadget;

public class BuyGadgetController {
    private Page pageSwitch=new Page();
    private Carrello carrello;
    public BuyGadgetController(){
        this.carrello=new Carrello();
    }
    private Gadget cercaElemento(BuyGadgetBean gadget) throws GadgetFinishException{
        GadgetDao cercaGadget=new GadgetDao();
        Gadget newGadget;
        newGadget=cercaGadget.cercaPerNomeeClub(gadget);
        return newGadget;
    }
    public void aggiungiElemento(BuyGadgetBean gadget) throws GadgetFinishException {
        Gadget foundGadget=this.cercaElemento(gadget);
        AggiungiGadget modifCarrello=new AggiungiGadget(this.carrello);
        modifCarrello.aggiungialCarrello(foundGadget);
    }
    public void rimuoviElemento(BuyGadgetBean gadget){
        EliminaGadget modifCarrello=new EliminaGadget(this.carrello);
        modifCarrello.rimuoviDalCarrello(gadget.getGadget());
    }
    public void goToOrdine(){
        this.carrello.mostraCarrello();
        this.sendNotifica();
    }
    public Carrello getCarrello(){
        return this.carrello;
    }
    public void sendNotifica(){
        OrderDao order=new OrderDao();
        OrderBean ord=new OrderBean();
        ord.setOrderBean(this.getCarrello());
        order.insertOrder(ord);
    }
}
