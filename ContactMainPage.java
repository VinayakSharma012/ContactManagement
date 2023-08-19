package ContactManagement;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ContactMainPage extends javax.swing.JFrame {
    Connection con;
    ResultSet rs;
    Statement stmt;


     //Creates new form CONTACTMAINPAGE

    public ContactMainPage() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.print("Driver Activated...");
            con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/contactlogin", "root", "");
            System.out.print("Database connected...");
        } catch (Exception e) {
            System.out.print("Failed!!  " + e);
        }
        initComponents();
    }
    /* gui work starts from here */
    private void initComponents() {
        setTitle("contact management system");

        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton4.setBackground(new java.awt.Color(255, 204, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        jButton4.setForeground(new java.awt.Color(255, 51, 51));
        jButton4.setText("CREATE NEW CONTACT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 204, 204));
        jButton5.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        jButton5.setForeground(new java.awt.Color(255, 51, 51));
        jButton5.setText("DELETE CONTACT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 204, 204));
        jButton6.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        jButton6.setForeground(new java.awt.Color(255, 51, 51));
        jButton6.setText("SEARCH CONTACT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 204, 204));
        jButton7.setFont(new java.awt.Font("Segoe UI Black", 1, 14));
        jButton7.setForeground(new java.awt.Color(255, 0, 51));
        jButton7.setText("CONTACT LIST");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt4) {
                jButton7ActionPerformed(evt4);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 36));
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("CONTACT MANAGEMENT SYSTEM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(121, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(98, 98, 98))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(102, Short.MAX_VALUE))
        );

        pack();
    }
    //gui work ends
    //CREATE NEW CONTACT BUTTON EVENT
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == jButton4) {
            CreateNewContact obj3 = new CreateNewContact();
            obj3.setVisible(true);
            this.setVisible(false);
        }
    }
    //DELETE BUTTON EVENT
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == jButton5) {
            DeleteDataGUI obj3 = new DeleteDataGUI(con);
            obj3.setVisible(true);
            this.setVisible(false);
        }
    }
    //SEARCH BUTTON EVENT
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == jButton6) {
            SearchDataGUI obj3 = new SearchDataGUI(con);
            obj3.setVisible(true);
            this.setVisible(false);
        }
    }
    //DISPLAY BUTTON EVENT
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt4) {
        if (evt4.getSource() == jButton7) {
            try {
                String pass = JOptionPane.showInputDialog("Enter your password");
                stmt = con.createStatement();
                String str1 = "select utype from register where password='" + pass + "'";
                rs = stmt.executeQuery(str1);
                if (rs.next()) {
                    String userType = rs.getString("utype");
                    if ("Admin".equals(userType)) {
                        DisplayDataGUI obj4 = new DisplayDataGUI(con);
                        obj4.setVisible(true);
                        this.setVisible(false);
                    }
                    else {
                        JOptionPane.showMessageDialog(this,"Access Denied ( You're not an Admin )");
                    }
                    }
                else {
                    JOptionPane.showMessageDialog(this,"Invalid Password");
                }
            }
            catch(Exception ef) {
                System.out.println("problem found :"+ef);

            }
        }
    }

    public static void main(String args[]) {
        new ContactMainPage().setVisible(true);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration
}
