package dao;

import bean.Connectionbean;
import bean.CreateTicketBean;
import create.Createentity;
import dao.operazionisuconnesione.ConnOperation;
import dao.queries.TicketQuery;
import exception.DuplicatedNameException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDao {
    private static String user="";
    private static String dbpasswd="";
    private static String dburl ="";
    private static String driverclassname ="";
    public void newInsertTicket(CreateTicketBean biglietto) throws DuplicatedNameException {
        // STEP 1: dichiarazioni
        Connectionbean dbConnection=null;
        ConnOperation op=null;

        try {
            //CReazione statement e instaurazione della connessione
            dbConnection = new Connectionbean(user, dbpasswd, dburl, driverclassname);
            op=new ConnOperation();
            dbConnection=op.openConnection(dbConnection);

            // In pratica i risultati delle query possono essere visti come un Array Associativo o un Map
            ResultSet rsTicket = TicketQuery.nameQuery(dbConnection.getConnStabilita(),biglietto.getNomeProp());
            if(rsTicket.first()){
                throw new DuplicatedNameException("Hai già comprato un biglietto von questo account");
            }
            rsTicket.close();
            dbConnection.getStm().close();

            // STEP 4.2: creazione ed esecuzione della query
            dbConnection.setStm(dbConnection.getConnStabilita().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            TicketQuery.insertTicket(dbConnection.getStm(), biglietto.getNomeProp(), biglietto.getSelectSector().getNomeSettore(),biglietto.getSelectSeat().getNumSeat());
            Createentity.getInstance().createTicket(biglietto);
            // STEP 5.1: Clean-up dell'ambiente
            rsTicket.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            op.closeConnection(dbConnection);
        }

    }
}
