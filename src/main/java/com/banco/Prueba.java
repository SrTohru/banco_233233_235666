/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.banco;

import com.banco.displays.InicioForm;
import com.banco.implementaciones.ClienteDAO;
import com.banco.implementaciones.ConexionBD;
import com.banco.implementaciones.CuentaDAO;
import com.banco.interfaces.IClienteDAO;
import com.banco.interfaces.IConexionBD;
import com.banco.interfaces.ICuentaDAO;

public class Prueba {

    public static void main(String[] args) {
        IConexionBD manejadorConexiones = new ConexionBD(
                "jdbc:mysql://localhost/banco",
                "root",
                "2210"
        );

        IClienteDAO clientesDAO = new ClienteDAO(manejadorConexiones);
        ICuentaDAO cuentaDAO = new CuentaDAO(manejadorConexiones);
        new InicioForm(clientesDAO, cuentaDAO).setVisible(true);
    }

}
