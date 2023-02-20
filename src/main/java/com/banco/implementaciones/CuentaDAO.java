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
    public Cliente iniciarSesion(Cliente cliente) {
        String codigoSQL = "SELECT * FROM Clientes WHERE usuario = ?";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {

           comando.setString(1, cliente.getUsuario());
            //comando.setString(2, encriptarContraseña(cliente.getNip()));

            ResultSet result = comando.executeQuery();
            
            Cliente c = null;
            
            if (result.next()) {
                Integer id = result.getInt("id");
                String user = result.getString("usuario");
                Integer idCuenta = result.getInt("idCuenta");
                  //JOptionPane.showMessageDialog(null, "Si se pudo, ID cuenta y cliente: " + id + " : " + idCuenta);
                String nombre = result.getString("nombre");
                String apellidoPaterno = result.getString("apellidoPaterno");
                String apellidoMaterno = result.getString("apellidoMaterno");
                String fechaNacimiento = result.getString("fechaNacimiento");
                Integer idDireccion = result.getInt("idDireccion");
                
             //   JOptionPane.showMessageDialog(null, "Si se pudo, ID cuenta y cliente: " + id + " : " + idCuenta);
                c =  new Cliente(id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, idDireccion, idCuenta, user);

                
                return c;
            }

        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    public static String encriptarContraseña(String password) {
        String encryptedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            encryptedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptedPassword;
    }

}
