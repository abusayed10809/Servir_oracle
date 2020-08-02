/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
//import servir_project.UI.CustomerInterface;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.sql.*;
import javax.swing.JFrame;

/**
 *
 * @author shehr
 */
public class Customer_Cart extends javax.swing.JFrame {

    /**
     * Creates new form Customer_Cart
     */
    public static String currentCustID;
    
    public Customer_Cart() {
        initComponents();
        fillTable();
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 24));
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 24));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public Connection OracleConnection() {
        Connection conn;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "shehreen", "oliveoil1000");
//            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:morcl", "shehreen", "oliveoil1000");
            //JOptionPane.showMessageDialog(null,"Database Connection Successful...");
            return conn;
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "oracle Connection Failed...");
            return null;
        }
    }

    public ArrayList<CartBean> retrieveData() {
        ArrayList<CartBean> al = new ArrayList<>();

        try {
            Connection conn = OracleConnection();
            String qry = "select * from cart";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(qry);

            while (rs.next()) {
                CartBean cart = new CartBean(rs.getInt(1), rs.getString("name"), rs.getInt(3), rs.getInt(4));
                al.add(cart);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return al;
    }

    public ArrayList<MenuBean> retrieveDatamenu() {
        ArrayList<MenuBean> al = new ArrayList<>();

        try {
            Connection conn = OracleConnection();
            String qry = "select * from menu";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(qry);

            while (rs.next()) {
                MenuBean menu = new MenuBean(rs.getInt(1), rs.getString("name"), rs.getInt(3), rs.getInt(4));
                al.add(menu);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return al;
    }

    public void fillTable() {
        ArrayList<CartBean> al = null;
        al = retrieveData();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for (CartBean cart : al) {
            Object row[] = {cart.getId(), cart.getName(), cart.getPrice(), cart.getAmount()};
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Add_Button = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        menu = new javax.swing.JButton();
        Done_Button = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        remove = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textfield_amount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textfield_id = new javax.swing.JTextField();
        textfield_name = new javax.swing.JTextField();
        textfield_price = new javax.swing.JTextField();
        textfield_Tprice = new javax.swing.JTextField();
        custID = new javax.swing.JLabel();

        jTable2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Set Menu", "100", "20"},
                {"French Fries", "20", "30"}
            },
            new String [] {
                "Name", "Price", "Amount"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTextField1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel3.setText("Amount");

        Add_Button.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        Add_Button.setText("Add To Cart");
        Add_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_ButtonMouseClicked(evt);
            }
        });
        Add_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ButtonActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cart");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 100, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Press done when you've finished ordering ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 670, 59));

        menu.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        menu.setText("Go to Menu");
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
        });
        jPanel1.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 740, 397, -1));

        Done_Button.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        Done_Button.setText("Done");
        Done_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Done_ButtonMouseClicked(evt);
            }
        });
        Done_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Done_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(Done_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 810, 397, -1));

        jTable1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Total Price (BDT)", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 883, 553));

        remove.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        remove.setText("Remove from Cart");
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMouseClicked(evt);
            }
        });
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel1.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 230, 397, 54));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Amount");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, -1, -1));

        textfield_amount.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        textfield_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfield_amountActionPerformed(evt);
            }
        });
        jPanel1.add(textfield_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 230, 258, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/new bg.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        textfield_id.setBackground(new java.awt.Color(204, 255, 204));
        textfield_id.setBorder(null);
        jPanel1.add(textfield_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(1045, 352, 221, 175));

        textfield_name.setText("jTextField2");
        jPanel1.add(textfield_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 360, -1, -1));

        textfield_price.setText("jTextField2");
        jPanel1.add(textfield_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 420, -1, -1));

        textfield_Tprice.setText("jTextField2");
        jPanel1.add(textfield_Tprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 350, -1, -1));

        custID.setText("custID");
        jPanel1.add(custID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 370, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked
        // TODO add your handling code here:
        CustomerInterface ci = new CustomerInterface();
        ci.setVisible(true);
    }//GEN-LAST:event_menuMouseClicked

    private void Done_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Done_ButtonMouseClicked
        //generate bill
        dispose();

    }//GEN-LAST:event_Done_ButtonMouseClicked

    private void removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_removeMouseClicked

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        if (textfield_amount != null) {
            String qry;
            PreparedStatement ps;
            Connection conn = OracleConnection();
            int price = Integer.parseInt(textfield_price.getText());
            int amount = Integer.parseInt(textfield_amount.getText());
            int tprice = Integer.parseInt(textfield_Tprice.getText());
            tprice = tprice - (price * amount);
            String pri = Integer.toString(tprice);
            textfield_price.setText(pri);
            try {
                qry = "update cart set Amount=Amount-?, Price=? where id=?";
                ps = conn.prepareStatement(qry);

                ps.setInt(1, Integer.parseInt(textfield_amount.getText()));
                ps.setInt(2, Integer.parseInt(textfield_price.getText()));
                //ps.setString(3, textfield_id.getText());
                ps.setInt(3, Integer.parseInt(textfield_id.getText()));

                int res = ps.executeUpdate();
                //fillTable();
                if (res >= 1) {
                    //JOptionPane.showMessageDialog(null, "Items"+ " have been added.....");
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Item deletion Failed ....");
                }

            } catch (HeadlessException | NumberFormatException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            //textfield_id1.setText("");
            //textfield_id.setText("");
            //textfield_amount.setText("");
        } else {

            JOptionPane.showMessageDialog(null, "All fields are mandatory.......");
        }

        if (textfield_amount != null) {
            String qry;
            PreparedStatement ps;
            Connection conn = OracleConnection();
            try {
                qry = "update menu set Amount=Amount+? where id=?";
                ps = conn.prepareStatement(qry);

                ps.setInt(1, Integer.parseInt(textfield_amount.getText()));
                ps.setInt(2, Integer.parseInt(textfield_id.getText()));
                //ps.setString(3, textfield_name.getText());

                int res = ps.executeUpdate();
                //fillTable();
                if (res >= 1) {
                    //JOptionPane.showMessageDialog(null, "Items"+ " have been added.....");
                } else {

                    JOptionPane.showMessageDialog(null, "Item deletion Failed ....");
                }

            } catch (HeadlessException | NumberFormatException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            //textfield_id1.setText("");
            textfield_id.setText("");
            textfield_amount.setText("");
            fillTable();
        } else {

            JOptionPane.showMessageDialog(null, "All fields are mandatory.......");
        }


    }//GEN-LAST:event_removeActionPerformed

    private void Add_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_ButtonMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_Add_ButtonMouseClicked

    private void Add_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_ButtonActionPerformed
        //

    }//GEN-LAST:event_Add_ButtonActionPerformed

    private void Done_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Done_ButtonActionPerformed
        try {
            Connection conn = OracleConnection();
            String qry1 = "Select SUM(price) from cart";
            PreparedStatement ps1 = conn.prepareStatement(qry1);
            ResultSet result = ps1.executeQuery();
            result.next();
            String amount = result.getString(1);

            if (amount != null) {
                JOptionPane.showMessageDialog(null, "Please pay " + amount + " BDT.");
            } else {
                JOptionPane.showMessageDialog(null, "Please pay 0 BDT.");
            }

            String qry = "delete from cart";
            PreparedStatement ps = conn.prepareStatement(qry);
            int res = ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        dispose();
    }//GEN-LAST:event_Done_ButtonActionPerformed

    public void showItemToFields(int index) {
        textfield_id.setText(Integer.toString(retrieveData().get(index).getId()));
        textfield_Tprice.setText(Integer.toString(retrieveData().get(index).getPrice()));
        //textfield_name.setText(retrieveData().get(index).getName());
        int price = retrieveData().get(index).getPrice();
        int amount = retrieveData().get(index).getAmount();
        price = price / amount;
        String pri = Integer.toString(price);
        textfield_price.setText(pri);            
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int ind = jTable1.getSelectedRow();
        showItemToFields(ind);

    }//GEN-LAST:event_jTable1MouseClicked

    private void textfield_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfield_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfield_amountActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Customer_Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        currentCustID = args[0];
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_Cart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_Button;
    private javax.swing.JButton Done_Button;
    private javax.swing.JLabel custID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton menu;
    private javax.swing.JButton remove;
    private javax.swing.JTextField textfield_Tprice;
    private javax.swing.JTextField textfield_amount;
    private javax.swing.JTextField textfield_id;
    private javax.swing.JTextField textfield_name;
    private javax.swing.JTextField textfield_price;
    // End of variables declaration//GEN-END:variables
}
