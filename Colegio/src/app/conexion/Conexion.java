package app.conexion;

import app.app.Env;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

    private static final String BD = Env.baseDatos;
    private static final String URL = "jdbc:mysql://localhost:3306/" + BD;
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection connection = null;

    private Conexion() {

    }

    public static Connection conectar() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASS);

            } catch (ClassNotFoundException | SQLException e) {

                JOptionPane.showMessageDialog(null, "Error al conectar :" + e.getMessage(), "Atención", JOptionPane.ERROR_MESSAGE);

            }
        }

        return connection;
    }

    public void desconectar() throws SQLException {
        connection.close();
    }

}
