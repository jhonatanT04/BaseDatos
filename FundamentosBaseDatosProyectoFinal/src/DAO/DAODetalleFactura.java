/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Factura.DetalleFactura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class DAODetalleFactura {

    public boolean insertarDetalleFactura(DetalleFactura detalleFactura) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();

        String sql = "INSERT INTO super_detalle_facturas (det_codigo, det_cantidad, det_precio_unitario, det_subtotal, det_iva, det_total, super_cabecera_facturas_fac_codigo, super_productos_pro_codigo) VALUES (seq_det_codigo.nextval, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            System.out.println("aaaaa");
            pstmt.setInt(1, detalleFactura.getCantidad());
            pstmt.setDouble(2, detalleFactura.getPrecioUnitario());
            pstmt.setDouble(3, detalleFactura.getSubTotal());
            pstmt.setDouble(4, detalleFactura.getIva());
            pstmt.setDouble(5, detalleFactura.getTotal());
            pstmt.setInt(6, detalleFactura.getCodigoCabeceraFactura());
            pstmt.setInt(7, detalleFactura.getCodigoProducto());

            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            return false;
        } finally {
            conexion.desconectar();
        }
    }



    public List<DetalleFactura> buscarDetalleFactura(int codigo) {
        List<DetalleFactura> detallesFactura = new ArrayList<>();

        // Verificar que el código sea válido
        if (codigo <= 0) {
            System.out.println("El código del detalle de factura no puede ser menor o igual a 0.");
            return detallesFactura; // Retorna la lista vacía si el código no es válido
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Establecer la conexión
            Conexion conexion = new Conexion();
            conn = conexion.conectar();

            // Consulta SQL parametrizada
            String sql = "SELECT * FROM super_detalle_facturas WHERE det_codigo = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, codigo);

            // Ejecutar la consulta
            rs = pstmt.executeQuery();

            // Procesar los resultados
            while (rs.next()) {
                // Obtener los datos del ResultSet para cada detalle de factura encontrado
                int detCodigo = rs.getInt("det_codigo");
                int cantidad = rs.getInt("det_cantidad");
                double precioUnitario = rs.getDouble("det_precio_unitario");
                double subtotal = rs.getDouble("det_subtotal");
                double iva = rs.getDouble("det_iva");
                double total = rs.getDouble("det_total");
                int codigoCabeceraFactura = rs.getInt("super_cabecera_facturas_fac_codigo");
                int codigoProducto = rs.getInt("super_productos_pro_codigo");

                // Crear un objeto DetalleFactura y agregarlo a la lista
                DetalleFactura detalleFactura = new DetalleFactura(detCodigo, cantidad, precioUnitario, subtotal, iva, total, codigoCabeceraFactura, codigoProducto);
                detallesFactura.add(detalleFactura);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
        } finally {
            // Cerrar recursos
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return detallesFactura;
    }

    public boolean actualizarDetalleFactura(DetalleFactura detalleFactura) {
        boolean llave = false;
        try {
            System.out.println("Actualizando detalle de factura: " + detalleFactura);

            String SQLr = "UPDATE super_detalle_facturas SET det_cantidad=?, det_precio_unitario=?, det_subtotal=?, det_iva=?, det_total=?, super_cabecera_facturas_fac_codigo=?, super_productos_pro_codigo=? WHERE det_codigo=?";
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();
            PreparedStatement sentencia = con.prepareStatement(SQLr);

            sentencia.setInt(1, detalleFactura.getCantidad());
            sentencia.setDouble(2, detalleFactura.getPrecioUnitario());
            sentencia.setDouble(3, detalleFactura.getSubTotal());
            sentencia.setDouble(4, detalleFactura.getIva());
            sentencia.setDouble(5, detalleFactura.getTotal());
            sentencia.setInt(6, detalleFactura.getCodigoCabeceraFactura());
            sentencia.setInt(7, detalleFactura.getCodigoProducto());
            sentencia.setInt(8, detalleFactura.getCodigo());

            int filasAfectadas = sentencia.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Se actualizó correctamente el detalle de factura");
                llave = true;
            } else {
                System.out.println("No se pudo actualizar el detalle de factura");
            }

            sentencia.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return llave;
    }

    public boolean eliminarDetalleFactura(int codigo) {
        boolean llave = false;
        try {
            String SQLr = "DELETE FROM super_detalle_facturas WHERE det_codigo=?";
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();
            PreparedStatement sentencia = con.prepareStatement(SQLr);

            sentencia.setInt(1, codigo);

            int filasAfectadas = sentencia.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Se eliminó correctamente el detalle de factura con código " + codigo);
                llave = true;
            } else {
                System.out.println("No se pudo eliminar el detalle de factura con el código " + codigo + " (No existe en la base de datos)");
            }

            sentencia.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return llave;
    }

}
