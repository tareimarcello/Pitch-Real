package applicationcontroller;

import bean.BuyTicketBean;
import bean.CreateTicketBean;
import create.Createentity;
import dao.SeatDao;
import dao.SectorDao;
import dao.TicketDao;
import entity.Seat;
import entity.Sector;
import exception.DuplicatedNameException;
import exception.OccupedSeatException;
import exception.SectorFullException;
import loader.PageLoader;

//Classe che rappresenta il controller applicativo del caso d'uso Buy Ticket
public class BuyTicketController {
    private Sector selectedSector;     //metto private perchè mi interessa che lo usi solo il controller
    private Seat selectedSeat;
    public void verificaDispSector(BuyTicketBean input) throws SectorFullException {
        SectorDao estraiSettore=new SectorDao();
        selectedSector=estraiSettore.cercaPerNome(input);   //Invoco la Dao per cercare il settore per il nome nel database
    }
    public void verificaDispSeat(BuyTicketBean seat) throws OccupedSeatException {
        SeatDao estraiSeat=new SeatDao();
        selectedSeat=estraiSeat.cercaPerNumero(seat);
    }
    public void creaBiglietto() throws DuplicatedNameException {                //metodo che crea un'istanza di bilgietto
        TicketDao createBiglietto=new TicketDao();
        createBiglietto.newInsertTicket(new CreateTicketBean(selectedSeat, selectedSector, Createentity.getInstance().getaccount().getNome()));            //Sto passando come ultimo parametro il nome dell'Account che fa l'acquisto
        PageLoader.ticketPageLoader("First-View/CitySelectSeatOrder.fxml");
    }
}
