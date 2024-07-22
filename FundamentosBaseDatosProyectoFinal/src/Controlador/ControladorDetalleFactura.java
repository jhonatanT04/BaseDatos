/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.DAODetalleFactura;
import Modelo.Factura.DetalleFactura;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ControladorDetalleFactura {
    
    private DAODetalleFactura dAODetalleFactura;

    public ControladorDetalleFactura() {
        this.dAODetalleFactura = new DAODetalleFactura();
    }
    
    public boolean ingresardetalle(DetalleFactura detalleFactura)throws SQLException{
        return dAODetalleFactura.insertarDetalleFactura(detalleFactura);
    }
    
    public List<DetalleFactura> buscar(int codigo){
        return dAODetalleFactura.buscarDetalleFactura(codigo);
    }
}
