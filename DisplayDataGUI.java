package ContactManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DisplayDataGUI extends javax.swing.JFrame {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private Connection con;
    private Statement stmt;

    public DisplayDataGUI(Connection connection) {
        con = connection;
        initComponents();
        displayData();
    }

    private void initComponents() {
        setTitle("Display All Contacts");

        frame = new JFrame("DISPLAY ALL CONTACTS");
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);

        JButton goBackButton = new JButton("Go Back");
        goBackButton.setBackground(new java.awt.Color(255, 204, 204));
        goBackButton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        goBackButton.setForeground(new java.awt.Color(255, 0, 51));
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to go back to the ContactMainPage
                new ContactMainPage().setVisible(true);
                frame.dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(goBackButton);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void displayData() {
        try {
            stmt = con.createStatement();
            String query = "SELECT * FROM contacts";
            ResultSet resultSet = stmt.executeQuery(query);

            Vector<Vector<Object>> data = new Vector<>();
            Vector<String> columnNames = new Vector<>();
            columnNames.add("CONTACTNAME");
            columnNames.add("EMAIL");
            columnNames.add("CONTACTNUMBER");

            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getString("CONTACTNAME"));
                row.add(resultSet.getString("EMAIL"));
                row.add(resultSet.getString("CONTACTNUMBER"));
                data.add(row);
            }

            tableModel.setDataVector(data, columnNames);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
         new DisplayDataGUI(null);
    }
}
