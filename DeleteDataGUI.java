package ContactManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDataGUI extends JPanel {

    private JFrame frame;
    private JTextField deleteField;
    private Connection con;
    private PreparedStatement preparedStatement;

    public DeleteDataGUI(Connection connection) {
        this.con = connection;

        initializeComponents();
    }

    private void initializeComponents() {
        frame = new JFrame("Delete Contact");
        deleteField = new JTextField(20);
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(new java.awt.Color(255, 204, 204));
        deleteButton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 0, 51));
        JButton goBackButton = new JButton("Go Back");
        goBackButton.setBackground(new java.awt.Color(255, 204, 204));
        goBackButton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        goBackButton.setForeground(new java.awt.Color(255, 0, 51));

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContactMainPage().setVisible(true);
                frame.dispose(); // Close the current window
            }
        });

        JPanel deletePanel = new JPanel();
        JLabel jLabel = new JLabel("Enter Name or Email to Delete: ");
        jLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel.setForeground(new java.awt.Color(51, 0, 0));
        deletePanel.add(jLabel);
        deletePanel.add(deleteField);
        deletePanel.add(deleteButton);
        deletePanel.add(goBackButton);

        frame.add(deletePanel, BorderLayout.CENTER);

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void deleteContact() {
        String deleteInput = deleteField.getText().trim();

        if (!deleteInput.isEmpty()) {
            try {
                String deleteQuery = "DELETE FROM contacts WHERE CONTACTNAME = ? OR EMAIL = ?";
                preparedStatement = con.prepareStatement(deleteQuery);
                preparedStatement.setString(1, deleteInput);
                preparedStatement.setString(2, deleteInput);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    deleteField.setText("");
                    JOptionPane.showMessageDialog(this, "Contact(s) deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "No contacts found with the given Name or Email.");
                }
            } catch (SQLException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(this, "Error deleting contact: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid Name or Email.");
        }
    }


    public static void main(String[] args) {
        {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactlogin", "root", "");
                new DeleteDataGUI(con);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}