package Run;

import java.sql.*;

public class Main2 {

    public static  void main(String[] args) {

        String url="jdbc:mysql://localhost:3306/tienda";
        String usuario="root";
        String contrasena="";

        try (Connection con = DriverManager.getConnection(url, usuario, contrasena);){

            System.out.println("Conexión exitosa a la base de datos.");

            String sqlQuery = "SELECT * FROM producto";
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery(sqlQuery);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                String descripcion = rs.getString("descripcion");
                System.out.printf("id=%d, nombre=%s, precio=%.2f, descripcion=%s%n",
                        id, nombre, precio, descripcion == null ? "" : descripcion);
            }


        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }finally {
            System.out.println("Proceso finalizado.");
        }

    }

}
