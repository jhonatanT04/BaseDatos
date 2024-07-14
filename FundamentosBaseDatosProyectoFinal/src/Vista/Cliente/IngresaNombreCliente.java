package Vista.Cliente;

import Controlador.ControladorCliente;
import Controlador.ControladorPersona;
import Modelo.Personas.Persona.Cliente;
import Modelo.Personas.Persona.Persona;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
//package ec.edu.ups.Vista.Cliente;

/**
 *
 * @author venot
 */
public class IngresaNombreCliente extends javax.swing.JInternalFrame {
    private ControladorCliente controladorCliente;
    private ControladorPersona controladorPersona;
    private Cliente cliente;
    private JTable jTableClientes;
    /**
     * Creates new form IngresaCedulaCliente
     */
    public IngresaNombreCliente(JTable jTableClientes) {
        initComponents();
        controladorCliente = new ControladorCliente();
        controladorPersona = new ControladorPersona();
        this.jTableClientes = jTableClientes;
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
        jBntBuscar = new javax.swing.JButton();
        jBntCancelar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();

        jLabel1.setText("Ingrese el nombre :");

        jBntBuscar.setText("Buscar");
        jBntBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBntBuscarActionPerformed(evt);
            }
        });

        jBntCancelar.setText("Cancelar");
        jBntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBntCancelarActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(391, Short.MAX_VALUE)
                .addComponent(jBntBuscar)
                .addGap(23, 23, 23)
                .addComponent(jBntCancelar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBntBuscar)
                    .addComponent(jBntCancelar))
                .addGap(15, 15, 15))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBntBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBntBuscarActionPerformed
        // TODO add your handling code here:
        
        if (txtNombre.getText().trim().isEmpty()==false) {
            try {
                List<Persona> listP = controladorPersona.listarPersonasClientesNombre(txtNombre.getText().trim());
                if (listP!=null) {
                    List<Cliente> listC = controladorCliente.buscarPorNombreCliente(listP);
                    if (listC!=null) {
                        llenarTabla(listC);
                        this.setVisible(false);
                        this.txtNombre.setText("");
                    }else{
                        JOptionPane.showInternalMessageDialog(rootPane, "No existe ningun cliente con este nombre");
                    }
                    
                }else{
                    JOptionPane.showInternalMessageDialog(rootPane, "No existe ningun personas con este nombre");
                }
            } catch (SQLException ex) {
                Logger.getLogger(BuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            JOptionPane.showInternalMessageDialog(rootPane, "Se debe llenar el campo nombre");
        }
    }//GEN-LAST:event_jBntBuscarActionPerformed
    
    public void addClienteToTable(Cliente cliente) {
        DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
        model.addRow(new Object[]{cliente.getCedula(), cliente.getNombre(), cliente.getApellido(), cliente.getDireccion(), cliente.getTelefono(), cliente.getCorreo()});
    }
    
    private void jBntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBntCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.txtNombre.setText("");
    }//GEN-LAST:event_jBntCancelarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed
    
    public Cliente getVentanaCedula(){
        return cliente;
    }
    
    public void llenarTabla(List<Cliente> clientes){
        String[] columnNames = {"Cedula", "Nombre", "Apellido", "Direccion", "Telefono", "Correo"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        jTableClientes.setModel(tableModel);
        for (Cliente cliente : clientes) {
            if (cliente.getVisualizacion()=='a') {
                Object[] rowData = {
                    cliente.getCedula(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getDireccion(),
                    cliente.getTelefono(),
                    cliente.getCorreo()
                };
                tableModel.addRow(rowData);
            }
            
        }
    }
    
    public void setVentanaCedula(){
        cliente = null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBntBuscar;
    private javax.swing.JButton jBntCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
