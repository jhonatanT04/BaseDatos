/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista.Cliente;

import Controlador.ControladorCliente;
import Controlador.ControladorPersona;
import Modelo.Personas.Persona.Cliente;
import Modelo.Personas.Persona.Persona;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ListarCliente extends javax.swing.JInternalFrame {
    private IngresaCedulaCliente ingresarCedula;
    private IngresaNombreCliente ingresarNombre;
    private javax.swing.JDesktopPane desktopPane;
    private ControladorCliente controladorCliente;
    private ControladorPersona controladorPersona;
    
    /**
     * Creates new form ListarCliente
     */
    public ListarCliente(javax.swing.JDesktopPane p) {
        initComponents();
        buttonGroupSeleccion.add(jboxNombre);
        buttonGroupSeleccion.add(jboxTodo);
        buttonGroupSeleccion.add(Cedula);
        desktopPane = p;
        controladorPersona=new ControladorPersona();
        controladorCliente=new ControladorCliente();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSeleccion = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jboxNombre = new javax.swing.JRadioButton();
        Cedula = new javax.swing.JRadioButton();
        jboxTodo = new javax.swing.JRadioButton();
        jBntSeleccion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbntSalir = new javax.swing.JButton();

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Direccion", "Telefono", "Correo"
            }
        ));
        jScrollPane1.setViewportView(jTableClientes);

        jboxNombre.setText("Nombre");
        jboxNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jboxNombreActionPerformed(evt);
            }
        });

        Cedula.setText("Cedula");

        jboxTodo.setText("Listar todo");

        jBntSeleccion.setText("Seleccionar");
        jBntSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBntSeleccionActionPerformed(evt);
            }
        });

        jLabel1.setText("Listar por :");

        jbntSalir.setText("Salir");
        jbntSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbntSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jboxNombre)
                                    .addGap(129, 129, 129)
                                    .addComponent(Cedula)
                                    .addGap(121, 121, 121)
                                    .addComponent(jboxTodo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                                    .addComponent(jBntSeleccion))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                    .addComponent(jLabel1)
                                    .addGap(693, 693, 693)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(183, 183, 183))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbntSalir)
                        .addGap(103, 103, 103))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jboxNombre)
                    .addComponent(Cedula)
                    .addComponent(jboxTodo)
                    .addComponent(jBntSeleccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbntSalir)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 903, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jboxNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jboxNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jboxNombreActionPerformed

    private void jBntSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBntSeleccionActionPerformed
        // TODO add your handling code here:
        if(Cedula.isSelected()||jboxNombre.isSelected()||jboxTodo.isSelected()){
            if (Cedula.isSelected()) {
                this.limpiarTabla();
                desplegarCedula();
                
                //wSystem.out.println(ingresarCedula.getVentanaCedula().getCedula());
            }else if(jboxNombre.isSelected()){
                this.limpiarTabla();
                desplegarNombre();
                
            }else if(jboxTodo.isSelected()){
                this.limpiarTabla();
                try {
                    this.desplegarTodo();
                } catch (SQLException ex) {
                    Logger.getLogger(ListarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }else{
            JOptionPane.showInternalMessageDialog(rootPane, "Escoja una opcion.");
        }
    }//GEN-LAST:event_jBntSeleccionActionPerformed

    private void jbntSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbntSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.limpiarTabla();
    }//GEN-LAST:event_jbntSalirActionPerformed
    public void limpiarTabla() {
        DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
        model.setRowCount(0);
    }
    private void desplegarCedula(){
        
        if(ingresarCedula == null){
            ingresarCedula = new IngresaCedulaCliente(jTableClientes);
            desktopPane.add(ingresarCedula);
        }
        ingresarCedula.setVentanaCedula();
        ingresarCedula.setVisible(true); 
    }
    private void desplegarNombre(){
        
        if(ingresarNombre == null){
            ingresarNombre = new IngresaNombreCliente(jTableClientes);
            desktopPane.add(ingresarNombre);
        }
        
        ingresarNombre.setVisible(true); 
    }
   private void desplegarTodo() throws SQLException{
       List<Persona> listaP = controladorPersona.listarPersonasClientes();
       if (listaP!=null) {
           List<Cliente> listaC = controladorCliente.buscarPorNombreCliente(listaP);
           if (listaC!=null) {
               this.llenarTabla(listaC);
           }else{
                JOptionPane.showInternalMessageDialog(rootPane, "No existe ningun cliente en la base de datos.");
           }
       }else{
           JOptionPane.showInternalMessageDialog(rootPane, "No existe ninguna persona en la base de datos.");
       }
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
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Cedula;
    private javax.swing.ButtonGroup buttonGroupSeleccion;
    private javax.swing.JButton jBntSeleccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JButton jbntSalir;
    private javax.swing.JRadioButton jboxNombre;
    private javax.swing.JRadioButton jboxTodo;
    // End of variables declaration//GEN-END:variables
}
