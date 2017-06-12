/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpmaven.tp.prog2.persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Matias
 */
public class Conexion {

    private Connection conn;
    private static Conexion instance;

    public static Conexion getInstancia() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    //Verifica los drivers en la conexion
    public Conexion() {
        try {

            this.verificarDriver();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void conectar() throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpmailserver", "root", "matipc");
        } catch (SQLException e) {
            System.err.println("SQLexception: " + e.getMessage());
            throw e;
        }
    }

    private void verificarDriver() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " + e.getMessage());
            throw e;
        }
    }

    //Intenta desconectar la base de datos, en caso de no poder arroja excepcion
    public void desconectar() throws Exception {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    //get que retorna la conexion
    public Connection getConn() {
        return conn;
    }
}
