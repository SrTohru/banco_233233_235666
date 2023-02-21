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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
    public Cliente actualizar(Cliente clienteOrignial, Cliente clienteActualizado) {

        Connection conexion = null;

        try {
            conexion = this.GENERADOR_CONEXIONES.crearConexion();

            conexion.setAutoCommit(false);

            CallableStatement spActualizarCliente = conexion.prepareCall("{call actualizar_cliente(?, ?, ?, ?, ?, ?, ?)}");

            spActualizarCliente.setString(1, clienteActualizado.getNombre());
            spActualizarCliente.setString(2, clienteActualizado.getApellidoPaterno());
            spActualizarCliente.setString(3, clienteActualizado.getApellidoMaterno());
            spActualizarCliente.setString(4, clienteActualizado.getUsuario());
            spActualizarCliente.setString(5, encriptarContraseña(clienteActualizado.getNip()));
            spActualizarCliente.setString(6, clienteActualizado.getFechaNacimiento());

            spActualizarCliente.setInt(7, clienteOrignial.getId());
            spActualizarCliente.executeUpdate();

            conexion.commit();

            Cliente c = new Cliente(clienteActualizado.getNombre(), clienteActualizado.getApellidoPaterno(), clienteActualizado.getApellidoMaterno(), clienteActualizado.getFechaNacimiento(), encriptarContraseña(clienteActualizado.getNip()), clienteActualizado.getUsuario());

            return c;
        } catch (SQLException e) {
            if (conexion != null) {
                try {
                    conexion.rollback();
                } catch (SQLException e1) {
                }
            }
            return null;
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {

                }
            }
        }
    }

    @Override
    public Cliente cancelarCuenta() {
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
