package gui;

import code.Main;
import code.ManagerBill;
import code.ManagerCostumer;
import code.ManagerGeneralValidations;
import code.ManagerProduct;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class InformationOptions extends javax.swing.JFrame {

    private static final int COMPETITORS = 0;
    private static final int COSTUMERS_SPENDED_MORE_THAN = 1;
    private static final int TOTAL_INCOMES = 2;
    private static final int PRODUCTS_CHEAPER_THAN = 3;
    private static final int BILLS_BY_COSTUMERS = 4;
    private static final int DEFAULT = COMPETITORS;

    public InformationOptions() {
        initComponents();
        this.setResizable(false);
        options.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Clientes seleccionados para participar por premios", "Clientes cuyo valor total en compras sea mayor a...", "Dinero total producido por ventas", "Productos con precio menor a...", "Facturas por clientes"}));
        getDataForTable(DEFAULT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        options = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        options.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        options.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                optionsItemStateChanged(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Digite una opcion para visualizar:");

        btnBack.setText("Volver");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnRefresh.setText("Actualizar Tabla");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(options, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBack, btnRefresh});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnRefresh))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBack, btnRefresh});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        OfficesOptions oo = new OfficesOptions();
        oo.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        getDataForTable(options.getSelectedIndex());
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void optionsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_optionsItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            getDataForTable(options.getSelectedIndex());
        }
    }//GEN-LAST:event_optionsItemStateChanged

    private void getDataForTable(int newOp) {
        ArrayList<HashMap<String, String>> data;
        String s;
        data = new ArrayList();
        switch (newOp) {
            case COMPETITORS:
                data = ManagerCostumer.getCompetitors();
                break;
            case COSTUMERS_SPENDED_MORE_THAN:
                s = ManagerGeneralValidations.askNumber("Digite un valor:");
                if (s != null) {
                    data = ManagerCostumer.getCostumersSpendMoreThan(Integer.parseInt(s));
                }
                break;
            case TOTAL_INCOMES:
                data = ManagerCostumer.getTotalSales();
                break;
            case PRODUCTS_CHEAPER_THAN:
                s = ManagerGeneralValidations.askNumber("Digite un valor:");
                if (s != null) {
                    data = ManagerProduct.getProductsCheaperThan(Integer.parseInt(s));
                }
                break;
            case BILLS_BY_COSTUMERS:
                s = ManagerGeneralValidations.askNumber("Digite la cedula del cliente del cual desea ver las facturas:");
                if (s != null) {
                    data = ManagerBill.getBillsByCostumer(Long.parseLong(s));
                }
                break;
        }
        Main.refreshTable(table, data);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox options;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
