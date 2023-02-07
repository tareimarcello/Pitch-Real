package dao.queries;

import exception.PrivateConstructorException;

import java.sql.*;

public class TicketQuery {
    private TicketQuery() throws PrivateConstructorException {
        throw new PrivateConstructorException("Non chiamare questo costruttore");
    }
    public static ResultSet nameQuery(Connection conn, String nomeProp) throws SQLException {
        String sql="SELECT * FROM Biglietto where Nome = '" + nomeProp + "';";
        PreparedStatement pstm=conn.prepareStatement(sql);
        pstm.setString(1,nomeProp);
        return pstm.executeQuery(sql);
    }
    public static int insertTicket(Statement stm,String nomeProp,String sector,String seat) throws SQLException {
        String insertStatement = String.format("INSERT INTO Biglietto (Nome, Settore, Seat) VALUES (%s,'%s','%s')",nomeProp,sector,seat);
        return stm.executeUpdate(insertStatement);
    }
}
