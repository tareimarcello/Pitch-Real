package dao.queries;

import exception.PrivateConstructorException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Classe che riassume tutte le query lancianili sulla tabella account
public class AccountQuery {
    private AccountQuery() throws PrivateConstructorException {
        throw new PrivateConstructorException("Non chiamare questo costruttore");
    }
    public static ResultSet logQuery(Statement stmt, String mail, String passwd) throws SQLException {
        String sql = "SELECT * FROM Account join Club on Club=Nome where Email = '" + mail + "'& Passwd="+ passwd +"';'";
        return stmt.executeQuery(sql);
    }
    public static ResultSet nameQuery(Statement stm,String nome) throws SQLException {
        String sql="SELECT * FROM Account where Nome = '" + nome + "';";
        return stm.executeQuery(sql);
    }
    public static ResultSet typeQuery(Statement stm,String tipo) throws SQLException {
        String sql="SELECT * FROM Account where Tipo = '" + tipo + "';";
        return stm.executeQuery(sql);
    }

}
