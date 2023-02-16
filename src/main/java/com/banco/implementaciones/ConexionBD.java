/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banco.implementaciones;

import com.banco.interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ConexionBD implements IConexionBD{
    
    private final String CADENA_CONEXION;
    private final String USUARIO;
    private final String PASSWORD;
    
    public ConexionBD(String cadenaConexion, String usuario, String password){
        this.CADENA_CONEXION = cadenaConexion;
        this.PASSWORD = password;
        this.USUARIO = usuario;
    }
    
    @Override
    public Connection crearConexion() throws SQLException{
        String cadenaConexion = "jdbc://mysql://localhost/banco";
        Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, PASSWORD);
        return conexion;
    }
    
    
}
