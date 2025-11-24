package com.proyecto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Cambia estos valores por los de tu MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/tienda_db?createDatabaseIfNotExist=true";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Tu contraseña de root

    private static Connection instance;

    public static Connection getConnection() throws SQLException {
        if (instance == null || instance.isClosed()) {
            // Cargar driver no es estrictamente necesario en versiones modernas de Java/JDBC,
            // pero asegura la compatibilidad.
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException("No se encontró el driver JDBC", e);
            }
            instance = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return instance;
    }

    public static void closeConnection() {
        try {
            if (instance != null && !instance.isClosed()) {
                instance.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}