/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.implementaciones;

import com.banco.dominio.Cliente;
import com.banco.dominio.Direccion;
import com.banco.interfaces.IClienteDAO;
import com.banco.interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteDAO implements IClienteDAO {

    private final IConexionBD GENERADOR_CONEXIONES;

    public ClienteDAO(IConexionBD generadorConexiones) {
        this.GENERADOR_CONEXIONES = generadorConexiones;
    }

    // NOW IS WORKING, please finish them
    @Override
    public Cliente registrarse(Cliente cliente) {
        String codigoSQL = "INSERT INTO clientes (nombre, apellidoPaterno, apellidoMaterno, FechaNacimiento, IdDireccion) values(?,?,?,?,?)";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {

        
            comando.setString(1, cliente.getNombre());
            comando.setString(2, cliente.getApellidoPaterno());
            comando.setString(3, cliente.getApelldioMaterno());
            
            comando.setString(4, cliente.getFechaNacimiento());
            comando.setInt(5, cliente.getIdDireccion());

            comando.executeUpdate();
            ResultSet generatedKeys = comando.getGeneratedKeys();

            if (generatedKeys.next()) {
                Integer llavePrimaria = generatedKeys.getInt(1);
                cliente.setId(llavePrimaria);
                return cliente;
            }

        } catch (SQLException e) {
            return null;
        } 
        return null;
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente cancelarCuenta() {
        return null;
    }

    @Override
    public Direccion ingresarDireccion(Direccion direccion) {
        String codigoSQL = "insert into direcciones (Calle, Colonia, NumExterior) values(?,?,?)";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {

            comando.setString(1, direccion.getCalle());
            comando.setString(2, direccion.getColonia());
            comando.setString(3, direccion.getNumExterior());

            comando.executeUpdate();
            ResultSet generatedKeys = comando.getGeneratedKeys();

            if (generatedKeys.next()) {
                Integer llavePrimaria = generatedKeys.getInt(1);
                direccion.setId(llavePrimaria);
                
                return direccion;
            }

        } catch (SQLException e) {
            return null;
        }
        return null;
    }

}
