package dao;

import bean.BuyTicketBean;
import bean.Connectionbean;
import create.Createentity;
import dao.operazionisuconnesione.ConnOperation;
import dao.queries.SectorQuery;
import entity.Seat;
import exception.OccupedSeatException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SeatDao {
    private static String user="";
    private static String dbpasswd="";
    private static String dburl ="";
    private static String driverclassname ="";
    public Seat cercaPerNumero(BuyTicketBean seat) throws OccupedSeatException {
        Connectionbean dbConnection = null;
        ConnOperation op = null;
        Seat seatFetched=null;
        try {
            dbConnection = new Connectionbean(user, dbpasswd, dburl, driverclassname);
            op = new ConnOperation();
            dbConnection = op.openConnection(dbConnection);                                                               //Fase di connnesione al database
            ResultSet seatRs = SectorQuery.nomeSectorQuery(dbConnection.getStm(), seat.getSector(), seat.getSeat());                           //Lancio della query con conseguente restituzione del result set
            if(seatRs.first()){
                throw new OccupedSeatException("Il posto che hai scelto è occupato");
            }
            seatRs.first();
            String num = seatRs.getString("Numero");
            String settore=seatRs.getString("Settore");
            String club = seatRs.getString("Club");                                        //leggo i record della tabella settore
            Createentity create = Createentity.getInstance();                                           //Utilizzo la classe Factory per creare un istanza di club
            seatFetched = create.createSeat(num, settore,club);                                      //Creazione dell'entità settore
            seatRs.close();                                             //Chiusura del result set
        } catch (SQLException e) {
            System.exit(0);
        } finally {
            op.closeConnection(dbConnection);
        }
        return seatFetched;
    }
}
