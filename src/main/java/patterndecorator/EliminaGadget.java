package patterndecorator;

public class EliminaGadget extends DecoratorCarrello{
    public EliminaGadget(Carrello component) {
        super(component);
    }

    public void rimuoviDalCarrello(String nomeGadget) {
        int i=0;
        while(!(this.component.ordine.get(i).getNomeGadget().equals(nomeGadget)) && i<this.component.ordine.size()){
            i++;
        }
        if(!(this.component.ordine.get(i).getNomeGadget().equals(nomeGadget))) {
            this.component.ordine.remove(i);
        }
    }
}
