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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ClienteDAO implements IClienteDAO {

    private final IConexionBD GENERADOR_CONEXIONES;

    public ClienteDAO(IConexionBD generadorConexiones) {
        this.GENERADOR_CONEXIONES = generadorConexiones;
    }

   // NOW IS WORKING, please finish them
    
    @Override
    public Cliente registrarse(Cliente cliente) {
        String codigoSQL = "insert into clientes (nombre, apellidoPaterno, apellidoMaterno, FechaNacimiento, IdDireccion) values(?,?,?,?,?)";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {

            comando.setString(1, cliente.getNombre());
            comando.setString(2, cliente.getApellidoPaterno());
            comando.setString(3, cliente.getApelldioMaterno());
            comando.setString(4, "2010-02-20");
            comando.setInt(5, 1);

            comando.executeUpdate();
            ResultSet generatedKeys = comando.getGeneratedKeys();

            if (generatedKeys.next()) {
                Cliente c = new Cliente(cliente.getNombre(),  cliente.getApellidoPaterno(), cliente.getApelldioMaterno(), 1);
                return c;
            }

        } catch (SQLException e) {
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
