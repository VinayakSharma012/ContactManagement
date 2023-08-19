package ContactManagement;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateNewContact extends javax.swing.JFrame {
     Connection con;
     Statement stmt;
    /**
     * Creates new form CreateNewContact
     */
    public CreateNewContact() {

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.print("Driver Activated...");
            con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/contactlogin","root","");
            System.out.print("Database connected...");
            stmt = con.createStatement();
            stmt.executeUpdate("create table if not exists contacts (CONTACTNAME varchar(100) , EMAIL varchar(100), CONTACTNUMBER varchar(100))");
            System.out.print("Table has been created...");
        }
        catch(Exception e)
        {
            System.out.print("Failed!!  "+e);
        }initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        setTitle("Create new contact");

        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton6.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 0, 0));
        jButton6.setText("CONTACT NAME :");

        jButton7.setBackground(new java.awt.Color(255, 204, 204));
        jButton7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 0, 51));
        jButton7.setText("SUBMIT");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });


        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("CREATE NEW CONTACT");

        jButton8.setBackground(new java.awt.Color(255, 204, 204));
        jButton8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 0, 51));
        jButton8.setText("GO BACK");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(51, 0, 0));
        jButton9.setText("E-MAIL :");

        jButton10.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(51, 0, 0));
        jButton10.setText("CONTACT NO :");

        jButton11.setBackground(new java.awt.Color(255, 204, 204));
        jButton11.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 0, 51));
        jButton11.setText("REFRESH");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButton11)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jButton8)
                                                                .addGap(49, 49, 49))
                                                        .addComponent(jTextField1)
                                                        .addComponent(jTextField2)
                                                        .addComponent(jTextField3)))
                                        .addComponent(jLabel1))
                                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton6)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton9))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton10))
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton8)
                                        .addComponent(jButton7)
                                        .addComponent(jButton11))
                                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        if(evt.getSource()==jButton7) {
            String name = jTextField1.getText();
            String email = jTextField2.getText();
            String number = jTextField3.getText().toString();
            try
            {
                stmt.executeUpdate("insert into contacts values('"+name+"', '"+email+"','"+number+"')");
                System.out.print("\n contact added...\n");
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                JOptionPane.showMessageDialog(this,"New contact added");
            }
            catch(Exception e)
            {
                System.out.print("Insertion  Failed !!!"+ e);
            }

        }
    }
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt2) {
        if(evt2.getSource()==jButton8) {
            new ContactMainPage().setVisible(true);
            this.setVisible(false);
        }
    }
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt2) {
        if(evt2.getSource()==jButton11) {
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
        }
    }

    public static void main(String args[]) {
                new CreateNewContact().setVisible(true);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration
}
