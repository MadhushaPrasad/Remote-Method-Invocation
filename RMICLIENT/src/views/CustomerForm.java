package views;

import connector.ProxyHandler;
import controller.CustomerController;
import dto.CustomerDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import observer.Observer;
import service.SuperService;
import service.custom.CustomerService;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sanu-vithanage
 */
public class CustomerForm extends javax.swing.JFrame implements Observer {

    DefaultTableModel dtm;

    /**
     * Creates new form CustomerForm
     */
    public CustomerForm() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            CustomerService proxy = (CustomerService) ProxyHandler.getInstance().getProxy(ProxyHandler.ProxyTypes.CUSTOMER);
            proxy.register(this);
            initComponents();
            dtm = (DefaultTableModel) tblCustomer.getModel();
            loadAllCustomer();
        } catch (RemoteException ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        txtCustomerID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCustomerAddress = new javax.swing.JTextField();
        txtCustomerSalary = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnRegister = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelte = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        btnReload1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(254, 253, 253));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 290, 40));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Customer ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("Customer Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txtCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 290, 40));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Customer Address");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        txtCustomerAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerAddressActionPerformed(evt);
            }
        });
        jPanel1.add(txtCustomerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 290, 40));

        txtCustomerSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerSalaryActionPerformed(evt);
            }
        });
        jPanel1.add(txtCustomerSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 290, 40));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Customer Salary");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 330, 290));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(61, 128, 206));
        jLabel5.setText("Customer Manage");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Address", "Salary"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomer);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 190));

        jButton1.setBackground(new java.awt.Color(251, 16, 3));
        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setText("-");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 440, 220));

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 40));

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegister.setBackground(new java.awt.Color(86, 157, 51));
        btnRegister.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(254, 254, 254));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel4.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, -1));

        btnUpdate.setBackground(new java.awt.Color(57, 109, 217));
        btnUpdate.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 245, 245));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel4.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, -1));

        btnDelte.setBackground(new java.awt.Color(230, 24, 64));
        btnDelte.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btnDelte.setForeground(new java.awt.Color(254, 254, 254));
        btnDelte.setText("Delete");
        btnDelte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelteActionPerformed(evt);
            }
        });
        jPanel4.add(btnDelte, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, -1));

        btnReload.setBackground(new java.awt.Color(214, 125, 39));
        btnReload.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btnReload.setForeground(new java.awt.Color(254, 254, 254));
        btnReload.setText("Reload");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });
        jPanel4.add(btnReload, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 80, -1));

        btnReload1.setBackground(new java.awt.Color(214, 125, 39));
        btnReload1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btnReload1.setForeground(new java.awt.Color(254, 254, 254));
        btnReload1.setText("Print");
        btnReload1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReload1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnReload1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 80, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 100, 290));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerIDActionPerformed
        try {
            String customerID = txtCustomerID.getText();
            CustomerDTO searchCustomer = new CustomerController().searchCustomer(customerID);
            clearAll();
            txtCustomerName.setText(searchCustomer.getName());
            txtCustomerAddress.setText(searchCustomer.getAddress());
            txtCustomerID.setText(searchCustomer.getId());
            txtCustomerSalary.setText(searchCustomer.getSalary() + "");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }


    }//GEN-LAST:event_txtCustomerIDActionPerformed

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameActionPerformed
        txtCustomerAddress.requestFocus();
    }//GEN-LAST:event_txtCustomerNameActionPerformed

    private void txtCustomerAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerAddressActionPerformed
        txtCustomerSalary.requestFocus();
    }//GEN-LAST:event_txtCustomerAddressActionPerformed

    private void txtCustomerSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerSalaryActionPerformed
        btnRegister.requestFocus();
    }//GEN-LAST:event_txtCustomerSalaryActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        try {
            String customerID = txtCustomerID.getText();
