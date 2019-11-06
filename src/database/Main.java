package database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Main pro = new Main();
        pro.createConnection();
    }

    void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/childcaresystem", "root","mcit59113");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            while(rs.next()) {
                String lastName = rs.getString("StudentLastName");
                String firstName = rs.getString("StudentFirstName");
                int studentID = rs.getInt("StudentID");
                System.out.println(firstName + " " + lastName + " " + studentID);
            }
        } catch(ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
