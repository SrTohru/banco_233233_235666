/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.banco;

import com.banco.displays.LoginForm;
import com.banco.implementaciones.ClienteDAO;
import com.banco.implementaciones.ConexionBD;
import com.banco.interfaces.IClienteDAO;
import com.banco.interfaces.IConexionBD;

/**
 *
 * @author Usuario
 */
public class Prueba {

    public static void main(String[] args) {
        IConexionBD manejadorConexiones = new ConexionBD(
                "db.ptkzapmsarobjneirtfj.supabase.co",
                "postgres",
                "equipodebases"
        );
//asdij+as{dijAÍDJASPDEFOJASLDF
        IClienteDAO clientesDAO = new ClienteDAO(manejadorConexiones) {};
        new LoginForm(clientesDAO).setVisible(true);
    }
}
