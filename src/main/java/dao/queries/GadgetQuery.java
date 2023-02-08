package dao.queries;

import exception.PrivateConstructorException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GadgetQuery {
    private GadgetQuery() throws PrivateConstructorException {
        throw new PrivateConstructorException("Non chiamare questo costruttore");
    }
    public static ResultSet keyQuery(Statement stmt, String nomeGadget, String nomeClub) throws SQLException {
        String sql = String.format("SELECT * FROM Gadget where Nome = %s && Club= %s ;",nomeGadget,nomeClub);
        return stmt.executeQuery(sql);
    }
}
