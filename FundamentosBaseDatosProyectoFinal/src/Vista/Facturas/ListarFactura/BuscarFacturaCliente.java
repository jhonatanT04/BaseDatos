/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista.Facturas.ListarFactura;

import Controlador.ControladorCabeceraFactura;
import Controlador.ControladorCliente;
import Controlador.ControladorEmpleado;
import Controlador.ControladorPersona;
import Modelo.Factura.CabeceraFactura;
import Modelo.Personas.Persona.Persona;
import Vista.Proovedoores.BuscarProveedorNombre;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class BuscarFacturaCliente extends javax.swing.JInternalFrame {

    private ControladorCabeceraFactura controladorCabeceraFactura;
    private CabeceraFactura cabeceraFactura;
    private JTable jTable;
    private ListaDeFacturasPorOpcion listaDeFacturasPorOpcion;

    /**
     * Creates new form BuscarFacturaCliente
     */
    public BuscarFacturaCliente(ControladorCabeceraFactura controladorCabeceraFactura, ListaDeFacturasPorOpcion listaDeFacturasPorOpcion, JTable jTable) {
        initComponents();
        this.controladorCabeceraFactura = controladorCabeceraFactura;
        this.listaDeFacturasPorOpcion = listaDeFacturasPorOpcion;
        this.jTable = jTable;
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
        txtCedula = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Ingrese la cedula del cliente:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

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
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1)
                        .addGap(77, 77, 77)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(btnBuscar)
                        .addGap(36, 36, 36)
                        .addComponent(jButton1)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(jButton1))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            String cedula = txtCedula.getText().trim();

            if (cedula.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del empleado a buscar.");
                return;
            }

            if (!validarCedula(cedula)) {
                JOptionPane.showMessageDialog(null, "La cédula ingresada no es válida.");
                return;
            }

            DefaultTableModel modelo = (DefaultTableModel) this.jTable.getModel();
            modelo.setRowCount(0);

            ControladorPersona cp = new ControladorPersona();
            ControladorCliente cc = new ControladorCliente();
            Persona persona = cp.buscarPersonaCliente(cedula);

            if (persona == null) {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna persona con el nombre ingresado.");
                return;
            }

            int codigocliente = cc.buscarCliente(persona).getClienteCodigo();
            List<CabeceraFactura> cabeceraFacturas = controladorCabeceraFactura.buscarPorCliente(codigocliente);

            ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
            ControladorCliente controladorCliente = new ControladorCliente();

            String nombrecli = controladorCliente.buscarClientePorCodigo(codigocliente).getNombre();

            if (cabeceraFacturas != null && !cabeceraFacturas.isEmpty()) {
                for (CabeceraFactura cabecera : cabeceraFacturas) {
                    String nomreemp = controladorEmpleado.buscarClientePorCodigo(cabecera.getCodigoEmpleado()).getNombre();
                    char estadoChar = cabecera.getEstado();
                    String estado = (estadoChar == 'A') ? "Activo" : "Inactivo";
                    Object[] rowData = {
                        cabecera.getCodigo(),
                        cabecera.getFecha(),
                        cabecera.getSubTotal(),
                        cabecera.getTotalIVA(),
                        cabecera.getValorTotal(),
                        estado,
                        nombrecli,
                        nomreemp
                    };
                    modelo.addRow(rowData);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron facturas para el empleado con el nombre ingresado.");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(BuscarProveedorNombre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        txtCedula.setText(""); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean validarCedula(String cedula) {
        return cedula != null && cedula.length() == 10;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCedula;
    // End of variables declaration//GEN-END:variables
}