//        Pattern compile = Pattern.compile("(C00)[-]{1}[0-9]{3,}");
//        Matcher matcher = compile.matcher(customerID);
//        boolean matches = matcher.matches();
            if (Pattern.compile("(C00)[-]{1}[0-9]{3,}").matcher(customerID).matches()) {
                String customerName = txtCustomerName.getText();
                if (Pattern.compile("[A-z]{4,}").matcher(customerName).matches()) {
                    String customerAddress = txtCustomerAddress.getText();
                    if (Pattern.compile("[A-z]{5,10}").matcher(customerAddress).matches()) {
                        double customerSalary = Double.parseDouble(txtCustomerSalary.getText());
                        if (Pattern.compile("[0-9]{1,13}([.0-9]*)?").matcher(Double.toString(customerSalary)).matches()) {
                            CustomerDTO customer = new CustomerDTO();
                            customer.setId(customerID);
                            customer.setName(customerName);
                            customer.setAddress(customerAddress);
                            customer.setSalary(customerSalary);
                            boolean addCustomer = new CustomerController().addCustomer(customer);
                            if (addCustomer) {
                                loadAllCustomer();
                                clearAll();
                                JOptionPane.showMessageDialog(rootPane, "Done", "Done", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Not Done", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            txtCustomerSalary.requestFocus();
                            JOptionPane.showMessageDialog(this, "Input Salary format is Invalid", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        txtCustomerAddress.requestFocus();
                        JOptionPane.showMessageDialog(this, "Input Address format is Invalid", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    txtCustomerName.requestFocus();
                    JOptionPane.showMessageDialog(this, "Input Name format is Invalid", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                txtCustomerID.requestFocus();
                JOptionPane.showMessageDialog(this, "Input ID format is Invalid", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You Cannot Input :" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked
        int selectedRow = tblCustomer.getSelectedRow();

        String customerID = dtm.getValueAt(selectedRow, 0).toString();
        String customerName = dtm.getValueAt(selectedRow, 1).toString();
        String customerAddress = dtm.getValueAt(selectedRow, 2).toString();
        String customerSalary = dtm.getValueAt(selectedRow, 3).toString();

        txtCustomerID.setText(customerID);
        txtCustomerName.setText(customerName);
        txtCustomerAddress.setText(customerAddress);
        txtCustomerSalary.setText(customerSalary);


    }//GEN-LAST:event_tblCustomerMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int selectedRow = tblCustomer.getSelectedRow();
            String customerID = dtm.getValueAt(selectedRow, 0).toString();
            new CustomerController().deleteCustomer(customerID);
            dtm.removeRow(selectedRow);
            clearAll();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "You Cannot Delete Row Without Adding", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            String customerID = txtCustomerID.getText();
            String customerName = txtCustomerName.getText();
            String customerAaddress = txtCustomerAddress.getText();
            double salary = Double.parseDouble(txtCustomerSalary.getText());

            CustomerDTO tempCustomer = new CustomerDTO(customerID, customerName, customerAaddress, salary);

            boolean updateCustomer = new CustomerController().updateCustomer(tempCustomer);
            if (updateCustomer) {
                JOptionPane.showMessageDialog(this, "Customer Updated...!");
                loadAllCustomer();
                clearAll();
            } else {
                JOptionPane.showMessageDialog(this, "Customer Not Updated...!", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Exeption", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Exeption", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDelteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelteActionPerformed
        try {
            String customerID = txtCustomerID.getText();
            boolean deleteCustomer = new CustomerController().deleteCustomer(customerID);
            if (deleteCustomer) {
                clearAll();
                JOptionPane.showMessageDialog(this, "Customer Deleted...!");
            } else {
                JOptionPane.showMessageDialog(this, "Customer Not Deleted...!",
                        "Warning", JOptionPane.WARNING_MESSAGE);
            }
            loadAllCustomer();

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Exeption", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Exeption", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDelteActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        clearAll();
        loadAllCustomer();
    }//GEN-LAST:event_btnReloadActionPerformed

    private void btnReload1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReload1ActionPerformed


    }//GEN-LAST:event_btnReload1ActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelte;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnReload1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTextField txtCustomerAddress;
    private javax.swing.JTextField txtCustomerID;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtCustomerSalary;
    // End of variables declaration//GEN-END:variables

    private void loadAllCustomer() {
        try {
            ArrayList<CustomerDTO> allCustomers = new CustomerController().getAllCustomers();
            dtm.setRowCount(0);
            for (CustomerDTO c : allCustomers) {
                Object[] rowData = {c.getId(), c.getName(), c.getAddress(), c.getSalary()};
                dtm.addRow(rowData);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearAll() {
        txtCustomerID.setText("");
        txtCustomerName.setText("");
        txtCustomerAddress.setText("");
        txtCustomerSalary.setText("");
        txtCustomerID.requestFocus();
    }

    @Override
    public void update(String message) throws Exception {
        JOptionPane.showMessageDialog(rootPane, message);
    }
}
