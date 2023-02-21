/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.banco.interfaces;

import com.banco.dominio.Cliente;
import com.banco.dominio.Cuenta;
import javax.swing.JComboBox;

/**
 *
 * @author Usuario
 */
public interface ICuentaDAO {

    Cuenta crear(Cuenta cuenta, Cliente cliente);
    boolean transferir (int idCuentaOrigen, int idCuentaDestino, double monto);
    Cuenta retirar (String folio, String contrasenia);
    Cliente iniciarSesion(Cliente cliente);
    boolean generarFolio(int idCuenta, double monto, String contraseña);
    boolean actualizarSaldo(Cuenta cuenta, double monto);
    Cuenta consultarPorId(int idCuenta);
    public void mostrarCuentasDeClienteEnComboBox(int idCliente, JComboBox<String> comboBoxCuentas);
}
