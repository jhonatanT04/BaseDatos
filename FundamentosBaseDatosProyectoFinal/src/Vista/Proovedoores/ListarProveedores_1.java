/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista.Proovedoores;

import Controlador.ControladorPorveedor;
import Modelo.Proveedor.Proveedor;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ListarProveedores_1 extends javax.swing.JInternalFrame {
    private ControladorPorveedor controladorPorveedor;
    private BuscarProveedorNombre buscarProveedorNombre;
    private BuscarProveedorRUC buscarProveedorRUC;
    private javax.swing.JDesktopPane desktopPane;
    /**
     * Creates new form ListarProveedores
     */
    public ListarProveedores_1(ControladorPorveedor controladorPorveedor,javax.swing.JDesktopPane desktopPane) {
        initComponents();
        buttonGroup1.add(radioNombre);
        buttonGroup1.add(radioRUC);
        buttonGroup1.add(radioTodo); 
        this.controladorPorveedor = controladorPorveedor;
        this.desktopPane = desktopPane;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        radioNombre = new javax.swing.JRadioButton();
        radioRUC = new javax.swing.JRadioButton();
        radioTodo = new javax.swing.JRadioButton();
        btnSeleccionar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre del Proveedor", "Telefono", "Direccion", "Correo", "RUC"
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

        radioRUC.setText("RUC");

        radioTodo.setText("Listar Todo");

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 904, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(426, 426, 426)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(radioNombre)
                        .addGap(130, 130, 130)
                        .addComponent(radioRUC)
                        .addGap(92, 92, 92)
                        .addComponent(radioTodo)
                        .addGap(81, 81, 81)
                        .addComponent(btnSeleccionar)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioNombre)
                    .addComponent(radioRUC)
                    .addComponent(radioTodo)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.setVisible(false); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        actualizarTabla();
    }//GEN-LAST:event_formInternalFrameActivated

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        if (radioNombre.isSelected()) {
            desplegarNombre();
        }else if (radioRUC.isSelected()) {
            desplegarRUC();
        }else if (radioTodo.isSelected()) {
            actualizarTabla();
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void desplegarNombre(){
        if (buscarProveedorNombre == null) {
            buscarProveedorNombre = new BuscarProveedorNombre(jTable1, this, controladorPorveedor);
            desktopPane.add(buscarProveedorNombre);
        }
        buscarProveedorNombre.setVisible(true);
    }
    
    private void desplegarRUC(){
        if (buscarProveedorRUC == null) {
            buscarProveedorRUC = new BuscarProveedorRUC(controladorPorveedor, this, jTable1); 
            desktopPane.add(buscarProveedorRUC);
        }
        buscarProveedorRUC.setVisible(true);
    }
    
    private void actualizarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0); 

        List<Proveedor> listaProveedores = controladorPorveedor.listarProveedores();

        for (Proveedor proveedor : listaProveedores) {
            int codigo = proveedor.getCodigo();
            String nombre = proveedor.getNombre();
            String telefono = proveedor.getTelefono();
            String direccion = proveedor.getDireccion();
            String correo = proveedor.getCorreo();
            String ruc = proveedor.getRuc();

            Object[] rowData = {codigo, nombre, telefono, direccion, correo, ruc};
            modelo.addRow(rowData);
        }
        jTable1.setModel(modelo);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioNombre;
    private javax.swing.JRadioButton radioRUC;
    private javax.swing.JRadioButton radioTodo;
    // End of variables declaration//GEN-END:variables
}
