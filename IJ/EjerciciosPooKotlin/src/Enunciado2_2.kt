/*Modela el sistema de una biblioteca utilizando clases anidadas. Una biblioteca es un conjunto (lista) de libros.
 La biblioteca creada deberá tener un nombre. Los libros pertenecen a la biblioteca y de ellos se quiere guardar el autor
 y el isbn (clase interna). Esta clase deberá tener un metodo que devuelva la siguiente información: <Titulo del libro>
 escrito por autor <autor>.
Existe también una clase interna Estadísticas que realiza las siguiente acciones:
Devuelve el número total de libros de la biblioteca
Devuelve un conjunto con los autores sin que se repita ninguno. Hay que tener en cuenta que un autor puede escribir
varios libros y esta información puede estar repetida.
En la biblioteca se podrán añadir más libros, buscar por un autor determinado y obtener las estadísticas anteriormente mencionadas

Finalmente crea una función principal en la que crees la biblioteca, añadas tres libros (con título y autor),
muestres todas las posibles estadísticas y busques por un autor determinado.
*/

class Biblioteca(val nombre: String) {

    private val libros = mutableListOf<Libro>()

    // Clase interna Libro
    inner class Libro(val titulo: String, val autor: String, val isbn: String) {
        fun obtenerInfo(): String {
            return "$titulo escrito por autor $autor"
        }
    }

    // Clase interna Estadisticas
    inner class Estadisticas {
        fun numeroTotalLibros(): Int {
            return libros.size
        }

        fun autoresUnicos(): Set<String> {
            return libros.map { it.autor }.toSet()
        }
    }

    // Añadir un libro a la biblioteca
    fun anadirLibro(titulo: String, autor: String, isbn: String) {
        libros.add(Libro(titulo, autor, isbn))
    }

    // Buscar libros por autor
    fun buscarPorAutor(autor: String): List<Libro> {
        return libros.filter { it.autor.equals(autor, ignoreCase = true) }
    }

    // Obtener estadísticas
    fun obtenerEstadisticas(): Estadisticas {
        return Estadisticas()
    }

    // Mostrar todos los libros
    fun mostrarLibros() {
        if (libros.isEmpty()) {
            println("No hay libros en la biblioteca $nombre")
        } else {
            println("Libros en la biblioteca $nombre:")
            libros.forEach { println(it.obtenerInfo()) }
        }
    }
}

// Función principal
fun main() {
    val biblioteca = Biblioteca("Biblioteca Central")

    // Añadir tres libros
    biblioteca.anadirLibro("Cien Años de Soledad", "Gabriel García Márquez", "12345")
    biblioteca.anadirLibro("1984", "George Orwell", "67890")
    biblioteca.anadirLibro("El Amor en los Tiempos del Cólera", "Gabriel García Márquez", "54321")

    // Mostrar todos los libros
    biblioteca.mostrarLibros()

    // Obtener estadísticas
    val estadisticas = biblioteca.obtenerEstadisticas()
    println("\nNúmero total de libros: ${estadisticas.numeroTotalLibros()}")
    println("Autores únicos: ${estadisticas.autoresUnicos()}")

    // Buscar libros por autor
    val autorBuscado = "Gabriel García Márquez"
    val librosAutor = biblioteca.buscarPorAutor(autorBuscado)
    println("\nLibros escritos por $autorBuscado:")
    librosAutor.forEach { println(it.obtenerInfo()) }
}
