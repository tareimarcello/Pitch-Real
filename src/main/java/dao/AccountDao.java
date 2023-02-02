package dao;

import bean.Loginbean;
import create.Createlogin;
import dao.queries.AccountQuery;
import exception.CredentialException;

import java.sql.*;

public class AccountDao {
    private static String user="";
    private static String dbpasswd="";
    private static String dburl ="";
    private static String driverclassname ="";
    public void cercaAccountperLog(Loginbean b) throws CredentialException{
        Statement stm = null;                                                                    //Dichiarazione di statement e connessione
        Connection conn = null;
        try {
            Class.forName(driverclassname);                                                                 //Caricamento dinamico del driver mysql
            conn = DriverManager.getConnection(user, dbpasswd, dburl);                                           //Richiesta di connesione al DB
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);         //Creazione dello statement
            ResultSet rs = AccountQuery.logQuery(stm, b.getEmail(),b.getPasswd());                            //Lancio della query con conseguente restituzione del result set
            if (!rs.first()) {                                                                                //Lancio l'eccezione nel caso in cui il Result Set risulti vuoto
                throw new CredentialException("Non esiste Account collegato con queste credenziali");
            }
            rs.first();
            String nome = rs.getString("Nome");
            String passwd = rs.getString("Passwd");                                                 //Estraggo i dati dalla tabella per nome della colonna
            String email=rs.getString("Email");
            String type=rs.getString("Type");
            //String nomeClub=rs.getString("NomeClub");
            Createlogin create = Createlogin.getInstance();                                           //Utilizzo la classe Factory per creare un istanza di club
            create.createAccount(nome,passwd,email,type);
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
    }

}
