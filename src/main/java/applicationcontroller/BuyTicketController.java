package applicationcontroller;

import bean.BuyTicketBean;
import dao.SeatDao;
import dao.SectorDao;
import entity.Seat;
import entity.Sector;
import exception.OccupedSeatException;
import exception.SectorFullException;
import loader.PageLoader;

//Classe che rappresenta il controller applicativo del caso d'uso Buy Ticket
public class BuyTicketController {
    private Sector selectedSector;     //metto private perchè mi interessa che lo usi solo il controller
    private Seat selectedSeat;
    public void verificaDispSector(BuyTicketBean input){
        SectorDao estraiSettore=new SectorDao();
        try {
            selectedSector=estraiSettore.cercaPerNome(input);   //Invoco la Dao per cercare il settore per il nome nel database
        }catch(SectorFullException e){
            PageLoader.pageLoader("First-View/CityTicketShopSectorFull.fxml");
        }
    }
    public void verificaDispSeat(BuyTicketBean seat){
        SeatDao estraiSeat=new SeatDao();
        try{
            selectedSeat=estraiSeat.cercaPerNumero(seat);
        }catch(OccupedSeatException e){
            PageLoader.pageLoader("First-View/CitySelectSeatWrong");
        }
    }
    //Manca il pezzo della creazione del biglietto e dela gestione dell'eccezione in caso in cui scrivo male il biglietto
}
