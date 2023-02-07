package dao.queries;

import exception.PrivateConstructorException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Classe che mi riassume tutte le query che si possono fare verso la tabella Club
public class ClubQuery {
    private ClubQuery() throws PrivateConstructorException {
        throw new PrivateConstructorException("Non chiamare questo costruttore");
    }
    public static ResultSet cercaSquadraPerNome(Statement stmt, String nome) throws SQLException {
        String sql = String.format("SELECT * FROM Club where Nome =  %s  ;",nome);
        return stmt.executeQuery(sql);
    }
}