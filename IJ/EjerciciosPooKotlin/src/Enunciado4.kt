//Modela un sistema de bibliotecas, en la que se pueden prestar , devolver y saber el estado del
// préstamo de cada uno de los ítems que se encuentran en ella. Solo existen dos tipos de ítems
// susceptibles de ser prestados: Libros y revistas. Los libros constan de título, autor e isbn.
// De las revistas se registra el título y la fecha en que fueron publicadas.
//Crea una lista con varios libros y revistas. Si el ítem se presta se debe eliminar de la lista.
// En cambio, si se devuelve se deben incluir de nuevo en ella.
//Recorre la lista de los siguiente modos:
//Que únicamente saque los libros que se encuentran en ella.
//Que únicamente muestre las revistas de la lista.
//Que únicamente muestre los ítems que han sido prestados , ya sean libros y/o revistas.

interface Prestable {
    fun prestar(listaStock: MutableList<Prestable>, listaPrestados: MutableList<Prestable>)
    fun devolver(listaStock: MutableList<Prestable>, listaPrestados: MutableList<Prestable>)
    fun revisarEstado()
}

class Libro(val titulo: String, val autor: String, val isbn: Int, var estaPrestado: Boolean = false) : Prestable {

    override fun prestar(listaStock: MutableList<Prestable>, listaPrestados: MutableList<Prestable>) {
        if (!estaPrestado) {
            estaPrestado = true
            listaStock.remove(this)
            listaPrestados.add(this)
            println("El libro '$titulo' ha sido prestado.")
        } else {
            println("⚠El libro '$titulo' ya está prestado.")
        }
    }

    override fun devolver(listaStock: MutableList<Prestable>, listaPrestados: MutableList<Prestable>) {
        if (estaPrestado) {
            estaPrestado = false
            listaPrestados.remove(this)
            listaStock.add(this)
            println("El libro '$titulo' ha sido devuelto.")
        } else {
            println("El libro '$titulo' no estaba prestado.")
        }
    }

    override fun revisarEstado() {
        val estado = if (estaPrestado) "prestado" else "disponible"
        println("Libro: '$titulo' → Estado: $estado")
    }

    override fun toString(): String {
        return "Libro(título='$titulo', autor='$autor', isbn=$isbn, prestado=$estaPrestado)"
    }
}

class Revista(val titulo: String, val fechaPublicacion: Int, var estaPrestado: Boolean = false) : Prestable {

    override fun prestar(listaStock: MutableList<Prestable>, listaPrestados: MutableList<Prestable>) {
        if (!estaPrestado) {
            estaPrestado = true
            listaStock.remove(this)
            listaPrestados.add(this)
            println("La revista '$titulo' ha sido prestada.")
        } else {
            println("La revista '$titulo' ya está prestada.")
        }
    }

    override fun devolver(listaStock: MutableList<Prestable>, listaPrestados: MutableList<Prestable>) {
        if (estaPrestado) {
            estaPrestado = false
            listaPrestados.remove(this)
            listaStock.add(this)
            println("La revista '$titulo' ha sido devuelta.")
        } else {
            println("La revista '$titulo' no estaba prestada.")
        }
    }

    override fun revisarEstado() {
        val estado = if (estaPrestado) "prestada" else "disponible"
        println("Revista: '$titulo' → Estado: $estado")
    }

    override fun toString(): String {
        return "Revista(título='$titulo', fecha=$fechaPublicacion, prestada=$estaPrestado)"
    }
}

fun main() {

    val stock = mutableListOf<Prestable>(
        Libro("1984", "George Orwell", 12345),
        Libro("El Quijote", "Cervantes", 67890),
        Revista("National Geographic", 2024),
        Revista("TIME", 2025)
    )

    val listaPrestados = mutableListOf<Prestable>()

    val menu = Menu()
    var eleccion: Int

    do {
        menu.mostrar()
        eleccion = readLine()?.toIntOrNull() ?: -1

        when (eleccion) {
            1 -> {
                println("Introduce el título a prestar:")
                println(stock)
                val titulo = readLine()?.trim()
                val item = stock.find {
                    (it is Libro && it.titulo.equals(titulo, true)) ||
                            (it is Revista && it.titulo.equals(titulo, true))
                }
                if (item != null) item.prestar(stock, listaPrestados)
                else println("No se encontró el ítem en stock.")
            }

            2 -> {
                println("Introduce el título a devolver: ")
                println(listaPrestados)
                val titulo = readLine()?.trim()
                val item = listaPrestados.find {
                    (it is Libro && it.titulo.equals(titulo, true)) ||
                            (it is Revista && it.titulo.equals(titulo, true))
                }
                if (item != null) item.devolver(stock, listaPrestados)
                else println("No se encontró el ítem prestado.")
            }

            3 -> {
                println("Libros disponibles: ")
                stock.filterIsInstance<Libro>().forEach { it.revisarEstado() }
                println("\n Revistas disponibles:")
                stock.filterIsInstance<Revista>().forEach { it.revisarEstado() }
                println("\n Ítems prestados:")
                listaPrestados.forEach { it.revisarEstado() }
            }

            0 -> println("Has salido correctamente.")
            else -> println("Opción no válida.")
        }

        println()
    } while (eleccion != 0)
}

// --- CLASE MENÚ ---
class Menu {
    fun mostrar() {
        println("1. Prestar ítem")
        println("2. Devolver ítem")
        println("3. Revisar estado")
        println("0. Salir")
        print("Elige una opción: ")
    }
}
