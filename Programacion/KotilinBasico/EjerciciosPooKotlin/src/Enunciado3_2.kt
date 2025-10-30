// Enum para tipos de usuario
enum class TipoUsuario {
    ADMINISTRADOR, MODERADOR, USUARIO
}

// Clase Usuario
class Usuario private constructor(
    val id: Int,
    val nombre: String,
    val email: String,
    val tipo: TipoUsuario
) {
    companion object {
        private var contadorId = 1

        // Metodo de creación de usuario con validación
        fun autenticar(nombre: String, email: String, tipo: TipoUsuario): ResultadoAutenticacion {
            println("Cargando información...")

            return if (!validarEmail(email)) {
                ResultadoAutenticacion.Error("Email inválido. Solo se permiten correos @gmail.com")
            } else if (!validarNombreUsuario(nombre)) {
                ResultadoAutenticacion.Error("Nombre de usuario inválido. Debe tener 3-20 caracteres y solo alfanuméricos o _")
            } else {
                val usuario = Usuario(contadorId++, nombre, email, tipo)
                ResultadoAutenticacion.Exito(usuario)
            }
        }

        // Validador de correo
        private fun validarEmail(email: String): Boolean {
            return email.endsWith("@gmail.com")
        }

        // Validador de nombre de usuario
        private fun validarNombreUsuario(nombre: String): Boolean {
            val regex = "^[a-zA-Z0-9_]{3,20}$".toRegex()
            return nombre.matches(regex)
        }
    }
}

// Resultado de autenticación
sealed class ResultadoAutenticacion {
    class Exito(val usuario: Usuario) : ResultadoAutenticacion()
    class Error(val mensaje: String) : ResultadoAutenticacion()
    object Cargando : ResultadoAutenticacion()
}

// Singleton Administrador de sesión
object AdministradorSesion {
    private var usuarioActual: Usuario? = null

    fun logear(usuario: Usuario) {
        usuarioActual = usuario
        println("Usuario ${usuario.nombre} ha iniciado sesión correctamente.")
    }

    fun cerrarSesion() {
        if (usuarioActual != null) {
            println("Cerrando sesión del usuario ${usuarioActual!!.nombre}...")
            usuarioActual = null
        } else {
            println("No hay usuario logueado actualmente.")
        }
    }

    fun obtenerUsuarioActual() {
        if (usuarioActual != null) {
            println("Usuario actual logueado: ${usuarioActual!!.nombre}")
        } else {
            println("No hay usuario logueado actualmente.")
        }
    }
}

// Programa principal para probar
fun main() {
    // Intento de autenticación válido
    val resultado1 = Usuario.autenticar("Remi_123", "remi@gmail.com", TipoUsuario.USUARIO)
    when (resultado1) {
        is ResultadoAutenticacion.Exito -> AdministradorSesion.logear(resultado1.usuario)
        is ResultadoAutenticacion.Error -> println("Error: ${resultado1.mensaje}")
        ResultadoAutenticacion.Cargando -> println("Cargando información..")
    }

    // Intento de autenticación con email invalido
    val resultado2 = Usuario.autenticar("UserX", "user@hotmail.com", TipoUsuario.MODERADOR)
    when (resultado2) {
        is ResultadoAutenticacion.Exito -> AdministradorSesion.logear(resultado2.usuario)
        is ResultadoAutenticacion.Error -> println("Error: ${resultado2.mensaje}")
        ResultadoAutenticacion.Cargando -> println("Cargando información..")
    }

    // Intento de autenticación con nombre invalido
    val resultado3 = Usuario.autenticar("ab", "user2@gmail.com", TipoUsuario.ADMINISTRADOR)
    when (resultado3) {
        is ResultadoAutenticacion.Exito -> AdministradorSesion.logear(resultado3.usuario)
        is ResultadoAutenticacion.Error -> println("Error: ${resultado3.mensaje}")
        ResultadoAutenticacion.Cargando -> println("Cargando información..")
    }

    // Mostrar usuario actual
    AdministradorSesion.obtenerUsuarioActual()

    // Cerrar sesión
    AdministradorSesion.cerrarSesion()
    AdministradorSesion.obtenerUsuarioActual()
}
