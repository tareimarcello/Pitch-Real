package bean;

import java.sql.Connection;
import java.sql.Statement;
//Bean  che uso nella fase di apertura e chiusura della connessione al database
public class Connectionbean {
    private String user;
    private String passwd;
    private String dburl;
    private String driverclassname;
    private Connection connStabilita;
    private Statement stm;
    public Connectionbean(String us,String pass,String url,String dcs){
        this.user=us;
        this.passwd=pass;
        this.dburl=url;
        this.driverclassname=dcs;
    }
    public String getUser(){
        return this.user;
    }
    public String getPass(){
        return this.passwd;
    }
    public String getdbUrl(){
        return this.dburl;
    }
    public String getdcs(){
        return this.driverclassname;
    }
    public Connection getConnStabilita(){
        return this.connStabilita;
    }
    public Statement getStm(){
        return this.stm;
    }
    public void setConnStabilita(Connection conn){
        this.connStabilita=conn;
    }
    public void setStm(Statement stm){
        this.stm=stm;
    }
}
