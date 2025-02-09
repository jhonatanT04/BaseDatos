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
public class IngresaCedulaCliente extends javax.swing.JInternalFrame {
    private ControladorCliente controladorCliente;
    private ControladorPersona controladorPersona;
    private Cliente cliente;
    private JTable jTableClientes;
    /**
     * Creates new form IngresaCedulaCliente
     */
    public IngresaCedulaCliente(JTable jTableClientes) {
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
        txtCedula = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Cedula del Empleado:");

        jBntBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        jBntBuscar.setText("Buscar");
        jBntBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBntBuscarActionPerformed(evt);
            }
        });

        jBntCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        jBntCancelar.setText("Cancelar");
        jBntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBntCancelarActionPerformed(evt);
            }
        });

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
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
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBntBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBntCancelar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBntBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        
        if (txtCedula.getText().trim().isEmpty()==false) {
            if(txtCedula.getText().trim().length()>10||txtCedula.getText().trim().length()<10){
                JOptionPane.showInternalMessageDialog(rootPane, "El campo cedula lleva 10 digitos");
            }else{
                try {
                    Persona per =controladorPersona.buscarPersonaCliente(txtCedula.getText().trim());
                    if (per!=null) {
                        Cliente cli = controladorCliente.buscarCliente(per);
                        System.out.println(cli+" sdadasdasadasssssss");
                        char visu = cli.getVisualizacion();
                        if (cli!=null) {
                            if (visu=='A') {
                                
                                cliente = cli;
                                addClienteToTable(cliente);
                                this.setVisible(false);
                                this.txtCedula.setText("");
                                
                            }else{
                                JOptionPane.showInternalMessageDialog(rootPane, "El cliente esta desactivado.");
                            }
                        }else{
                            
                            JOptionPane.showInternalMessageDialog(rootPane, "El cliente no existe en la base de datos.");
                            
                        }
                    }else{
                        JOptionPane.showInternalMessageDialog(rootPane, "La persona no existe en la base de datos");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(BuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            JOptionPane.showInternalMessageDialog(rootPane, "Se debe llenar el campo cedula");
        }
    }//GEN-LAST:event_jBntBuscarActionPerformed
    
    public void addClienteToTable(Cliente cliente) {
        DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
        model.addRow(new Object[]{cliente.getCedula(), cliente.getNombre(), cliente.getApellido(), cliente.getDireccion(), cliente.getTelefono(), cliente.getCorreo()});
    }
    
    private void jBntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBntCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.txtCedula.setText("");
    }//GEN-LAST:event_jBntCancelarActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed
    
    public Cliente getVentanaCedula(){
        return cliente;
    }
    
    public void setVentanaCedula(){
        cliente = null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBntBuscar;
    private javax.swing.JButton jBntCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCedula;
    // End of variables declaration//GEN-END:variables
}
