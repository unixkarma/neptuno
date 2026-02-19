package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    static Connection con = null;
    static String baseDatos = "neptuno";
    static String url = "jdbc:mysql://localhost:3306/" + baseDatos;
    static String usuario = "neptuno_app";
    static String password = "neptuno123";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión exitosa");
        } catch (Exception e) {
            System.err.println(e);
        }
        return con;
    }
}
