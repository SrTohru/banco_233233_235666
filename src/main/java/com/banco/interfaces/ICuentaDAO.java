/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.banco.interfaces;

import com.banco.dominio.Cliente;
import com.banco.dominio.Cuenta;

/**
 *
 * @author Usuario
 */
public interface ICuentaDAO {
    /**
 *
 * @author Usuario
 *//**
 *
 * @author Usuario
 */
    Cuenta crear(Cuenta cuenta, Cliente cliente);
    Cuenta transferir ();
    Cuenta retirar (String folio, String contrasenia);
    
}
