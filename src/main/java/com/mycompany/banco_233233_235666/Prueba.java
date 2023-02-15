/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.banco_233233_235666;

import implementaciones.ConexionBD;
import interfaces.IConexionBD;

/**
 *
 * @author Usuario
 */
public class Prueba {

    public static void main(String[] args) {
        IConexionBD manejadorConexiones = new ConexionBD(
                "jdbc:mysql://localhost/banco",
                "root",
                "2210"
        );
        IClientesDAO clientesDAO = new ClientesDAO(manejadorConexiones);
        new ClientesForm(clientesDAO).setVisible(true);
    }
}
