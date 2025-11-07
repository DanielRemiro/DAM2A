import java.sql.*;
public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/tienda";

        String usuario = "root";

        String password = "";

        String consulta = "SELECT * FROM producto";

        // --- 3. Bloque de Conexión y Consulta ---

        try (Connection con = DriverManager.getConnection(url, usuario, password);
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(consulta)) {

            System.out.println("--- Conexión exitosa a la BBDD 'tienda' ---");
            System.out.println("Mostrando productos:");
            System.out.println("-------------------------------------------------");

            while (rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                String descripcion = rs.getString("descripcion");

                System.out.printf("ID: %-3d | Nombre: %-25s | Precio: %-7.2f | Desc: %s%n",
                        id, nombre, precio, descripcion);
            }

        } catch (SQLException e) {
            System.err.println("Error al conectar o consultar la base de datos:");
            e.printStackTrace();
        }
    }
}