/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.implementaciones;

import com.banco.configPaginado.ConfiguracionPaginado;
import com.banco.dominio.Cliente;
import com.banco.dominio.Cuenta;
import com.banco.dominio.Transaccion;
import com.banco.interfaces.IConexionBD;
import com.banco.interfaces.ICuentaDAO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class CuentaDAO implements ICuentaDAO {

    private final IConexionBD GENERADOR_CONEXIONES;

    public CuentaDAO(IConexionBD generadorConexiones) {
        this.GENERADOR_CONEXIONES = generadorConexiones;
    }

    @Override
    public Cuenta crear(Cuenta cuenta, Cliente cliente) {

        String codigoSQL = "INSERT INTO cuentas (estado, fechaApertura, saldo, idCliente) values(?,?,?,?)";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS);) {

            LocalDate fechaActual = LocalDate.now();

            comando.setString(1, "activa");
            comando.setString(2, fechaActual.toString());
            comando.setDouble(3, cuenta.getSaldo());
            comando.setInt(4, cliente.getId());

            comando.executeUpdate();
            ResultSet generatedKeys = comando.getGeneratedKeys();

            if (generatedKeys.next()) {
                Integer llavePrimaria = generatedKeys.getInt(1);
                Cuenta c = new Cuenta(llavePrimaria, cliente.getId(), 0.0, "activa", fechaActual.toString());
                c.setId(llavePrimaria);
                return c;
            }

        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    @Override
    public boolean transferir(int idCuentaOrigen, int idCuentaDestino, double monto) {
        String sqlActualizarCuentaOrigen = "UPDATE cuentas SET saldo = saldo - ? WHERE id = ?";
        String sqlActualizarCuentaDestino = "UPDATE cuentas SET saldo = saldo + ? WHERE id = ?";
        String sqlInsertarTransferencia = "INSERT INTO transferencias(estado,tipo, monto, idCuenta) VALUES(?,?,?,?)";

        Connection conexion = null;
        PreparedStatement psActualizarCuentaOrigen = null;
        PreparedStatement psActualizarCuentaDestino = null;
        PreparedStatement psInsertarTranferencia = null;
        try {
            conexion = this.GENERADOR_CONEXIONES.crearConexion();

            conexion.setAutoCommit(false);

            psActualizarCuentaOrigen = conexion.prepareStatement(sqlActualizarCuentaOrigen);
            psActualizarCuentaDestino = conexion.prepareStatement(sqlActualizarCuentaDestino);
            psInsertarTranferencia = conexion.prepareStatement(sqlInsertarTransferencia);

            psActualizarCuentaOrigen.setDouble(1, monto);
            psActualizarCuentaOrigen.setInt(2, idCuentaOrigen);
            psActualizarCuentaOrigen.executeUpdate();

            psActualizarCuentaDestino.setDouble(1, monto);
            psActualizarCuentaDestino.setInt(2, idCuentaDestino);
            psActualizarCuentaDestino.executeUpdate();

            psInsertarTranferencia.setString(1, "exitosa");
            psInsertarTranferencia.setString(2, "Deposito");
            psInsertarTranferencia.setDouble(3, monto);
            psInsertarTranferencia.setInt(4, idCuentaOrigen);
            psInsertarTranferencia.executeUpdate();
            conexion.commit();

            return true;
        } catch (SQLException e) {
            if (conexion != null) {
                try {
                    conexion.rollback();
                } catch (SQLException e1) {
                }
            }
            return false;
        } finally {

            if (psActualizarCuentaOrigen != null) {
                try {
                    psActualizarCuentaOrigen.close();
                } catch (SQLException e) {

                }
            }
            if (psActualizarCuentaDestino != null) {
                try {
                    psActualizarCuentaDestino.close();
                } catch (SQLException e) {

                }
            }
            if (psInsertarTranferencia != null) {
                try {
                    psInsertarTranferencia.close();
                } catch (SQLException e) {

                }
            }

            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {

                }
            }
        }
    }

    @Override
    public Cliente iniciarSesion(Cliente cliente) {
        String codigoSQL = "SELECT * FROM Clientes WHERE usuario = ? AND nip = ?";
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {

            comando.setString(1, cliente.getUsuario());
            comando.setString(2, encriptarContraseña(cliente.getNip()));

            ResultSet result = comando.executeQuery();

            Cliente c = null;

            if (result.next()) {
                Integer id = result.getInt("id");
                String nombre = result.getString("nombre");
                String apellidoPaterno = result.getString("apellidoPaterno");
                String apellidoMaterno = result.getString("apellidoMaterno");
                String fechaNacimiento = result.getString("fechaNacimiento");
                Integer idDireccion = result.getInt("idDireccion");

                c = new Cliente(id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, cliente.getNip(), cliente.getUsuario());

                return c;
            }

        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    @Override
    public void mostrarCuentasDeClienteEnComboBox(int idCliente, JComboBox<String> comboBoxCuentas) {
        String sql = "SELECT * FROM cuentas WHERE idCliente = ?";

        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conexion = this.GENERADOR_CONEXIONES.crearConexion();

            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idCliente);

            rs = ps.executeQuery();

            comboBoxCuentas.removeAllItems();

            while (rs.next()) {
                int idCuenta = rs.getInt("id");
                double tipoCuenta = rs.getDouble("saldo");
                comboBoxCuentas.addItem(idCuenta + " - Saldo: " + tipoCuenta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Transaccion> consultarTransferencias(ConfiguracionPaginado configPaginado, Integer idCuenta) {
        String sql = "SELECT * FROM transferencias WHERE idCuenta = ?";

        List<Transaccion> listaTransacciones = new LinkedList<>();
        try (
                Connection conexion = this.GENERADOR_CONEXIONES.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql);) {

            comando.setInt(1, idCuenta);

            ResultSet resultado = comando.executeQuery();

            Transaccion trans = null;

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String estado = resultado.getString("estado");
                String fecha = resultado.getString("fecha");
                String tipo = resultado.getString("tipo");
                double monto = resultado.getDouble("monto");
             
                
                trans = new Transaccion(estado, tipo, id, fecha, idCuenta, monto);
                listaTransacciones.add(trans);
            }
            return listaTransacciones;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            return null;
        }
    }

    @Override
    public Cuenta retirar(String folio, String contrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cuenta consultarPorId(int idCuenta) {
        Connection conexion = null;
        try {

            conexion = this.GENERADOR_CONEXIONES.crearConexion();

            String sql = "SELECT * FROM cuentas WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idCuenta);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Cuenta cuenta = new Cuenta();
                cuenta.setId(rs.getInt("id"));
                cuenta.setIdCliente(rs.getInt("idCliente"));
                cuenta.setSaldo(rs.getDouble("saldo"));
                return cuenta;
            } else {

                JOptionPane.showMessageDialog(null, "No se encontró la cuenta con el idCuenta especificado.");
                return null;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar la cuenta: " + e.getMessage());
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
    public boolean generarFolio(int idCuenta, double monto, String contrasena) {

        String folio = generarFolioAleatorio();

        Connection conexion = null;
        try {
            conexion = this.GENERADOR_CONEXIONES.crearConexion();
            conexion.setAutoCommit(false);

            Cuenta cuenta = consultarPorId(idCuenta);

            double saldo = cuenta.getSaldo();

            if (monto > saldo) {
                JOptionPane.showMessageDialog(null, "El monto a retirar es mayor al saldo de la cuenta.");
                conexion.rollback();
                return false;
            }

            if (!actualizarSaldo(cuenta, monto)) {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el saldo de la cuenta.");
                conexion.rollback();
                return false;
            }

            String sql = "INSERT INTO retiros (estado, monto, folio, contraseña, idCuenta) VALUES (?,?,?,?,?)";
            String sqlInsertarTransferencia = "INSERT INTO transferencias(estado,tipo, monto, idCuenta) VALUES(?,?,?,?)";

            PreparedStatement ps = conexion.prepareStatement(sql);
            PreparedStatement psTransferencia = conexion.prepareStatement(sqlInsertarTransferencia);

            ps.setString(1, "pendiente");
            ps.setDouble(2, monto);
            ps.setString(3, folio);
            ps.setString(4, encriptarContraseña(contrasena));
            ps.setInt(5, idCuenta);
            ps.executeUpdate();

            psTransferencia.setString(1, "exitosa");
            psTransferencia.setString(2, "Retiro");
            psTransferencia.setDouble(3, monto);
            psTransferencia.setInt(4, idCuenta);
            psTransferencia.executeUpdate();

            ps.close();
            psTransferencia.close();

            conexion.commit();
            JOptionPane.showMessageDialog(null, "Retiro realizado con éxito. Folio: " + folio);
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la transacción: " + e.getMessage());
            if (conexion != null) {
                try {
                    conexion.rollback();
                } catch (SQLException ex) {
                }
            }
            return false;
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
    public boolean actualizarSaldo(Cuenta cuenta, double monto) {
        String sqlActualizarCuentaOrigen = "UPDATE cuentas SET saldo = saldo - ? WHERE id = ?";

        Connection conexion = null;
        PreparedStatement psActualizarCuentaOrigen = null;

        try {
            conexion = this.GENERADOR_CONEXIONES.crearConexion();

            conexion.setAutoCommit(false);

            psActualizarCuentaOrigen = conexion.prepareStatement(sqlActualizarCuentaOrigen);
            JOptionPane.showMessageDialog(null, "Monto: " + monto);
            psActualizarCuentaOrigen.setDouble(1, monto);
            psActualizarCuentaOrigen.setInt(2, cuenta.getId());
            psActualizarCuentaOrigen.executeUpdate();

            conexion.commit();

            return true;
        } catch (SQLException e) {
            if (conexion != null) {
                try {
                    conexion.rollback();
                } catch (SQLException e1) {
                }
            }
            return false;
        } finally {

            if (psActualizarCuentaOrigen != null) {
                try {
                    psActualizarCuentaOrigen.close();
                } catch (SQLException e) {

                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {

                }
            }
        }
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

    private String generarFolioAleatorio() {
        Random random = new Random();
        int folioNumero = random.nextInt(900000) + 100000;
        return String.format("R%06d", folioNumero);
    }

}
