/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.banco.interfaces;

import com.banco.dominio.Cuenta;

/**
 *
 * @author Usuario
 */
public interface ICuentaDAO {
    
    Cuenta transferir ();
    Cuenta retirar (String folio, String contrasenia);
    
}
