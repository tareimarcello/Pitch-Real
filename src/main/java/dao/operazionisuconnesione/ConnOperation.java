package dao.operazionisuconnesione;

import bean.Connectionbean;

import java.sql.*;

public class ConnOperation {
    public Connectionbean openConnection(Connectionbean b){
        Connection conn=null;
        Statement stm=null;
        // STEP 2: loading dinamico del driver mysql
        try {
            Class.forName(b.getdcs());
        // STEP 3: apertura connessione
            conn = DriverManager.getConnection(b.getdbUrl(), b.getUser(), b.getPass());
        // STEP 4.1: creazione ed esecuzione della query
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException | ClassNotFoundException e) {
            System.exit(0);
        }
        b.setStm(stm);
        b.setConnStabilita(conn);
        return b;
    }
    public void closeConnection(Connectionbean closebean){
        try {
            if (closebean.getStm() != null)
                closebean.getStm().close();
        } catch (SQLException se2) {
            se2.getMessage();
        }
        try {
            if (closebean.getConnStabilita() != null)
                closebean.getConnStabilita().close();
        } catch (SQLException se) {
            se.getMessage();                       //TUTTA QUESTA PARTE FINALE DEL TRY CATCH DA RIVEDER
        }
    }
}
