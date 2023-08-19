package ContactManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class SearchDataGUI extends JPanel {

    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField searchField;

    private Connection con;
    private PreparedStatement preparedStatement;

    public SearchDataGUI(Connection connection) {
        this.con = connection;

        component();
    }

    public void component() {
        frame = new JFrame("Search Contacts");
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);

        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchButton.setBackground(new java.awt.Color(255, 204, 204));
        searchButton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 0, 51));
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchContacts();
            }
        });

        JButton goBackButton = new JButton("Go Back");
        goBackButton.setBackground(new java.awt.Color(255, 204, 204));
        goBackButton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        goBackButton.setForeground(new java.awt.Color(255, 0, 51));
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContactMainPage().setVisible(true);
                frame.dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(goBackButton);

        JPanel searchPanel = new JPanel();
        JLabel jLabel = new JLabel("Search by Name or Email: ");
        jLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel.setForeground(new java.awt.Color(51, 0, 0));
        searchPanel.add(jLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        frame.add(searchPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void searchContacts() {
        try {
            String searchText = searchField.getText();
            String query = "SELECT * FROM contacts WHERE CONTACTNAME LIKE ? OR EMAIL LIKE ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, "%" + searchText + "%");
            preparedStatement.setString(2, "%" + searchText + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            // Update table model with search results
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
                searchField.setText("");
            }

            tableModel.setDataVector(data, columnNames);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactlogin", "root", "");
                new SearchDataGUI(con);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
