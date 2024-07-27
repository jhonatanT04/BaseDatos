/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista.Producto;

import Controlador.ControladorCategoria;
import Controlador.ControladorProducto;
import Modelo.Producto.Categoria;
import Modelo.Producto.Producto;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class BuscarProductoNombre extends javax.swing.JInternalFrame {

    private ControladorProducto controladorProducto;
    private ControladorCategoria controladorCategoria;
    private JTable jTable;
    private Producto producto;
    private ListarProducto listarProducto; // Añadir referencia a ListarProducto

    public BuscarProductoNombre(JTable jTable, ListarProducto listarProducto, ControladorCategoria controladorCategoria, ControladorProducto controladorProducto) {
        initComponents();
        this.controladorCategoria = controladorCategoria;
        this.controladorProducto = controladorProducto;
        this.jTable = jTable;
        this.listarProducto = listarProducto; // Inicializar la referencia
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
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Ingrese el nombre del producto:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Extra/imagen/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Extra/imagen/cancelar.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(54, 54, 54)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(btnBuscar)
                        .addGap(42, 42, 42)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(jButton1)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String nombre = txtNombre.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del producto a buscar.");
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) this.jTable.getModel();
        modelo.setRowCount(0);

        try {
            List<Producto> productos = controladorProducto.buscarProductoMismoNombre(nombre);

            if (productos != null && !productos.isEmpty()) {
                for (Producto producto : productos) {
                    Categoria categoria = controladorCategoria.buscarCategoriaPorCodigo(producto.getCategoria());
                    String nombreCategoria = (categoria != null) ? categoria.getNombre() : "Sin categoría";

                    Object[] rowData = {
                        producto.getCodigo(),
                        producto.getNombre(),
                        producto.getPrecio(),
                        producto.getStock(),
                        producto.getIva(),
                        producto.getVisualizacion(),
                        nombreCategoria
                    };
                    modelo.addRow(rowData);
                    this.setVisible(false);
                    this.txtNombre.setText(""); 
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron productos con el nombre ingresado.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscarProductoNombre.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al buscar los productos: " + ex.getMessage());
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false); 
        txtNombre.setText(""); 
    }//GEN-LAST:event_jButton1ActionPerformed

    /*public void addClienteToTable(Producto producto) {
        DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
        model.addRow(new Object[]{cliente.getCedula(), cliente.getNombre(), cliente.getApellido(), cliente.getDireccion(), cliente.getTelefono(), cliente.getCorreo()});
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
