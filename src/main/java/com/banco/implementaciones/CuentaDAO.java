/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.implementaciones;

import com.banco.dominio.Cliente;
import com.banco.dominio.Cuenta;
import com.banco.interfaces.IConexionBD;
import com.banco.interfaces.ICuentaDAO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class CuentaDAO implements ICuentaDAO {

    private final IConexionBD GENERADOR_CONEXIONES;

    public CuentaDAO(IConexionBD generadorConexiones) {
        this.GENERADOR_CONEXIONES = generadorConexiones;
    }

    @Override
    public Cuenta crear(Cuenta cuenta, Cliente cliente) {

        String codigoSQL = "INSERT INTO cuentas (alias, estado, fechaApertura, saldo, idCliente) values(?,?,?,?,?)";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {

            LocalDate fechaActual = LocalDate.now();
           
            comando.setString(1, cuenta.getAlias());
            comando.setString(2, "activa");
            comando.setString(3, fechaActual.toString());
            comando.setDouble(4, 0.0);
            comando.setInt(5, cliente.getId());

            comando.executeUpdate();
            ResultSet generatedKeys = comando.getGeneratedKeys();

            if (generatedKeys.next()) {
                Integer llavePrimaria = generatedKeys.getInt(1);
                //public Cuenta(Integer id, Integer idCliente, double saldo, String estado, String fechaApertura, String alias) {
                Cuenta c = new Cuenta(llavePrimaria, cliente.getId(), 0.0, "activa", fechaActual.toString(), cuenta.getAlias());
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


    @Override
    public Cuenta iniciarSesion(Cuenta cuenta) {
        String codigoSQL = "SELECT (usuario, contraseña,estado, saldo, IdCliente) FROM cuentas WHERE usuario = ? AND contraseña = ?";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {

           // comando.setString(1, cuenta.getUsuario());
          //  comando.setString(1, encriptarContraseña(cuenta.getContraseña()));

            comando.executeUpdate();
            ResultSet result = comando.executeQuery();

            if (result.next()) {
                String user = result.getString("usuario");
                String estado = result.getString("estado");
                double saldo = result.getDouble("saldo");
                Integer idCliente = result.getInt("usuario");
             //   Cuenta c = new Cuenta(idCliente, saldo, estado, user);
            //    c.setId(comando.getGeneratedKeys().getInt(1));
              //  JOptionPane.showMessageDialog(null, "Si se pudo, ID cuenta y cliente: " + idCliente + " : " + c.getId());
               // return c;
            }

        } catch (SQLException e) {
            return null;
        }
        return null;
    }

}
