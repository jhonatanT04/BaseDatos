/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.DAOCliente;
import Modelo.Personas.Persona.Cliente;
import java.sql.SQLException;

/**
 *
 * @author venot
 */
public class ControladorCliente {
    private DAOCliente daoCliente;

    public ControladorCliente() {
        daoCliente= new DAOCliente();
    }
    
    
    public void crearCliente(Cliente cliente) throws SQLException{
        daoCliente.insertarCliente(cliente);
    }
    public Cliente buscarCliente(String cedula) throws SQLException{
        return daoCliente.buscarClientePorCedula(cedula);
    }
    
}
