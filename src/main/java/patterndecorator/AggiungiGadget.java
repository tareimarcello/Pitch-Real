package patterndecorator;

import entity.Gadget;

public class AggiungiGadget extends DecoratorCarrello{
    public AggiungiGadget(Carrello component) {
        super(component);
    }

    public void aggiungialCarrello(Gadget gadget) {
        this.component.getOrdine().add(gadget);
    }
}
