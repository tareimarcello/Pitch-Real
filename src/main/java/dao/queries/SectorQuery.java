package dao.queries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Classe che rappresenta le query da fare verso il settore
public class SectorQuery {
    public static ResultSet nomeSectorQuery(Statement stm, String nomeSettore, String nomeClub) throws SQLException {
        String sql = "SELECT * FROM Settore where Nome = '" + nomeSettore +"&& Club = "+ nomeClub+"';";
        return stm.executeQuery(sql);
    }
}
