package patterndecorator;

import entity.Gadget;
import loader.PageLoader;

import java.util.ArrayList;

public class Carrello extends InterfacciaCarrello{
    public final ArrayList<Gadget> ordine;
    public Carrello() {
        this.ordine=new ArrayList<Gadget>();
    }
    @Override
    public void mostraCarrello() {
        PageLoader.loaderCarrello();
    }
}
