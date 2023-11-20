package dao;

import bean.Connectionbean;
import bean.OrderBean;
import dao.operazionisuconnesione.ConnOperation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDao {
    private static String user="";
    private static String dbpasswd="";
    private static String dburl ="";
    private static String driverclassname ="";            //Tutte queste sono le credenziali per accedere al database
    public void insertOrder(OrderBean orderDone){
        // STEP 1: dichiarazioni
        Connectionbean dbConnection=null;
        ConnOperation op=null;
        int i=0;
        try {
            //CReazione statement e instaurazione della connessione
            dbConnection = new Connectionbean(user, dbpasswd, dburl, driverclassname);
            op=new ConnOperation();
            dbConnection=op.openConnection(dbConnection);
            // STEP 4.2: creazione ed esecuzione della query
            dbConnection.setStm(dbConnection.getConnStabilita().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
            for(i=0;i<orderDone.getCarrello().ordine.size();i++) {
                //AccountQuery.insertAccount(dbConnection.getStm(), newAcc);
            }
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            op.closeConnection(dbConnection);
        }

    }
}
