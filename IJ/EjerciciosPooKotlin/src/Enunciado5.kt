//Modela un sistema de videojuegos, en el que todos los videojuegos pueden ser iniciados,
// pausados y terminados. Además se debe calcular la puntuación obtenida en el videojuego en función
// del tiempo (parámetro entero en segundos) y un parámetro de precisión que indique la habilidad
// alcanzada por el jugador (campo de tipo Double).
//
//Existen además videojuegos multijugador en el que se producen las acciones de unir
// a la sesión a cada uno de los jugadores, expulsar al jugador, y obtener la lista de jugadores
// jugando a un juego en un momento dado.
//
//La empresa tiene dos tipos de juegos: Juegos de acción que solo pueden ser jugados
// por un usuario simultáneo y juegos de estrategia, el cual varias personas pueden
// utilizarlo al mismo tiempo. En estos juegos en el cálculo de de puntuación deberá ser
// tenido en cuenta el número de jugadores presentes en ese momento en el juego

interface Videojuego {
    fun iniciar()
    fun pausar()
    fun terminar()
    fun calcularPuntuacion(tiempo: Int, precision: Double): Double
}

interface Multijugador {
    fun unirJugador(nombre: String)
    fun expulsarJugador(nombre: String)
    fun listarJugadores()
}

abstract class JuegoBase(val titulo: String, val precision: Double) : Videojuego {

    var enCurso: Boolean = false

    override fun iniciar() {
        enCurso = true
        println(" El juego '$titulo' ha comenzado.")
    }

    override fun pausar() {
        if (enCurso) {
            println(" El juego '$titulo' está en pausa.")
            enCurso = false
        } else {
            println(" El juego '$titulo' no está en curso.")
        }
    }

    override fun terminar() {
        if (enCurso) {
            println(" El juego '$titulo' ha terminado.")
            enCurso = false
        } else {
            println(" El juego '$titulo' ya estaba detenido.")
        }
    }
}

class JuegoAccion(titulo: String, precision: Double, val jugador: String) :JuegoBase(titulo, precision) {

    override fun calcularPuntuacion(tiempo: Int, precision: Double): Double {
        return tiempo * precision * 1.5
    }

    fun mostrarJugador() {
        println("Jugador activo: $jugador")
    }
}

class JuegoEstrategia(titulo: String, precision: Double) : JuegoBase(titulo, precision), Multijugador {

    private val jugadores = mutableListOf<String>()

    override fun unirJugador(nombre: String) {
        jugadores.add(nombre)
        println("Jugador '$nombre' se ha unido a '$titulo'.")
    }

    override fun expulsarJugador(nombre: String) {
        if (jugadores.remove(nombre)) {
            println("Jugador '$nombre' ha sido expulsado de '$titulo'.")
        } else {
            println("No se encontró al jugador '$nombre' en '$titulo'.")
        }
    }

    override fun listarJugadores() {
        println("Jugadores en '$titulo': ${if (jugadores.isEmpty()) "Ninguno" else jugadores.joinToString(", ")}")
    }

    override fun calcularPuntuacion(tiempo: Int, precision: Double): Double {
        val numJugadores = if (jugadores.isEmpty()) 1 else jugadores.size
        return tiempo * precision * numJugadores
    }
}

fun main() {

    val accion = JuegoAccion("Fortinait", precision = 0.85, jugador = "Remi")
    val estrategia = JuegoEstrategia("GTA DAMdreas", precision = 0.90)

    println("===== JUEGO DE ACCIÓN =====")
    accion.iniciar()
    accion.mostrarJugador()
    println("Puntuación: ${accion.calcularPuntuacion(300, accion.precision)}")
    accion.terminar()
    println()

    println("===== JUEGO DE ESTRATEGIA =====")
    estrategia.iniciar()
    estrategia.unirJugador("Remi")
    estrategia.unirJugador("Jorge")
    estrategia.unirJugador("Diego")
    estrategia.listarJugadores()
    println("Puntuación: ${estrategia.calcularPuntuacion(300, estrategia.precision)}")
    estrategia.expulsarJugador("Diego")
    estrategia.listarJugadores()
    estrategia.terminar()

}
