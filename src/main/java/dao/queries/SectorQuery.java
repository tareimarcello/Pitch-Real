package dao.queries;

import exception.PrivateConstructorException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Classe che rappresenta le query da fare verso il settore
public class SectorQuery {
    private SectorQuery() throws PrivateConstructorException {
        throw new PrivateConstructorException("Non chiamare questo costruttore");
    }
    public static ResultSet nomeSectorQuery(Statement stm, String nomeSettore, String nomeClub) throws SQLException {
        String sql = String.format("SELECT * FROM Settore where Nome = %s && Club = %s ;",nomeSettore,nomeClub);
        return stm.executeQuery(sql);
    }
}
