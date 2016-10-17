package gui;

import code.Main;
import code.ManagerBill;
import code.ManagerCostumer;
import code.ManagerGeneralValidations;
import code.ManagerProduct;
import code.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuyTemplate extends javax.swing.JFrame {

    private final boolean onStore;
    private final Long costumerId;
    private final String labelTotalValueMsg;
    private final String labelWelcomeMsg;
    private DefaultTableModel modelC;
    private boolean editing;
    private int billIndex;
    private int totalValue;
    public static final int ON_STORE = 0;
    public static final int ON_OFFICE = 1;
    public static final int ON_OFFICE_AND_EDITING = 2;
    
    public BuyTemplate(Long id, boolean onStore) {
        initComponents();
        this.modelC = new DefaultTableModel();
        this.onStore = onStore;
        this.editing = false;
        this.totalValue = 0;
        this.costumerId = id;
        this.labelTotalValueMsg = "Total: ";
        labelTotalValue.setText(labelTotalValueMsg + totalValue);
        this.labelWelcomeMsg = "Bienvenido ";
        String s = "";
        if(onStore){
            HashMap<String, String> data = ManagerCostumer.getCostumerDataInHashMap(id);
            s = labelWelcomeMsg + data.get("name");
        }
        labelWelcome.setText(s);
        initTables();
    }

    public BuyTemplate(Long id, boolean onStore, int billIndex, ArrayList<LinkedHashMap<String, String>> currentProducts, int currentTotalValue){
        this(id, onStore);
        this.billIndex = billIndex;
        this.editing = true;
        this.totalValue = currentTotalValue;
        labelTotalValue.setText(labelTotalValueMsg + totalValue);
        Main.refreshTable(cart, currentProducts);
        modelC = (DefaultTableModel)cart.getModel();
    }
    
    private void initTables(){
        Main.refreshTable(availableProducts, ManagerProduct.getList());
        modelC.addColumn("Nombre");
        modelC.addColumn("Codigo");
        modelC.addColumn("Precio");
        cart.setModel(modelC);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cart = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        availableProducts = new javax.swing.JTable();
        btnAddToCart = new javax.swing.JButton();
        btnRemoveFromCart = new javax.swing.JButton();
        btnBuy = new javax.swing.JButton();
        btnCancelBuy = new javax.swing.JButton();
        labelTotalValue = new javax.swing.JLabel();
        labelWelcome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Productos Disponibles");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Productos En El Carrito");

        cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(cart);

        availableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Codigo", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(availableProducts);

        btnAddToCart.setText("Agregar Al Carrito");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        btnRemoveFromCart.setText("Eliminar Del Carrito");
        btnRemoveFromCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFromCartActionPerformed(evt);
            }
        });

        btnBuy.setText("Terminar Compra");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        btnCancelBuy.setText("Cancelar Compra");
        btnCancelBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelBuyActionPerformed(evt);
            }
        });

        labelTotalValue.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelTotalValue.setText("jLabel3");

        labelWelcome.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelWelcome.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAddToCart, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(btnRemoveFromCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCancelBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTotalValue)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelWelcome)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane2, jScrollPane3});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddToCart, btnBuy, btnCancelBuy, btnRemoveFromCart});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelWelcome)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddToCart)
                                .addGap(31, 31, 31)
                                .addComponent(btnRemoveFromCart)
                                .addGap(41, 41, 41)
                                .addComponent(btnBuy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelBuy))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(labelTotalValue)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        int aux = availableProducts.getSelectedRow();
        if (aux < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto disponible para agregarlo al carrito", "", JOptionPane.ERROR_MESSAGE);
        } else {
            String name = availableProducts.getValueAt(aux, 0).toString();
            String code = availableProducts.getValueAt(aux, 1).toString();
            String price = availableProducts.getValueAt(aux, 2).toString();
            modelC.addRow(new String[]{name, code, price});
            totalValue += Integer.parseInt(price);
            labelTotalValue.setText(labelTotalValueMsg + totalValue);
        }
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btnRemoveFromCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFromCartActionPerformed
        int aux = cart.getSelectedRow();
        if (aux < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto del carrito para poder eliminarlo", "", JOptionPane.ERROR_MESSAGE);
        } else {
            String price = (String) cart.getValueAt(aux, 2);
            totalValue -= Integer.parseInt(price);
            labelTotalValue.setText(labelTotalValueMsg + totalValue);
            modelC.removeRow(aux);
        }
    }//GEN-LAST:event_btnRemoveFromCartActionPerformed

    private void btnCancelBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelBuyActionPerformed
        backAction();
    }//GEN-LAST:event_btnCancelBuyActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        ArrayList<String> codes = new ArrayList();
        int tam = cart.getRowCount();
        for (int i = 0; i < tam; i++) {
            codes.add(modelC.getValueAt(i, 1).toString());
        }
        ArrayList<Product> products;
        products = ManagerProduct.getListOfProductCopy(codes);
        if(ManagerGeneralValidations.validateIfTableIsNotEmpty(cart)){
            String s;
            if(editing){
                ManagerBill.editBill(billIndex, costumerId, products);
                s = "Edicion Exitosa";
            }else{
                ManagerCostumer.letBuy(costumerId, products);
                s = "Compra Exitosa";
            }
            JOptionPane.showMessageDialog(null, s, "", JOptionPane.INFORMATION_MESSAGE);
            backAction();
        }else{
            JOptionPane.showMessageDialog(null, "El carrito debe tener almenos un producto", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuyActionPerformed
    
    private void backAction(){
        if(onStore){
            MainMenu mm = new MainMenu();
            mm.setVisible(true);
            dispose();
        }else{
            BillsOptions bo = new BillsOptions();
            bo.setVisible(true);
            dispose();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable availableProducts;
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnCancelBuy;
    private javax.swing.JButton btnRemoveFromCart;
    private javax.swing.JTable cart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelTotalValue;
    private javax.swing.JLabel labelWelcome;
    // End of variables declaration//GEN-END:variables
}
