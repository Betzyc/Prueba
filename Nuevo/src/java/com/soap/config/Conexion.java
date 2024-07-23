/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soap.config;

/**
 *
 * @author betzy
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    Connection conectar = null;

    public static final String driver = "oracle.jdbc.driver.OracleDriver";
   
    public static final String database = "XEBDPRUEBA";
    public static final String hostname = "localhost";
    public static final String port = "1521";
    public static final String url = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + database;
    public static final String username = "system";
    public static final String password = "castillo14";

    public Connection conectar() {
        try {
            Class.forName(driver);
            conectar = DriverManager.getConnection(url, username, password);
            System.out.println("CONECTADO");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }

        return conectar;
    }   
    
    public static Connection getConnection() throws SQLException{
        try {
            Class.forName(driver);
        } catch(ClassNotFoundException e) {
            e.getException();
        }
        return DriverManager.getConnection(url,username,password);
    }
    
    public static void main(String[] args){
        Conexion con = new Conexion();
                
        System.out.println("Conexion exitosa"+ con.conectar());
    }
}
