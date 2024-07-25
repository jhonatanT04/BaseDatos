/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Factura.CabeceraFactura;
import Modelo.Producto.Producto;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class DAOCabeceraFactura {

    public boolean insertarCabeceraFacturas(CabeceraFactura cabeceraFactura) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();

        String sql = "INSERT INTO super_cabecera_facturas (fac_codigo, fac_fecha, fac_subtotal, fac_total_iva, fac_valor_total, fac_estado, super_clientes_cli_codigo, super_empleados_emp_codigo) VALUES (SEQ_FAC_CODIGO.nextval, ?, ?, ?, ?, ?, ?, ?)";
        System.out.println(sql);
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setTimestamp(1, cabeceraFactura.getFecha());
            pstmt.setDouble(2, cabeceraFactura.getSubTotal());
            pstmt.setDouble(3, cabeceraFactura.getTotalIVA());
            pstmt.setDouble(4, cabeceraFactura.getValorTotal());
            pstmt.setString(5, String.valueOf(cabeceraFactura.getEstado()));
            pstmt.setInt(6, cabeceraFactura.getCodigoEmpleado());
            pstmt.setInt(7, cabeceraFactura.getCodigoCliente());

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

    public void buscarCabeceraFactura(int codigo) {
        if (codigo > 0) {
            Conexion conexion = new Conexion();
            Connection conn = conexion.conectar();
            try {
                
                
                String sql = "SELECT * FROM super_cabecera_facturas WHERE fac_codigo = ?";
                
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, codigo);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    System.out.println("Factura encontrada:");
                    System.out.println("Código: " + rs.getInt("fac_codigo"));
                    System.out.println("Fecha: " + rs.getTimestamp("fac_fecha"));
                    System.out.println("Subtotal: " + rs.getDouble("fac_subtotal"));
                    System.out.println("Total IVA: " + rs.getDouble("fac_total_iva"));
                    System.out.println("Valor Total: " + rs.getDouble("fac_valor_total"));
                    System.out.println("Estado: " + rs.getString("fac_estado"));
                    System.out.println("Código Empleado: " + rs.getInt("super_empleados_emp_codigo"));
                    System.out.println("Código Cliente: " + rs.getInt("super_clientes_cli_codigo"));
                    System.out.println("Código Cliente V1: " + rs.getInt("super_clientesv1_cli_codigo"));
                    System.out.println("Código Empleado V1: " + rs.getInt("super_empleadosv1_emp_codigo"));
                } else {
                    System.out.println("No se encontró ninguna factura con el código " + codigo);
                }

                rs.close();
                pstmt.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(DAOCabeceraFactura.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
                conexion.desconectar();
            }
        } else {
            System.out.println("El código de la factura no puede ser menor o igual a 0.");
        }
    }

    public boolean actualizarCabeceraFactura(CabeceraFactura cabeceraFactura) {
        boolean llave = false;
        try {
            System.out.println("Actualizando factura: " + cabeceraFactura);

            String SQLr = "UPDATE super_cabecera_facturas SET fac_fecha=?, fac_subtotal=?, fac_total_iva=?, fac_valor_total=?, fac_estado=?, super_empleados_emp_codigo=?, super_clientes_cli_codigo=?, super_clientesv1_cli_codigo=?, super_empleadosv1_emp_codigo=? WHERE fac_codigo=?";
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();
            PreparedStatement sentencia = con.prepareStatement(SQLr);

            sentencia.setTimestamp(1, cabeceraFactura.getFecha());
            sentencia.setDouble(2, cabeceraFactura.getSubTotal());
            sentencia.setDouble(3, cabeceraFactura.getTotalIVA());
            sentencia.setDouble(4, cabeceraFactura.getValorTotal());
            sentencia.setString(5, String.valueOf(cabeceraFactura.getEstado()));
            sentencia.setInt(6, cabeceraFactura.getCodigoEmpleado());
            sentencia.setInt(7, cabeceraFactura.getCodigoCliente());
            sentencia.setInt(10, cabeceraFactura.getCodigo());

            int filasAfectadas = sentencia.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Se actualizó correctamente la factura");
                llave = true;
            } else {
                System.out.println("No se pudo actualizar la factura");
            }

            sentencia.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return llave;
    }

    public boolean eliminarCabeceraFactura(int codigo) {
        boolean llave = false;
        try {
            String SQLr = "DELETE FROM super_cabecera_facturas WHERE fac_codigo=?";
            Conexion conexion = new Conexion();
            Connection con = conexion.conectar();
            PreparedStatement sentencia = con.prepareStatement(SQLr);

            sentencia.setInt(1, codigo);

            int filasAfectadas = sentencia.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Se eliminó correctamente la factura con código " + codigo);
                llave = true;
            } else {
                System.out.println("No se pudo eliminar la factura con el código " + codigo + " (No existe en la base de datos)");
            }

            sentencia.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return llave;
    }

    public List<CabeceraFactura> buscarCabeceraFacturaPorEmpleado(int codigoEmpleado) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        List<CabeceraFactura> listaCabeceraFacturas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM super_cabecera_facturas WHERE super_empleados_emp_codigo = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, codigoEmpleado);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Crear un nuevo objeto CabeceraFactura con los datos obtenidos
                int codigo = rs.getInt("fac_codigo");
                Timestamp fecha = rs.getTimestamp("fac_fecha");
                double subtotal = rs.getDouble("fac_subtotal");
                double totalIVA = rs.getDouble("fac_total_iva");
                double valorTotal = rs.getDouble("fac_valor_total");
                char estado = rs.getString("fac_estado").charAt(0);
                int codigoCliente = rs.getInt("super_clientes_cli_codigo");

                CabeceraFactura cabeceraFactura = new CabeceraFactura(codigo, fecha, subtotal, totalIVA, valorTotal, estado, codigoEmpleado, codigoCliente);
                listaCabeceraFacturas.add(cabeceraFactura);
            }

            if (listaCabeceraFacturas.isEmpty()) {
                System.out.println("No se encontró ninguna factura con el código del empleado " + codigoEmpleado);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCabeceraFactura.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.desconectar();
        }

        return listaCabeceraFacturas;
    }

    public List<CabeceraFactura> buscarCabeceraFacturaPorFecha(Timestamp fecha) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        List<CabeceraFactura> listaCabeceraFacturas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM super_cabecera_facturas WHERE DATE(fac_fecha) = DATE(?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setTimestamp(1, fecha);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Crear un nuevo objeto CabeceraFactura con los datos obtenidos
                int codigo = rs.getInt("fac_codigo");
                Timestamp facFecha = rs.getTimestamp("fac_fecha");
                double subtotal = rs.getDouble("fac_subtotal");
                double totalIVA = rs.getDouble("fac_total_iva");
                double valorTotal = rs.getDouble("fac_valor_total");
                char estado = rs.getString("fac_estado").charAt(0);
                int codigoEmpleado = rs.getInt("super_empleados_emp_codigo");
                int codigoCliente = rs.getInt("super_clientes_cli_codigo");

                CabeceraFactura cabeceraFactura = new CabeceraFactura(codigo, facFecha, subtotal, totalIVA, valorTotal, estado, codigoEmpleado, codigoCliente);
                listaCabeceraFacturas.add(cabeceraFactura);
            }

            if (listaCabeceraFacturas.isEmpty()) {
                System.out.println("No se encontró ninguna factura en la fecha " + fecha);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCabeceraFactura.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.desconectar();
        }

        return listaCabeceraFacturas;
    }

    public CabeceraFactura buscarCabeceraFacturaPorCodigo(int codigoCabecera) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        CabeceraFactura cabeceraFactura = null; // Inicializar el objeto CabeceraFactura

        try {
            String sql = "SELECT * FROM super_cabecera_facturas WHERE fac_codigo = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, codigoCabecera);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Crear un nuevo objeto CabeceraFactura con los datos obtenidos
                int codigo = rs.getInt("fac_codigo");
                Timestamp fecha = rs.getTimestamp("fac_fecha");
                double subtotal = rs.getDouble("fac_subtotal");
                double totalIVA = rs.getDouble("fac_total_iva");
                double valorTotal = rs.getDouble("fac_valor_total");
                char estado = rs.getString("fac_estado").charAt(0);
                int codigoEmpleado = rs.getInt("super_empleados_emp_codigo");
                int codigoCliente = rs.getInt("super_clientes_cli_codigo");

                cabeceraFactura = new CabeceraFactura(codigo, fecha, subtotal, totalIVA, valorTotal, estado, codigoEmpleado, codigoCliente);
            } else {
                System.out.println("No se encontró ninguna factura con el código de cabecera " + codigoCabecera);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCabeceraFactura.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.desconectar();
        }

        return cabeceraFactura;
    }

    public boolean buscarEmpleado(int codigoEmpleado) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        try {

            String sql = "SELECT * "
                    + "FROM super_cabecera_facturas "
                    + "where super_empleados_emp_codigo = ?";
            //System.out.println(sql);

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, codigoEmpleado);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Factura encontrada:");
                System.out.println("Código: " + rs.getInt("fac_codigo"));
                System.out.println("Fecha: " + rs.getTimestamp("fac_fecha"));
                System.out.println("Subtotal: " + rs.getDouble("fac_subtotal"));
                System.out.println("Total IVA: " + rs.getDouble("fac_total_iva"));
                System.out.println("Valor Total: " + rs.getDouble("fac_valor_total"));
                System.out.println("Estado: " + rs.getString("fac_estado"));
                System.out.println("Código Empleado: " + rs.getInt("super_empleados_emp_codigo"));
                System.out.println("Código Cliente: " + rs.getInt("super_clientes_cli_codigo"));

                rs.close();
                pstmt.close();
                return true;
            } else {
                System.out.println("No se encontró ninguna factura con el código " + codigoEmpleado);
                rs.close();
                pstmt.close();
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOCabeceraFactura.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.desconectar();
        }
        return false;

    }

    public boolean buscarCliente(int codigoCliente) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        try {

            String sql = "SELECT * "
                    + "FROM super_cabecera_facturas "
                    + "where super_clientes_cli_codigo = ?";
            //System.out.println(sql);

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, codigoCliente);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Factura encontrada:");
                System.out.println("Código: " + rs.getInt("fac_codigo"));
                System.out.println("Fecha: " + rs.getTimestamp("fac_fecha"));
                System.out.println("Subtotal: " + rs.getDouble("fac_subtotal"));
                System.out.println("Total IVA: " + rs.getDouble("fac_total_iva"));
                System.out.println("Valor Total: " + rs.getDouble("fac_valor_total"));
                System.out.println("Estado: " + rs.getString("fac_estado"));
                System.out.println("Código Empleado: " + rs.getInt("super_empleados_emp_codigo"));
                System.out.println("Código Cliente: " + rs.getInt("super_clientes_cli_codigo"));

                rs.close();
                pstmt.close();
                return true;
            } else {
                System.out.println("No se encontró ninguna factura con el código " + codigoCliente);
                rs.close();
                pstmt.close();
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOCabeceraFactura.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.desconectar();
        }
        return false;

    }

    public List<CabeceraFactura> buscarCabeceraFacturaPorCliente(int codigoCliente) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        List<CabeceraFactura> listaCabeceraFacturas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM super_cabecera_facturas WHERE super_clientes_cli_codigo = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, codigoCliente);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Crear un nuevo objeto CabeceraFactura con los datos obtenidos
                int codigo = rs.getInt("fac_codigo");
                Timestamp fecha = rs.getTimestamp("fac_fecha");
                double subtotal = rs.getDouble("fac_subtotal");
                double totalIVA = rs.getDouble("fac_total_iva");
                double valorTotal = rs.getDouble("fac_valor_total");
                char estado = rs.getString("fac_estado").charAt(0);
                int codigoEmpleado = rs.getInt("super_empleados_emp_codigo");

                CabeceraFactura cabeceraFactura = new CabeceraFactura(codigo, fecha, subtotal, totalIVA, valorTotal, estado, codigoEmpleado, codigoCliente);
                listaCabeceraFacturas.add(cabeceraFactura);
            }

            if (listaCabeceraFacturas.isEmpty()) {
                System.out.println("No se encontró ninguna factura con el código del cliente " + codigoCliente);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCabeceraFactura.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.desconectar();
        }

        return listaCabeceraFacturas;
    }

    public List<CabeceraFactura> listarCabecerasFacturas() {
        List<CabeceraFactura> listaCabeceras = new ArrayList<>();
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();

        String sql = "SELECT * FROM super_cabecera_facturas";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("fac_codigo");
                Timestamp fecha = rs.getTimestamp("fac_fecha");
                double subtotal = rs.getDouble("fac_subtotal");
                double totalIVA = rs.getDouble("fac_total_iva");
                double valorTotal = rs.getDouble("fac_valor_total");
                char estado = rs.getString("fac_estado").charAt(0); // Convertir a char
                int codigoEmpleado = rs.getInt("super_empleados_emp_codigo");
                int codigoCliente = rs.getInt("super_clientes_cli_codigo");
                // Si tienes estos campos en tu tabla, agrega también:
                // int codigoClienteV1 = rs.getInt("super_clientesv1_cli_codigo");
                // int codigoEmpleadoV1 = rs.getInt("super_empleadosv1_emp_codigo");

                CabeceraFactura cabecera = new CabeceraFactura(codigo, fecha, subtotal, totalIVA, valorTotal, estado, codigoEmpleado, codigoCliente);
                // Si tienes los campos adicionales, agrega también:
                // cabecera.setCodigoClienteV1(codigoClienteV1);
                // cabecera.setCodigoEmpleadoV1(codigoEmpleadoV1);

                listaCabeceras.add(cabecera);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
        } finally {
            conexion.desconectar();
        }

        return listaCabeceras;
    }
}
