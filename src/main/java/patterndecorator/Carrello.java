package patterndecorator;

import entity.Gadget;
import loader.PageLoader;

import java.util.ArrayList;

public class Carrello extends InterfacciaCarrello{
    public ArrayList<Gadget> ordine;
    @Override
    public void mostraCarrello() {
        PageLoader.loaderCarrello();
    }
}
