/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.banco.interfaces;

import com.banco.dominio.Cliente;
import com.banco.dominio.Direccion;

/**
 *
 * @author Usuario
 */
public interface IClienteDAO {
    
    Cliente registrarse (Cliente cliente,Direccion direccion);
    Direccion ingresarDireccion(Direccion direccion);
    Cliente actualizar (Cliente cliente);
    Cliente cancelarCuenta ();
 
}
