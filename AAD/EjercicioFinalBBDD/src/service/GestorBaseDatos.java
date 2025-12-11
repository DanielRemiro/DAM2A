package service;

import util.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorBaseDatos {

    public void inicializar() {
        String sqlCat = "CREATE TABLE IF NOT EXISTS categorias (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nombre VARCHAR(50) NOT NULL)";

        String sqlProd = "CREATE TABLE IF NOT EXISTS productos (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nombre VARCHAR(100) NOT NULL, " +
                "precio DECIMAL(10,2), " +
                "categoria_id INT, " +
                "imagen LONGBLOB, " +
                "FOREIGN KEY (categoria_id) REFERENCES categorias(id) ON DELETE RESTRICT)";

        String sqlPedido = "CREATE TABLE IF NOT EXISTS pedidos (id INT AUTO_INCREMENT PRIMARY KEY, cliente VARCHAR(50))";
        String sqlLineas = "CREATE TABLE IF NOT EXISTS linea_pedidos (" +
                "pedido_id INT, producto_id INT, " +
                "FOREIGN KEY (pedido_id) REFERENCES pedidos(id) ON DELETE CASCADE, " +
                "FOREIGN KEY (producto_id) REFERENCES productos(id))";


        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (Statement stmt = conn.createStatement()) {

                stmt.execute(sqlCat);
                stmt.execute(sqlProd);
                stmt.execute(sqlPedido);
                stmt.execute(sqlLineas);

                if(stmt.executeUpdate("INSERT IGNORE INTO categorias (id, nombre) VALUES (1, 'Electrónica')") > 0) {
                    System.out.println(" Datos iniciales cargados.");
                }
            }

            conn.commit();
            System.out.println("Base de datos inicializada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error inicializando BD. Haciendo Rollback.");
            e.printStackTrace();
        }
    }
}