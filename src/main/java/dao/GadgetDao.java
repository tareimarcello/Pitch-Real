package dao;

import bean.BuyGadgetBean;
import bean.Connectionbean;
import create.Createentity;
import dao.operazionisuconnesione.ConnOperation;
import dao.queries.GadgetQuery;
import entity.Gadget;
import exception.GadgetFinishException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GadgetDao {
    private static String user="";
    private static String dbpasswd="";
    private static String dburl ="";
    private static String driverclassname ="";            //Tutte queste sono le credenziali per accedere al database

    public Gadget cercaPerNomeeClub(BuyGadgetBean searchGadget) throws GadgetFinishException {
        Connectionbean dbConnection=null;
        ConnOperation op=null;
        Gadget foundGadget=null;
        try {
            dbConnection = new Connectionbean(user, dbpasswd, dburl, driverclassname);
            op=new ConnOperation();
            dbConnection=op.openConnection(dbConnection);
            ResultSet gadgetRs = GadgetQuery.keyQuery(dbConnection.getStm(), searchGadget.getGadget(), searchGadget.getClubGadget());                            //Lancio della query con conseguente restituzione del result set
            gadgetRs.first();
            int qt=gadgetRs.getInt("Qt");                       //Estraggo la quantità rimanente
            if(qt==0){
                throw new GadgetFinishException("Quantità terminata");
            }
            Createentity create = Createentity.getInstance();                                           //Utilizzo la classe Factory per creare un istanza di club
            foundGadget=create.createGadget(searchGadget);                       //Creo anche un'istanza di club per realizzare l'associazione tra istanza di club e istanza di account
            gadgetRs.close();                                             //Chiusura del result set
        } catch (SQLException e) {
            System.exit(0);
        } finally {
            op.closeConnection(dbConnection);
        }
        return foundGadget;
    }
}
