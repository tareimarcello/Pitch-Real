package applicationcontroller;

import bean.BuyTicketBean;
import dao.SectorDao;
import entity.Seat;
import entity.Sector;
import exception.SectorFullException;

//Classe che rappresenta il controller applicativo del caso d'uso Buy Ticket
public class BuyTicketController {
    private Sector selectedSector;     //metto private perchè mi interessa che lo usi solo il controller
    private Seat selectedSeat;
    public void verificaDispSector(BuyTicketBean input) throws SectorFullException {
        SectorDao estraiSettore=new SectorDao();
        selectedSector=estraiSettore.cercaPerNome(input);   //Invoco la Dao per cercare il settore per il nome nel database
    }
}
