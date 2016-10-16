/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import code.ManagerCostumer;
import javax.swing.JOptionPane;

/**
 *
 * @author jronc
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
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
        jPanel1 = new javax.swing.JPanel();
        BtnStore = new javax.swing.JButton();
        BtnOffices = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Buenos dias, usted se encuentra en un punto de venta o en un punto de gestion?");

        BtnStore.setText("Punto De Venta");
        BtnStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnStoreActionPerformed(evt);
            }
        });

        BtnOffices.setText("Punto De Gestion");
        BtnOffices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOfficesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(BtnStore)
                .addGap(18, 18, 18)
                .addComponent(BtnOffices))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnStore)
                    .addComponent(BtnOffices))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnStoreActionPerformed
        String str = JOptionPane.showInputDialog(null, "Digite su cedula:", "", JOptionPane.PLAIN_MESSAGE);
        if(str != null){
            Long id = Long.parseLong(str);
            if (ManagerCostumer.validateIfIdIsUsed(id)) {
                BuyTemplate bt;
                bt = new BuyTemplate(id);
                bt.setVisible(true);
                dispose();
            } else {
                int op = JOptionPane.showConfirmDialog(null, "Usted no esta registrado en nuestra base de datos, desea registrarse?", "", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (op == 0) {
                    CostumerDataRequest ct = new CostumerDataRequest(CostumerDataRequest.STORE);
                    ct.setVisible(true);
                    dispose();
                }
            }
        }
    }//GEN-LAST:event_BtnStoreActionPerformed

    private void BtnOfficesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOfficesActionPerformed
        OfficesOptions oo = new OfficesOptions();
        oo.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnOfficesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnOffices;
    private javax.swing.JButton BtnStore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
