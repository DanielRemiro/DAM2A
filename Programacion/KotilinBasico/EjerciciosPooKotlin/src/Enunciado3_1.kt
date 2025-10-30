// Clase Producto con ID secuencial
class Producto(var id:Int,var nombre: String, var precio: Double) {

    companion object{

        private var id: Int=0

        fun aumentarId()= ++id

        fun crear(nombre: String, precio: Double): Producto{

            return Producto(aumentarId(),nombre, precio)
        }
    }
}

sealed class OperacionesProductos{
    data class AgregarProducto(val producto: Producto): OperacionesProductos()
    data class EliminarProducto(val id: Int): OperacionesProductos()
    data class ActualizarProducto(val producto: Producto): OperacionesProductos()
}

object Inventario{

    private val listaProductos=mutableMapOf<Int,Producto>()

    fun ejecutarOperacion(operacion: OperacionesProductos){

         when(operacion) {

            is OperacionesProductos.AgregarProducto -> {
                listaProductos[operacion.producto.id] = operacion.producto
            }
            is OperacionesProductos.EliminarProducto -> {
                listaProductos.remove(operacion.id)
            }
            is OperacionesProductos.ActualizarProducto -> {
                var p=listaProductos[operacion.id]
                p.copy(precio=operacion.precio)
            }
        }
    }


}
