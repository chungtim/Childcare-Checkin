package database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    public Connection sqlConnect;

    public Database() {
        createConnection();
    }

    public void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.sqlConnect = DriverManager.getConnection("jdbc:mysql://localhost:3308/childcaresystem", "root","mcit59113");
        } catch(ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE,null,ex);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
