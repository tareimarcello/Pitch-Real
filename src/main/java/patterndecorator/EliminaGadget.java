package patterndecorator;

import entity.Gadget;

public class EliminaGadget extends DecoratorCarrello{
    public EliminaGadget(Carrello component) {
        super(component);
    }

    public void rimuoviDalCarrello(Gadget gadget) {
        int i=0;
        while(this.component.ordine.get(i).getNomeGadget()!= gadget.getNomeGadget() && i<this.component.ordine.size()){
            i++;
        }
        if(this.component.ordine.get(i).getNomeGadget()!= gadget.getNomeGadget()) {
            this.component.ordine.remove(i);
        }
    }
}
