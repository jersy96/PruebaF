package gui;

import code.Costumer;
import code.ManagerProduct;
import code.Product;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuyTemplate extends javax.swing.JFrame {

    DefaultTableModel modelAP = new DefaultTableModel();
    DefaultTableModel modelC = new DefaultTableModel();
    Costumer costumer;

    public BuyTemplate(Costumer c) {
        initComponents();
        costumer = c;
        modelAP.addColumn("Nombre");
        modelAP.addColumn("Codigo");
        modelAP.addColumn("Precio");
        availableProducts.setModel(modelAP);
        for (Product p : ManagerProduct.getProductsArray()) {
            modelAP.addRow(new String[]{p.getName(), p.getCode().toString(), "" + p.getPrice()});
        }
        modelC.addColumn("Nombre");
        modelC.addColumn("Codigo");
        modelC.addColumn("Precio");
        cart.setModel(modelC);
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cart = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        availableProducts = new javax.swing.JTable();
        btnAddToCart = new javax.swing.JButton();
        btnRemoveFromCart = new javax.swing.JButton();
        btnBuy = new javax.swing.JButton();
        btnCancelBuy = new javax.swing.JButton();

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
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "nombre", "Title 2", "Title 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane2, jScrollPane3});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddToCart, btnBuy, btnCancelBuy, btnRemoveFromCart});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        int aux = availableProducts.getSelectedRow();
        System.out.println(aux);
        if (aux < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto disponible para agregarlo al carrito", "", JOptionPane.ERROR_MESSAGE);
        } else {
            String name = (String) availableProducts.getValueAt(aux, 0);
            String code = (String) availableProducts.getValueAt(aux, 1);
            String price = (String) availableProducts.getValueAt(aux, 2);
            modelC.addRow(new String[]{name, code, price});
        }
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btnRemoveFromCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFromCartActionPerformed
        int aux = cart.getSelectedRow();
        if (aux < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto del carrito para poder eliminarlo", "", JOptionPane.ERROR_MESSAGE);
        } else {
            modelC.removeRow(aux);
        }
    }//GEN-LAST:event_btnRemoveFromCartActionPerformed

    private void btnCancelBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelBuyActionPerformed
        MainMenu mm = new MainMenu();
        mm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelBuyActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        ArrayList<String> codes = new ArrayList();
        int tam = cart.getRowCount();
        for (int i = 0; i < tam; i++) {
            codes.add((String) modelC.getValueAt(1, i));
        }
        ArrayList<Product> products;
        products = ManagerProduct.getListOfProductCopy(codes);
        costumer.buy(products);
        JOptionPane.showMessageDialog(null, "Compra exitosa", "", JOptionPane.INFORMATION_MESSAGE);
        MainMenu mm = new MainMenu();
        mm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBuyActionPerformed

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
    // End of variables declaration//GEN-END:variables
}
