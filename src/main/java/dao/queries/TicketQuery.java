package dao.queries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TicketQuery {
    public static ResultSet nameQuery(Statement stm, String nomeProp) throws SQLException {
        String sql="SELECT * FROM Biglietto where Nome = '" + nomeProp + "';";
        return stm.executeQuery(sql);
    }
    public static int insertTicket(Statement stm,String nomeProp,String sector,String seat) throws SQLException {
        String insertStatement = String.format("INSERT INTO Biglietto (Nome, Settore, Seat) VALUES (%s,'%s','%s')",nomeProp,sector,seat);
        return stm.executeUpdate(insertStatement);
    }
}
