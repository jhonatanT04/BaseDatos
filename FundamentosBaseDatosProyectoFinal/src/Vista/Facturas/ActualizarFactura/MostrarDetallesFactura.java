/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista.Facturas.ActualizarFactura;

import Controlador.ControladorCabeceraFactura;
import Controlador.ControladorDetalleFactura;
import Controlador.ControladorProducto;
import Modelo.Factura.CabeceraFactura;
import Modelo.Factura.DetalleFactura;
import Modelo.Producto.Producto;
import Vista.Proovedoores.MostrarProductosProveedores;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class MostrarDetallesFactura extends javax.swing.JInternalFrame {

    private DefaultTableModel defaultTableModel;
    private ControladorDetalleFactura controladorDetalleFactura;
    private DetalleFactura detalleFactura;
    private int codigo;

    /**
     * Creates new form MostrarDetallesFactura
     */
    public MostrarDetallesFactura(int Codigo) {
        initComponents();
        this.codigo = Codigo;
        this.controladorDetalleFactura = new ControladorDetalleFactura();
        this.defaultTableModel = new DefaultTableModel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Cantidad", "Precio", "Subtotal", "Iva", "Total", "CodigoCabecera", "CodigoProducto"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jButton1)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false); 
    }//GEN-LAST:event_jButton1ActionPerformed

    public void cargarDetallesProducto(int codigoProducto) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        tableModel.setRowCount(0);
        ControladorCabeceraFactura controladorCabecera = new ControladorCabeceraFactura();
        CabeceraFactura cabeceraFactura = controladorCabecera.buscarCabecera(codigoProducto);
        if (cabeceraFactura != null) {
            controladorDetalleFactura = new ControladorDetalleFactura();
            List<DetalleFactura> detalles = controladorDetalleFactura.buscar(cabeceraFactura.getCodigo());
            
            if (detalles != null && !detalles.isEmpty()) {
                for (DetalleFactura detalle : detalles) {
                    Object[] rowData = {
                        detalle.getCodigo(),
                        detalle.getCantidad(),
                        detalle.getPrecioUnitario(),
                        detalle.getSubTotal(),
                        detalle.getIva(),
                        detalle.getTotal(),
                        detalle.getCodigoCabeceraFactura(),
                        detalle.getCodigoProducto()
                    };
                    tableModel.addRow(rowData);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se encontraron detalles para la cabecera de factura con código " + cabeceraFactura.getCodigo());
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ninguna cabecera de factura para el producto con código " + codigoProducto);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
