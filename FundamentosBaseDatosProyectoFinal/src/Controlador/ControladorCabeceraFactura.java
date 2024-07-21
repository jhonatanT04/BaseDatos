/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.DAOCabeceraFactura;
import Modelo.Factura.CabeceraFactura;
import java.sql.SQLException;

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
}
