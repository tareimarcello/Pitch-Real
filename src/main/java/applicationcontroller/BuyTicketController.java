package applicationcontroller;

import bean.BuyTicketBean;
import dao.SectorDao;
import exception.SectorFullException;
import loader.PageLoader;

//Classe che rappresenta il controller applicativo del caso d'uso Buy Ticket
public class BuyTicketController {
    public void verificaDispSector(BuyTicketBean input){
        SectorDao estraiSettore=new SectorDao();
        try {
            estraiSettore.cercaPerNome(input);   //Invoco la Dao per cercare il settore per il nome nel database
        }catch(SectorFullException e){
            PageLoader.pageLoader("First-View/CityTicketShopSectorFull.fxml");
        }
    }
}
