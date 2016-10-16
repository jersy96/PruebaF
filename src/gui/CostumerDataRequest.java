/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import code.ManagerCostumer;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author jronc
 */
public class CostumerDataRequest extends javax.swing.JFrame {

    /**
     * Creates new form CostumerDataRequest
     */
    private Long idOfCostumerToEdit;
    private final int location;
    public static final int STORE = 0;
    public static final int OFFICES = 1;
    private static final int OFFICES_AND_EDITING = 2;

    public CostumerDataRequest(int op) {
        initComponents();
        location = op;
    }

    public CostumerDataRequest(int op, Long id) {
        initComponents();
        location = OFFICES_AND_EDITING;
        idOfCostumerToEdit = id;
        BtnRegisterEdit.setText("Editar");
        HashMap<String, String> currentDataOfCostumerToEdit = ManagerCostumer.getCostumerDataInHashMap(idOfCostumerToEdit);
        txtFldName.setText(currentDataOfCostumerToEdit.get("name"));
        txtFldName.selectAll();
        txtFldId.setText(currentDataOfCostumerToEdit.get("id"));
        txtFldId.setEditable(false);
        txtFldAddress.setText(currentDataOfCostumerToEdit.get("address"));
        txtFldAddress.selectAll();
        txtFldMail.setText(currentDataOfCostumerToEdit.get("mail"));
        txtFldMail.selectAll();
        txtFldPhone.setText(currentDataOfCostumerToEdit.get("phone"));
        txtFldPhone.selectAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtFldName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFldPhone = new javax.swing.JTextField();
        txtFldMail = new javax.swing.JTextField();
        txtFldAddress = new javax.swing.JTextField();
        txtFldId = new javax.swing.JTextField();
        BtnRegisterEdit = new javax.swing.JButton();
        BtnCancel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cedula:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Direccion:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Correo:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Celular:");

        BtnRegisterEdit.setText("Registrar");
        BtnRegisterEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegisterEditActionPerformed(evt);
            }
        });

        BtnCancel.setText("Cancelar");
        BtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Digite la informacion del cliente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnRegisterEdit)
                                .addGap(18, 18, 18)
                                .addComponent(BtnCancel))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtFldMail, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFldAddress, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFldId, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFldName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnRegisterEdit)
                    .addComponent(BtnCancel))
                .addGap(33, 33, 33))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelActionPerformed
        if (location == STORE) {
            MainMenu mm = new MainMenu();
            mm.setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_BtnCancelActionPerformed

    private void BtnRegisterEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegisterEditActionPerformed
        HashMap<String, String> data = new HashMap();
        data.put("name", txtFldName.getText());
        data.put("id", txtFldId.getText());
        data.put("address", txtFldAddress.getText());
        data.put("mail", txtFldMail.getText());
        data.put("phone", txtFldPhone.getText());
        int ans = location == OFFICES_AND_EDITING ? ManagerCostumer.validateCostumerData(data, true) : ManagerCostumer.validateCostumerData(data, false);
        if (ans == ManagerCostumer.VALIDATION_SUCCESS) {
            if (location == STORE) {
                ManagerCostumer.registerCostumer(data);
                int aux = JOptionPane.showConfirmDialog(null, "Usuario Creado Exitosamente, Desea Continuar Con La Compra?", "", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (aux == 0) {
                    BuyTemplate bt = new BuyTemplate(Long.parseLong(data.get("id")));
                    bt.setVisible(true);
                } else {
                    MainMenu mm = new MainMenu();
                    mm.setVisible(true);
                }
            } else {
                if (location == OFFICES_AND_EDITING) {
                    ManagerCostumer.editCostumer(idOfCostumerToEdit, data);
                } else {
                    ManagerCostumer.registerCostumer(data);
                }
                CostumerOptions.syncTableData();
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, ManagerCostumer.getErrorDescription(ans), "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnRegisterEditActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancel;
    private javax.swing.JButton BtnRegisterEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtFldAddress;
    private javax.swing.JTextField txtFldId;
    private javax.swing.JTextField txtFldMail;
    private javax.swing.JTextField txtFldName;
    private javax.swing.JTextField txtFldPhone;
    // End of variables declaration//GEN-END:variables
}
