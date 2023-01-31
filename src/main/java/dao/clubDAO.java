package dao;

import bean.buygadgetbean;
import create.createlogin;
import dao.queries.ClubQuery;
import entity.club;

import java.sql.*;

public class clubDAO {
    public static String USER="";
    public static String PASSWD="";
    public static String DB_URL="";
    public static String DRIVER_CLASS_NAME="";                                                //Tutte queste sono le credenziali per accedere al database
    public club CercaPerNome(buygadgetbean Bean) throws Exception {
        Statement stm = null;                                                                    //Dichiarazione di statement e connessione
        Connection conn = null;
        club c=null;
        try {
            Class.forName(DRIVER_CLASS_NAME);                                                                 //Caricamento dinamico del driver mysql
            conn = DriverManager.getConnection(USER, PASSWD, DB_URL);                                           //Richiesta di connesione al DB
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);         //Creazione dello statement
            ResultSet rs = ClubQuery.CercaSquadraPerNome(stm, Bean.getClubName());                            //Lancio della query con conseguente restituzione del result set
            if (!rs.first()) {                                                                                //Lancio l'eccezione nel caso in cui il Result Set risulti vuoto
                Exception e = new Exception("Nessun Club corrisponde al nome:" + Bean.getClubName());
                throw e;
            }
            rs.first();
            String nomeClub = rs.getString("Nome");
            int IDClub = rs.getInt("ID");                                                 //Estraggo i dati dalla tabella per nome della colonna
            createlogin create = createlogin.getInstance();                                           //Utilizzo la classe Factory per creare un istanza di club
            c = create.CreateClub(nomeClub, IDClub);
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