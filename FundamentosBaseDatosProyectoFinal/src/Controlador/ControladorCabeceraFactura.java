/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.DAOCabeceraFactura;
import Modelo.Factura.CabeceraFactura;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ControladorCabeceraFactura {
    
    private DAOCabeceraFactura dAOCabeceraFactura;

    public ControladorCabeceraFactura() {
        this.dAOCabeceraFactura = new DAOCabeceraFactura();
    }
    
    public boolean ingresarCabecera(CabeceraFactura cabeceraFactura)throws SQLException{
        return dAOCabeceraFactura.insertarCabeceraFacturas(cabeceraFactura);
    }
    
    public List<CabeceraFactura> buscarPorEmpleado(int Codigo){
        return dAOCabeceraFactura.buscarCabeceraFacturaPorEmpleado(Codigo);
    }
    
    public List<CabeceraFactura> buscarPorCliente(int codigo){
        return dAOCabeceraFactura.buscarCabeceraFacturaPorCliente(codigo);
    }
    
    public CabeceraFactura buscarCabecera(int codigo){
        return dAOCabeceraFactura.buscarCabeceraFacturaPorCodigo(codigo);
    }
    
    public List<CabeceraFactura> listar(){
        return dAOCabeceraFactura.listarCabecerasFacturas();
    }
}
