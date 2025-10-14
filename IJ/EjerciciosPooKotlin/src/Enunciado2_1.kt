abstract class SistemaNotificaciones {

    abstract fun enviarMensaje(mensaje: String)
    abstract fun tipo(): String

    fun obtenerInfoMensaje(mensaje: String): String {
        return "Mensaje: \"$mensaje\", Longitud: ${mensaje.length} caracteres"
    }
}

class NotificacionEmail(private val emisor: String, private val receptor: String) : SistemaNotificaciones() {

    private val longitudMaxima = 1500

    override fun enviarMensaje(mensaje: String) {
        if (mensaje.length > longitudMaxima) {
            println("Error: El mensaje excede los $longitudMaxima caracteres.")
        } else {
            println("Enviando correo de $emisor a $receptor con el mensaje: $mensaje")
        }
    }

    override fun tipo() = "Correo electrónico"
}

class NotificacionWhatsapp(private val numeroDestino: String) : SistemaNotificaciones() {

    private val longitudMaxima = 600

    override fun enviarMensaje(mensaje: String) {
        if (mensaje.length > longitudMaxima) {
            println("Error: El mensaje excede los $longitudMaxima caracteres.")
        } else {
            println("Enviando WhatsApp al $numeroDestino con el mensaje: $mensaje")
        }
    }

    override fun tipo() = "WhatsApp"
}

fun main() {
    // Creamos la cola de notificaciones
    val colaNotificaciones = mutableListOf<Pair<SistemaNotificaciones, String>>()

    // Agregamos notificaciones junto con su mensaje
    colaNotificaciones.add(NotificacionEmail("remi@gmail.com", "usuario@correo.com") to "Hola, este es un correo.")
    colaNotificaciones.add(NotificacionWhatsapp("+34123456789") to "Hola, este es un WhatsApp.")
    colaNotificaciones.add(NotificacionEmail("info@empresa.com", "cliente@correo.com") to "Mensaje de prueba para correo.")
    colaNotificaciones.add(NotificacionWhatsapp("+34987654321") to "Otro mensaje de WhatsApp.")

    // Enviar todas las notificaciones
    println("=== Enviando todas las notificaciones ===")
    for ((notificacion, mensaje) in colaNotificaciones) {
        notificacion.enviarMensaje(mensaje)
    }

    // Contar tipos de notificaciones
    val conteo = colaNotificaciones.groupingBy { it.first.tipo() }.eachCount()
    println("\n=== Conteo de notificaciones ===")
    for ((tipo, cantidad) in conteo) {
        println("$cantidad notificación(es) de $tipo")
    }
}
