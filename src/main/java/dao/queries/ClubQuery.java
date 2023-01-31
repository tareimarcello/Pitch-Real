package dao.queries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Classe che mi riassume tutte le query che si possono fare verso la tabella Club
public class ClubQuery {
    public static ResultSet CercaSquadraPerNome(Statement stmt, String Nome) throws SQLException {
        String sql = "SELECT * FROM Club where Nome = '" + Nome + "';";
        return stmt.executeQuery(sql);
    }
/*
    public static ResultSet selectAlbumIds(Statement stmt) throws SQLException  {
        String sql = "SELECT DISTINCT AlbumId FROM Album ;";
        System.out.println(sql);
        return stmt.executeQuery(sql);
    }
 */
}