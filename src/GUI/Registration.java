package GUI;

import database.Database;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Registration {
    private JTextField fieldFirstName;
    private JButton insertFirstNameButton;
    private JPanel panelMain;
    private JTextField fieldLastName;
    private JTextField fieldGender;
    private JTextField fieldPhone;
    private JTextField fieldParentFirstName;
    private JTextField fieldParentLastName;
    private JTextField fieldEnrolledClassID;
    private Connection sqlConnect;


    public Registration() {
        Database db = new Database();
        this.sqlConnect = db.sqlConnect;

        /**
         * Listener method for student registration. Inserts new row in
         * student table with data populated in fields
         */
        insertFirstNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Initializing data for sql statement
                    String firstName = fieldFirstName.getText();
                    String lastName = fieldLastName.getText();
                    String gender = fieldGender.getText();
                    String phone = fieldPhone.getText();
                    String parentFirstName = fieldParentFirstName.getText();
                    String parentLastName = fieldParentLastName.getText();
                    int enrolledClassID = Integer.parseInt(fieldEnrolledClassID.getText());
                    Calendar calendar = Calendar.getInstance();
                    java.sql.Date DOB = new java.sql.Date(calendar.getTime().getTime());

                    //Preparing SQL statement
                    PreparedStatement stmt = sqlConnect.prepareStatement("INSERT INTO student VALUES(?,?,?,?,?,?,?,?,?,?)");
                    stmt.setInt(1,1002);
                    stmt.setString(2, firstName);
                    stmt.setString(3, lastName);
                    stmt.setDate(4, DOB);
                    stmt.setString(5, gender);
                    stmt.setString(6, phone);
                    stmt.setString(7, parentFirstName);
                    stmt.setString(8, parentLastName);
                    stmt.setInt(9, enrolledClassID);
                    stmt.setString(10, "Absent");

                    //Executing SQL statement
                    stmt.execute();
                    stmt.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Registration.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        });
    }
    /**
     * Initiating GUI
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Registration");
        frame.setContentPane(new Registration().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
