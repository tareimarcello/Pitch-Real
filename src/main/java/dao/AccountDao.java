package dao;

import bean.Connectionbean;
import bean.Loginbean;
import bean.RegisterBean;
import create.Createentity;
import dao.operazionisuconnesione.ConnOperation;
import dao.queries.AccountQuery;
import entity.Account;
import entity.Club;
import exception.CredentialException;
import exception.DuplicatedRecordException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
    private static String user="";
    private static String dbpasswd="";
    private static String dburl ="";
    private static String driverclassname ="";
    public void cercaAccountperLog(Loginbean b) throws CredentialException{
        Club c=null;
        Connectionbean dbConnection=null;
        ConnOperation op=null;
        try {
            dbConnection = new Connectionbean(user, dbpasswd, dburl, driverclassname);
            op=new ConnOperation();
            dbConnection=op.openConnection(dbConnection);
            ResultSet rs = AccountQuery.logQuery(dbConnection.getStm(), b.getEmail(),b.getPasswd());                            //Lancio della query con conseguente restituzione del result set
            if (!rs.first()) {                                                                                //Lancio l'eccezione nel caso in cui il Result Set risulti vuoto
                throw new CredentialException("Non esiste Account collegato con queste credenziali");
            }
            rs.first();
            String nome = rs.getString("Nome");
            String passwd = rs.getString("Passwd");                                                 //Estraggo i dati dalla tabella per nome della colonna
            String email=rs.getString("Email");
            String type=rs.getString("Type");
            String nomeClub=rs.getString("NomeClub");
            Createentity create = Createentity.getInstance();                                           //Utilizzo la classe Factory per creare un istanza di club
            c=create.createClub(nomeClub);                       //Creo anche un'istanza di club per realizzare l'associazione tra istanza di club e istanza di account
            create.createAccount(nome,passwd,email,type,c);
            rs.close();                                             //Chiusura del result set
        } catch (SQLException e) {
            System.exit(0);
        } finally {
            op.closeConnection(dbConnection);
        }
    }
    public void newInsert(RegisterBean b, Account newAcc){
            // STEP 1: dichiarazioni
        Connectionbean dbConnection=null;
        ConnOperation op=null;

            try {
                //CReazione statement e instaurazione della connessione
                dbConnection = new Connectionbean(user, dbpasswd, dburl, driverclassname);
                op=new ConnOperation();
                dbConnection=op.openConnection(dbConnection);

                // In pratica i risultati delle query possono essere visti come un Array Associativo o un Map
                ResultSet rs = AccountQuery.emailQuery(dbConnection.getStm(),b.getEmail());
                while (rs.next()) {
                    // lettura delle colonne "by name"
                    String email = rs.getString("Email");
                    if (email.equals(newAcc.getemail())){
                        throw new DuplicatedRecordException(email + " è già assegnata");
                    }
                }

                rs.close();
                dbConnection.getStm().close();

                // STEP 4.2: creazione ed esecuzione della query
                dbConnection.setStm(dbConnection.getConnStabilita().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
                AccountQuery.insertAccount(dbConnection.getStm(), newAcc);

                // STEP 5.1: Clean-up dell'ambiente
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (DuplicatedRecordException e) {
                throw new RuntimeException(e);
            } finally {
                op.closeConnection(dbConnection);
            }

    }

}
