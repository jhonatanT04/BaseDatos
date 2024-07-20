/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista.Producto;

import Controlador.ControladorCategoria;
import Controlador.ControladorProducto;
import Modelo.Producto.Producto;
import java.awt.Desktop;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ListarProducto extends javax.swing.JInternalFrame {

    private BuscarProductoNombre buscarProductoNombre;
    private BuscarProductoCategoria buscarProductoCategoria;
    private ControladorProducto controladorProducto;
    private javax.swing.JDesktopPane desktopPane;
    private ControladorCategoria controladorCategoria;
    private Producto producto;

    /**
     * Creates new form ListarProducto
     */
    public ListarProducto(ControladorProducto controladorProducto, ControladorCategoria controladorCategoria,javax.swing.JDesktopPane desktop) {
        initComponents();
        this.controladorProducto = controladorProducto;
        this.controladorCategoria = controladorCategoria;
        desktopPane = desktop;
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
        radioNombre = new javax.swing.JRadioButton();
        radioCategoria = new javax.swing.JRadioButton();
        btnSeleccionar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Strock", "Iva", "Visualizacion", "Categoria"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Listar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        radioNombre.setText("Nombre");

        radioCategoria.setText("Categoria");

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(jButton1)
                        .addGap(215, 215, 215))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(radioNombre)
                                .addGap(122, 122, 122)
                                .addComponent(radioCategoria)
                                .addGap(82, 82, 82)
                                .addComponent(btnSeleccionar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioNombre)
                    .addComponent(radioCategoria)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        if (radioNombre.isSelected()) {
            desplegarNombre();
        }else if (radioCategoria.isSelected()) {
            desplegarCategoria();
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void desplegarNombre() {
        if (buscarProductoNombre == null) {
            buscarProductoNombre = new BuscarProductoNombre(jTable1, this); 
            desktopPane.add(buscarProductoNombre);
        }
        buscarProductoNombre.setVisible(true); 
    }

    private void desplegarCategoria() {
        if (buscarProductoCategoria == null) {
            buscarProductoCategoria = new BuscarProductoCategoria();
            desktopPane.add(buscarProductoCategoria);
        }
        buscarProductoCategoria.setVisible(true); 
    }
    
    private void actualizarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTable1.getModel();
        modelo.setRowCount(0); // Limpiar filas existentes

        List<Producto> listaProductos = controladorProducto.listarProductos();

        for (Producto producto : listaProductos) {
            int codigo = producto.getCodigo();
            String nombre = producto.getNombre();
            double precio = producto.getPrecio();
            int stock = producto.getStock();
            double iva = producto.getIva();
            char visualizacion = producto.getVisualizacion();
            String categoria = controladorCategoria.buscarCategoriaPorCodigo(producto.getCategoria()).getNombre();

            Object[] rowData = {codigo, nombre, precio, stock, iva, visualizacion, categoria};
            modelo.addRow(rowData);
        }

        this.jTable1.setModel(modelo); // Aplicar el modelo actualizado a la tabla
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioCategoria;
    private javax.swing.JRadioButton radioNombre;
    // End of variables declaration//GEN-END:variables
}
