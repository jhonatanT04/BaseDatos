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
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.JTable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class BuscarFacturaFecha extends javax.swing.JInternalFrame {

    private ControladorCabeceraFactura controladorCabeceraFactura;
    private CabeceraFactura cabeceraFactura;
    private JTable jTable;
    private ListaDeFacturasPorOpcion listaDeFacturasPorOpcion;

    /**
     * Creates new form BuscarFacturaFecha
     */
    public BuscarFacturaFecha(ControladorCabeceraFactura controladorCabeceraFactura, ListaDeFacturasPorOpcion listaDeFacturasPorOpcion, JTable jTable) {
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
        txtNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Ingrese la fecha:");

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
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(btnBuscar)
                        .addGap(37, 37, 37)
                        .addComponent(jButton1)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
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
            String fechaStr = txtNombre.getText().trim();
            if (fechaStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese la fecha a buscar.");
                return;
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parsedDate = dateFormat.parse(fechaStr);
            Timestamp fecha = new Timestamp(parsedDate.getTime());

            DefaultTableModel modelo = (DefaultTableModel) this.jTable.getModel();
            modelo.setRowCount(0);

            controladorCabeceraFactura = new ControladorCabeceraFactura();
            List<CabeceraFactura> cabeceraFacturas = controladorCabeceraFactura.buscarPorFecha(fecha);

            ControladorCliente controladorCliente = new ControladorCliente();
            ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
            if (cabeceraFacturas != null && !cabeceraFacturas.isEmpty()) {
                for (CabeceraFactura cabecera : cabeceraFacturas) {
                    char estadoChar = cabecera.getEstado();
                    String estado = (estadoChar == 'A') ? "Activo" : "Inactivo";
                    String nombreemp = controladorEmpleado.buscarClientePorCodigo(cabecera.getCodigoEmpleado()).getNombre();
                    String nombrecli = controladorCliente.buscarClientePorCodigo(cabecera.getCodigoCliente()).getNombre();
                    Object[] rowData = {
                        cabecera.getCodigo(),
                        cabecera.getFecha(),
                        cabecera.getSubTotal(),
                        cabecera.getTotalIVA(),
                        cabecera.getValorTotal(),
                        estado,
                        nombrecli,
                        nombreemp
                    };
                    modelo.addRow(rowData);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron facturas para la fecha ingresada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "El formato de la fecha es incorrecto. Por favor, ingrese una fecha en el formato 'yyyy-MM-dd HH:mm:ss'.");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        txtNombre.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
