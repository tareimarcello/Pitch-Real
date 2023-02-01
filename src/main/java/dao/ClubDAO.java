package dao;

import bean.Buygadgetbean;
import create.Createlogin;
import dao.queries.ClubQuery;
import entity.club;
import exception.ClubNotFoundException;

import java.sql.*;

public class ClubDAO {
    private static String user="";
    private static String passwd="";
    private static String db_url="";
    private static String driver_class_name ="";                                                //Tutte queste sono le credenziali per accedere al database
    public club cercaPerNome(Buygadgetbean bean) throws ClubNotFoundException {
        Statement stm = null;                                                                    //Dichiarazione di statement e connessione
        Connection conn = null;
        club c=null;
        try {
            Class.forName(driver_class_name);                                                                 //Caricamento dinamico del driver mysql
            conn = DriverManager.getConnection(user, passwd, db_url);                                           //Richiesta di connesione al DB
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);         //Creazione dello statement
            ResultSet rs = ClubQuery.CercaSquadraPerNome(stm, bean.getClubName());                            //Lancio della query con conseguente restituzione del result set
            if (!rs.first()) {                                                                                //Lancio l'eccezione nel caso in cui il Result Set risulti vuoto
                ClubNotFoundException e = new ClubNotFoundException("Nessun Club corrisponde al nome:" + bean.getClubName());
                throw e;
            }
            rs.first();
            String nomeClub = rs.getString("Nome");
            int IDClub = rs.getInt("ID");                                                 //Estraggo i dati dalla tabella per nome della colonna
            Createlogin create = Createlogin.getInstance();                                           //Utilizzo la classe Factory per creare un istanza di club
            c = create.createClub(nomeClub, IDClub);
            rs.close();                                             //Chiusura del result set
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (stm != null)
                    stm.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();                       //TUTTA QUESTA PARTE FINALE DEL TRY CATCH DA RIVEDER
            }
        }
        return c;
    }
}
