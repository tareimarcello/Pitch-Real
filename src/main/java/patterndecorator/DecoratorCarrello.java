package patterndecorator;

public class DecoratorCarrello extends InterfacciaCarrello{
    Carrello component;
    public DecoratorCarrello(Carrello component){
        this.component=component;
    }
    @Override
    public void mostraCarrello() {
        this.component.mostraCarrello();
    }
}
