package create;

import applicationcontroller.BuyTicketController;

public class CreateBuyTicket {
    private static CreateBuyTicket instance;

    private BuyTicketController controller;

    public BuyTicketController createController() {
        controller = new BuyTicketController();
        return controller;
    }

    public static CreateBuyTicket getInstance() {
        if (CreateBuyTicket.instance == null)
            CreateBuyTicket.instance = new CreateBuyTicket();
        return instance;
    }
    public BuyTicketController getcontroller(){
        return this.controller;
    }
}
