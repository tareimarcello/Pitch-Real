package create;

import applicationcontroller.BuyGadgetController;

public class CreateBuyGadget {
    private static CreateBuyGadget instance;

    private BuyGadgetController controller;

    public BuyGadgetController createController() {
        controller = new BuyGadgetController();
        return controller;
    }

    public static CreateBuyGadget getInstance() {
        if (CreateBuyGadget.instance == null)
            CreateBuyGadget.instance = new CreateBuyGadget();
        return instance;
    }
    public BuyGadgetController getcontroller(){
        return this.controller;
    }
    public void delController(){
        this.controller=null;
    }
}
