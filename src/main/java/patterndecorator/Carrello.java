package patterndecorator;

import entity.Gadget;
import loader.PageLoader;

import java.util.ArrayList;

public class Carrello extends InterfacciaCarrello{
    private ArrayList<Gadget> ordine;
    @Override
    public void mostraCarrello() {
        PageLoader.loaderCarrello();
    }
    public ArrayList<Gadget> getOrdine(){
        return this.ordine;
    }
}
