package dao;

import bean.BuyTicketBean;
import bean.Connectionbean;
import create.Createentity;
import dao.operazionisuconnesione.ConnOperation;
import dao.queries.SectorQuery;
import entity.Sector;
import exception.SectorFullException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SectorDao {
    private static String user="";
    private static String dbpasswd="";
    private static String dburl ="";
    private static String driverclassname ="";
    public Sector cercaPerNome(BuyTicketBean nomeSettore) throws SectorFullException {
        Connectionbean dbConnection = null;
        ConnOperation op = null;
        Sector sectorFetched=null;
        try {
            dbConnection = new Connectionbean(user, dbpasswd, dburl, driverclassname);
            op = new ConnOperation();
            dbConnection = op.openConnection(dbConnection);                                                               //Fase di connnesione al database
            ResultSet sectorRs = SectorQuery.nomeSectorQuery(dbConnection.getStm(), nomeSettore.getSector(), nomeSettore.getNomeClub());                           //Lancio della query con conseguente restituzione del result set
            sectorRs.first();
            String nome = sectorRs.getString("Nome");
            String nomeClub = sectorRs.getString("Club");                                        //leggo i record della tabella settore
            boolean isFull = sectorRs.getBoolean("Full");
            if (isFull) {
                throw new SectorFullException("Settore pieno provane un altro ");                       //Eccezion eche òancio se il settore è pieno
            }
            Createentity create = Createentity.getInstance();                                           //Utilizzo la classe Factory per creare un istanza di club
            sectorFetched = create.createSector(nome, nomeClub);                                      //Creazione dell'entità settore
            sectorRs.close();                                             //Chiusura del result set
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            op.closeConnection(dbConnection);
        }
        return sectorFetched;
    }
}
