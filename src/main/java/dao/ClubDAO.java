package dao;

import bean.ResearchBean;
import bean.Connectionbean;
import create.Createentity;
import dao.operazionisuconnesione.ConnOperation;
import dao.queries.ClubQuery;
import entity.Club;
import exception.ClubNotFoundException;

import java.sql.*;

public class ClubDAO {
    private static String user="";
    private static String dbpasswd="";
    private static String dburl ="";
    private static String driverclassname ="";                                                //Tutte queste sono le credenziali per accedere al database
    public Club cercaPerNome(ResearchBean bean) throws ClubNotFoundException {
        Connectionbean dbConnection = null;
        ConnOperation op = null;
        Club c=null;
        try {
            dbConnection = new Connectionbean(user, dbpasswd, dburl, driverclassname);
            op = new ConnOperation();
            dbConnection = op.openConnection(dbConnection);
            ResultSet clubRs = ClubQuery.cercaSquadraPerNome(dbConnection.getStm(), bean.getClubName());                            //Lancio della query con conseguente restituzione del result set
            if (!clubRs.first()) {                                                                                //Lancio l'eccezione nel caso in cui il Result Set risulti vuoto
                throw new ClubNotFoundException("Nessun Club corrisponde al nome:" + bean.getClubName());
            }
            clubRs.first();
            String nomeClub = clubRs.getString("Nome");             //Estraggo i dati dalla tabella per nome della colonna
            Createentity create = Createentity.getInstance();                                           //Utilizzo la classe Factory per creare un istanza di club
            c = create.createClub(nomeClub);
            clubRs.close();                                             //Chiusura del result set
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            op.closeConnection(dbConnection);
        }
        return c;
    }
}
