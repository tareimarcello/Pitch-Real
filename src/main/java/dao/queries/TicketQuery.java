package dao.queries;

import exception.PrivateConstructorException;

import java.sql.*;

public class TicketQuery {
    private TicketQuery() throws PrivateConstructorException {
        throw new PrivateConstructorException("Non chiamare questo costruttore");
    }
    public static ResultSet nameQuery(Connection conn, String nomeProp) throws SQLException {
        Statement stmt1 = null;
        PreparedStatement pstmt = null;
        String query = "SELECT * FROM Biglietto where Nome = '" + nomeProp + "';";

        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, nomeProp);  // NO SONAR
        ResultSet rs2 = pstmt.executeQuery();
        return rs2;
    }
    public static int insertTicket(Statement stm,String nomeProp,String sector,String seat) throws SQLException {
        String insertStatement = String.format("INSERT INTO Biglietto (Nome, Settore, Seat) VALUES (%s,'%s','%s')",nomeProp,sector,seat);
        return stm.executeUpdate(insertStatement);
    }
}
