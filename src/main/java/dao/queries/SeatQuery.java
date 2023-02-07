package dao.queries;

import exception.PrivateConstructorException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SeatQuery{
    private SeatQuery() throws PrivateConstructorException {
        throw new PrivateConstructorException("Non chiamare questo costruttore");
    }
        public static ResultSet numSeatQuery(Statement stm, String nomeSettore, String numSeat) throws SQLException {
            String sql = "SELECT * FROM Settore where Nome = '" + nomeSettore +"&& Numero = "+ numSeat+"';";
            return stm.executeQuery(sql);
        }
}
