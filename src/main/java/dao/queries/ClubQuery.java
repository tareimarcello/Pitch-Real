package dao.queries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Classe che mi riassume tutte le query che si possono fare verso la tabella Club
public class ClubQuery {
    public static ResultSet cercaSquadraPerNome(Statement stmt, String nome) throws SQLException {
        String sql = "SELECT * FROM Club where Nome = '" + nome + "';";
        return stmt.executeQuery(sql);
    }
}