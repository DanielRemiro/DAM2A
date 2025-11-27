import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorFutbol {

    private static final String URL = "jdbc:mysql://localhost:3306/futbol_db";
    private static final String USER = "root";
    private static final String PASS = "";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // ==========================================
    // 1. LISTAR (Read) - Reconstruye los objetos
    // ==========================================
    public ArrayList<Jugador> listarJugadores() {
        ArrayList<Jugador> lista = new ArrayList<>();
        // Hacemos JOIN para traer los datos del equipo también
        String sql = "SELECT j.id, j.nombre, j.posicion, e.nombre AS nom_eq, e.estadio " +
                "FROM jugadores j " +
                "JOIN equipos e ON j.id_equipo = e.id";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // 1. Reconstruimos el objeto Equipo
                Equipo e = new Equipo(rs.getString("nom_eq"), rs.getString("estadio"));

                // 2. Reconstruimos el objeto Jugador
                Jugador j = new Jugador(rs.getString("nombre"), rs.getString("posicion"), e);
                j.setId(rs.getInt("id")); // Guardamos el ID de la BBDD

                lista.add(j);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // ==========================================
    // 2. INSERTAR (Create)
    // ==========================================
    public void insertarJugador(Jugador j) {
        String sql = "INSERT INTO jugadores (nombre, posicion, id_equipo) VALUES (?, ?, ?)";

        try (Connection conn = conectar()) {
            // 1. Obtenemos el ID del equipo (lo crea si no existe)
            int idEquipo = gestionarEquipo(conn, j.getEquipo());

            // 2. Insertamos al jugador usando ese ID
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, j.getNombre());
                ps.setString(2, j.getPosicion());
                ps.setInt(3, idEquipo);
                ps.executeUpdate();
                System.out.println("✅ Jugador insertado: " + j.getNombre());
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }
    }

    // ==========================================
    // 3. ACTUALIZAR (Update)
    // ==========================================
    public void actualizarJugador(int idJugador, Jugador nuevosDatos) {
        String sql = "UPDATE jugadores SET nombre = ?, posicion = ?, id_equipo = ? WHERE id = ?";

        try (Connection conn = conectar()) {
            // 1. Verificamos el equipo de los nuevos datos (por si cambió de equipo)
            int idEquipo = gestionarEquipo(conn, nuevosDatos.getEquipo());

            // 2. Actualizamos
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, nuevosDatos.getNombre());
                ps.setString(2, nuevosDatos.getPosicion());
                ps.setInt(3, idEquipo);
                ps.setInt(4, idJugador);

                int filas = ps.executeUpdate();
                if (filas > 0) System.out.println("🔄 Jugador actualizado correctamente.");
                else System.out.println("⚠️ No se encontró el jugador con ID " + idJugador);
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }

    // ==========================================
    // 4. ELIMINAR (Delete)
    // ==========================================
    public void eliminarJugador(int idJugador) {
        String sql = "DELETE FROM jugadores WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idJugador);
            int filas = ps.executeUpdate();

            if (filas > 0) System.out.println("❌ Jugador eliminado.");
            else System.out.println("⚠️ ID no encontrado.");

        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }

    // ==========================================
    // MÉTODO AUXILIAR (El cerebro de la relación)
    // ==========================================
    /**
     * Busca si el equipo existe por nombre.
     * Si existe -> Devuelve su ID.
     * Si NO existe -> Lo inserta y devuelve el nuevo ID generado.
     */
    private int gestionarEquipo(Connection conn, Equipo equipo) throws SQLException {
        // 1. Intentar buscar el equipo
        String sqlBuscar = "SELECT id FROM equipos WHERE nombre = ?";
        try (PreparedStatement ps = conn.prepareStatement(sqlBuscar)) {
            ps.setString(1, equipo.getNombre());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id"); // ¡Ya existía! Devolvemos su ID.
            }
        }

        // 2. Si no existía, lo insertamos
        String sqlInsertar = "INSERT INTO equipos (nombre, estadio) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sqlInsertar, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, equipo.getNombre());
            ps.setString(2, equipo.getEstadio());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("   (Equipo nuevo creado: " + equipo.getNombre() + ")");
                return rs.getInt(1); // Devolvemos el nuevo ID
            }
        }

        throw new SQLException("No se pudo obtener el ID del equipo.");
    }
}