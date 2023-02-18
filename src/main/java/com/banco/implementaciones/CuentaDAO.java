/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.implementaciones;

import com.banco.dominio.Cliente;
import com.banco.dominio.Cuenta;
import com.banco.interfaces.IConexionBD;
import com.banco.interfaces.ICuentaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class CuentaDAO implements ICuentaDAO {

    private final IConexionBD GENERADOR_CONEXIONES;

    public CuentaDAO(IConexionBD generadorConexiones) {
        this.GENERADOR_CONEXIONES = generadorConexiones;
    }
/**
 *
 * @author Usuario
 *//**
 *
 * @author Usuario
 */
//To do: Finish the insertion :)
    @Override
    public Cuenta crear(Cuenta cuenta, Cliente cliente) {

        String codigoSQL = "INSERT INTO cuentas (usuario, contraseña, Estado, FechaApertura, Saldo, IdCliente) values(?,?,?,?,?,?)";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {

            LocalDate fechaActual = LocalDate.now();

            comando.setString(1, cuenta.getUsuario());
            comando.setString(2, cuenta.getContraseña());
            comando.setString(3, "Activa");
            comando.setString(4, fechaActual.toString());
            comando.setDouble(5, 0.0);
            comando.setInt(6, cliente.getId());

            comando.executeUpdate();
            ResultSet generatedKeys = comando.getGeneratedKeys();

            if (generatedKeys.next()) {
                Integer llavePrimaria = generatedKeys.getInt(1);
                Cuenta c = new Cuenta(cliente.getId(), "Activa" , fechaActual.toString(), cuenta.getUsuario(), cuenta.getContraseña());
                c.setId(llavePrimaria);
                return c;
            }

        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    @Override
    public Cuenta transferir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cuenta retirar(String folio, String contrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String encriptarContraseña(String contraseña) {
        return "";
    }

}
