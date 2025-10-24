import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/accesodatos",
                    "root",
                    "");

            System.out.println("Conexión establecida correctamente.");
            String sentenciaSql = "SELECT nombre, precio FROM productos ";
            PreparedStatement sentencia = null;
            ResultSet resultado = null;

            try {
                sentencia = conexion.prepareStatement(sentenciaSql);
                resultado = sentencia.executeQuery();
                while (resultado.next()) {
                    System.out.println("nombre: " + resultado.getString(1));
                    System.out.println("precio: " + resultado.getFloat(2));
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                if (sentencia != null)
                    try {
                        sentencia.close();
                        resultado.close();
                    } catch (SQLException sqle) {
                        sqle.printStackTrace();
                    }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }


    }
}
