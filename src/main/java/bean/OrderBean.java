package bean;

import patterndecorator.Carrello;

public class OrderBean {
    private Carrello order;
    public Carrello getCarrello(){
        return this.order;
    }
    public void setOrderBean(Carrello order){
        this.order=order;
    }
}
