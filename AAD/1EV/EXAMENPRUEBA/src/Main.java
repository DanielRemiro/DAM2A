import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GestorFutbol gestor = new GestorFutbol();

        // 1. INSERTAR
        // Creamos objetos Java puros
        Equipo equipoA = new Equipo("Real Madrid", "Bernabéu");
        Jugador j1 = new Jugador("Vinicius", "Delantero", equipoA);

        // Al insertar, el gestor verá que "Real Madrid" no existe y lo creará.
        gestor.insertarJugador(j1);

        // Insertamos otro jugador del MISMO equipo objeto
        Jugador j2 = new Jugador("Modric", "Medio", equipoA);
        // El gestor verá que "Real Madrid" YA existe y solo linkeará el ID.
        gestor.insertarJugador(j2);


        // 2. LISTAR
        System.out.println("\n--- LISTADO ---");
        ArrayList<Jugador> misJugadores = gestor.listarJugadores();
        for (Jugador j : misJugadores) {
            System.out.println("ID: " + j.getId() + " | " + j.getNombre() + " (" + j.getEquipo().getNombre() + ")");
        }


        // 3. ACTUALIZAR
        // Supongamos que queremos cambiar al primer jugador de la lista
        if (!misJugadores.isEmpty()) {
            Jugador jugadorAEditar = misJugadores.get(0); // Vinicius
            int idParaEditar = jugadorAEditar.getId();

            // Creamos un nuevo equipo para probar el cambio de equipo
            Equipo equipoB = new Equipo("Manchester City", "Etihad");
            Jugador datosNuevos = new Jugador("Vinicius Jr.", "Extremo", equipoB);

            // Esto actualizará el nombre, la posición Y creará el City si no existe
            gestor.actualizarJugador(idParaEditar, datosNuevos);
        }


        // 4. ELIMINAR
        // Eliminamos al segundo jugador
        if (misJugadores.size() > 1) {
            gestor.eliminarJugador(misJugadores.get(1).getId());
        }

        // Comprobación final
        gestor.listarJugadores();
    }
}