package Run;

import java.sql.*;

public class Main {

    public static  void main(String[] args) {

        String url="jdbc:mysql://localhost:3306/clase";
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

            st.close();

            //Insert

            st=con.createStatement();

            //sqlQuery = "INSERT INTO producto (id, nombre, precio, descripcion) VALUES (1004, 'Producto4', 40.0, 'Descripción del producto 4')";
            //int filasInsertadas=st.executeUpdate(sqlQuery);
            //System.out.println("Filas insertadas: " + filasInsertadas);

            //Update

            //sqlQuery = "UPDATE producto SET precio=45.0 WHERE id=1004";
            //int filasActualizadas=st.executeUpdate(sqlQuery);
            //System.out.println("Filas actualizadas: " + filasActualizadas);

            //Delete
            //sqlQuery = "DELETE FROM producto WHERE id=1004";
            //int filasBorradas=st.executeUpdate(sqlQuery);
            //System.out.println("Filas borradas: " + filasBorradas);

            st.close();



        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }finally {
            System.out.println("Proceso finalizado.");
        }

    }

}
