package patterndecorator;

import entity.Gadget;
import loader.PageLoader;

import java.util.ArrayList;
import java.util.List;

public class Carrello extends InterfacciaCarrello{
    public final List<Gadget> ordine;
    public Carrello() {
        this.ordine=new ArrayList<Gadget>();
    }
    @Override
    public void mostraCarrello() {
        PageLoader.loaderCarrello();
    }
}
