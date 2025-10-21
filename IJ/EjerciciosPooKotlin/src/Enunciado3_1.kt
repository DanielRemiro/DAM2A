// Clase Producto con ID secuencial
class Producto(var nombre: String, var precio: Double) {
    val id: Int

    companion object {
        private var contadorId = 1
    }

    init {
        id = contadorId
        contadorId++
    }

    override fun toString(): String {
        return "ID: $id, Nombre: $nombre, Precio: $precio"
    }
}

// Sealed class para operaciones de inventario
sealed class OperacionInventario {
    data class Agregar(val producto: Producto) : OperacionInventario()
    data class Eliminar(val id: Int) : OperacionInventario()
    data class Actualizar(val id: Int, val nuevoNombre: String, val nuevoPrecio: Double) : OperacionInventario()
}

// Gestor de inventario
object GestorInventario {
    private val productos = mutableMapOf<Int, Producto>()

    fun ejecutarOperacion(operacion: OperacionInventario) {
        when (operacion) {
            is OperacionInventario.Agregar -> {
                productos[operacion.producto.id] = operacion.producto
                println("Producto agregado: ${operacion.producto}")
            }

            is OperacionInventario.Eliminar -> {
                val eliminado = productos.remove(operacion.id)
                if (eliminado != null) {
                    println("Producto eliminado: $eliminado")
                } else {
                    println("No se encontro el producto con ID: ${operacion.id}")
                }
            }

            is OperacionInventario.Actualizar -> {
                val producto = productos[operacion.id]
                if (producto != null) {
                    producto.nombre = operacion.nuevoNombre
                    producto.precio = operacion.nuevoPrecio
                    println("Producto actualizado: $producto")
                } else {
                    println("No se encontró el producto con ID: ${operacion.id}")
                }
            }
        }
    }

    fun mostrarProductos() {
        if (productos.isEmpty()) {
            println("El inventario está vacío.")
        } else {
            println("Productos actuales en el inventario:")
            productos.values.forEach { println(it) }
        }
    }
}

// Programa principal para probar
fun main() {
    val laptop = Producto("Laptop", 1200.50)
    val mouse = Producto("Mouse", 25.99)
    val teclado = Producto("Teclado", 45.00)

    GestorInventario.ejecutarOperacion(OperacionInventario.Agregar(laptop))
    GestorInventario.ejecutarOperacion(OperacionInventario.Agregar(mouse))
    GestorInventario.ejecutarOperacion(OperacionInventario.Agregar(teclado))

    GestorInventario.mostrarProductos()

    // Actualizar producto
    GestorInventario.ejecutarOperacion(OperacionInventario.Actualizar(mouse.id, "Mouse Gaming", 35.99))

    // Eliminar producto
    GestorInventario.ejecutarOperacion(OperacionInventario.Eliminar(teclado.id))

    // Mostrar productos después de las operaciones
    GestorInventario.mostrarProductos()
}
