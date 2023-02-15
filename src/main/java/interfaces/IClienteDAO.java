/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cliente;

/**
 *
 * @author Usuario
 */
public interface IClienteDAO {
    
    Cliente registrarse ();
    Cliente actualizar ();
    Cliente cancelarCuenta ();
    
    
}
