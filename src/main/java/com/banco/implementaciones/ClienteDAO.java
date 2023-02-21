/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.implementaciones;

import com.banco.dominio.Cliente;
import com.banco.dominio.Direccion;
import com.banco.interfaces.IClienteDAO;
import com.banco.interfaces.IConexionBD;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ClienteDAO implements IClienteDAO {

    private final IConexionBD GENERADOR_CONEXIONES;

    public ClienteDAO(IConexionBD generadorConexiones) {
        this.GENERADOR_CONEXIONES = generadorConexiones;
    }

    @Override
    public Cliente registrarse(Cliente cliente, Direccion direccion) {
        String sqlCliente = "INSERT INTO clientes (nombre, apellidoPaterno, apellidoMaterno, usuario, nip, fechaNacimiento, idDireccion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String sqlDireccion = "INSERT INTO direcciones (calle, colonia, numExterior) VALUES (?, ?, ?)";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement cDireccion = conexion.prepareStatement(sqlDireccion, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement cCliente = conexion.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS);) {
            conexion.setAutoCommit(false); // Desactivar auto-commit

            // Insertar dirección
            cDireccion.setString(1, direccion.getCalle());
            cDireccion.setString(2, direccion.getColonia());
            cDireccion.setString(3, direccion.getNumExterior());
            cDireccion.executeUpdate();
            ResultSet llaveDireccion = cDireccion.getGeneratedKeys();
            Integer llavePrimariaDireccion = null;
            if (llaveDireccion.next()) {
                llavePrimariaDireccion = llaveDireccion.getInt(1);
                JOptionPane.showMessageDialog(null, "Llave primaria direccion: " + llavePrimariaDireccion);
            } else {
                throw new SQLException("No se pudo obtener la llave primaria para la dirección insertada");
            }

            // Insertar cliente
            cCliente.setString(1, cliente.getNombre());
            cCliente.setString(2, cliente.getApellidoPaterno());
            cCliente.setString(3, cliente.getApellidoMaterno());
            cCliente.setString(4, cliente.getUsuario());
            cCliente.setString(5, encriptarContraseña(cliente.getNip()));
            cCliente.setString(6, cliente.getFechaNacimiento());
            cCliente.setInt(7, llavePrimariaDireccion);
            cCliente.executeUpdate();

            ResultSet llaveCliente = cCliente.getGeneratedKeys();
            Integer llavePrimariaCliente = null;
            if (llaveCliente.next()) {
                llavePrimariaCliente = llaveCliente.getInt(1);
            } else {
                throw new SQLException("No se pudo obtener la llave primaria para el cliente insertado");
            }

            conexion.commit(); // Confirmar transacción

            // Asignar llave primaria al objeto Cliente
            cliente.setId(llavePrimariaCliente);
            return cliente;

        } catch (SQLException e) {
            System.out.println("Error al insertar en la base de datos: " + e.getMessage());
            return null;
        }
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
