package dao.queries;

import entity.Account;
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
        String sql = String.format("SELECT * FROM Account join Club on Club=Nome where Email = %s & Passwd= %s ;",mail,passwd);
        return stmt.executeQuery(sql);
    }
    public static ResultSet emailQuery(Statement stm, String mail) throws SQLException {
        String sql=String.format("SELECT * FROM Account where Email = %s ;",mail);
        return stm.executeQuery(sql);
    }
    public static ResultSet typeQuery(Statement stm,String tipo) throws SQLException {
        String sql=String.format("SELECT * FROM Account where Tipo = %s ;",tipo);
        return stm.executeQuery(sql);
    }
    public static int insertAccount(Statement stm, Account newAccount) throws SQLException{
        String insertStatement = String.format("INSERT INTO Account (Email, Passwd, Nome, Tipo,Club) VALUES (%s,'%s','%s',%s,%s)", newAccount.getemail(), newAccount.getPaswd(), newAccount.getNome(), newAccount.getType(),newAccount.getClub().getName());
        return stm.executeUpdate(insertStatement);
    }
}
