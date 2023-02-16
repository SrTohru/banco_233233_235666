/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.implementaciones;

import com.banco.dominio.Cliente;
import com.banco.interfaces.IClienteDAO;
import com.banco.interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ClienteDAO implements IClienteDAO {

    private final IConexionBD GENERADOR_CONEXIONES;

    public ClienteDAO(IConexionBD generadorConexiones) {
        this.GENERADOR_CONEXIONES = generadorConexiones;
    }

    private void test(){
        
    }
    
    @Override
    public Cliente registrarse(Cliente cliente) {
        String codigoSQL = "insert into users (nombre, apellidoPaterno, apellidoMaterno, FechaNacimiento, IdDireccion) values(?,?,?,?,?)";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {

            comando.setString(1, cliente.getNombre());
            comando.setString(2, cliente.getApellidoPaterno());
            comando.setString(3, cliente.getApelldioMaterno());
            comando.setString(4, "10/12/2022");
            comando.setInt(5, 1);

            comando.executeUpdate();
            ResultSet generatedKeys = comando.getGeneratedKeys();

            if (generatedKeys.next()) {
                Cliente c = new Cliente(cliente.getNombre(),  cliente.getApellidoPaterno(), cliente.getApelldioMaterno(), 1);
                return c;
            }

        } catch (SQLException e) {
            //LOG.log(Level.SEVERE, e.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public Cliente actualizar() {
        return null;
    }

    @Override
    public Cliente cancelarCuenta() {
        return null;
    }

}
