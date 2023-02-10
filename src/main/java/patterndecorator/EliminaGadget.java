package patterndecorator;

import entity.Gadget;

public class EliminaGadget extends DecoratorCarrello{
    public EliminaGadget(Carrello component) {
        super(component);
    }

    public void rimuoviDalCarrello(Gadget gadget) {
        int i=0;
        while(!(this.component.getOrdine().get(i).getNomeGadget().equals(gadget.getNomeGadget())) && i<this.component.getOrdine().size()){
            i++;
        }
        if(!(this.component.getOrdine().get(i).getNomeGadget().equals(gadget.getNomeGadget()))) {
            this.component.getOrdine().remove(i);
        }
    }
}
