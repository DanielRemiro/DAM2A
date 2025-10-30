//Crea una interfaz Reproducible con una función reproducir().
// Implementa la interfaz en dos clases: Película y Canción, con comportamientos distintos.

interface Reproducible{
    fun reproducir()
}

class Pelicula():Reproducible{

    override fun reproducir(){

        println("Pelicula reproducida")

    }

}

class Cancion():Reproducible{

    override fun reproducir(){

        println("Cancion reproducida")

    }
}

fun main(){

    val pelicula= Pelicula()
    val cancion= Cancion()
    pelicula.reproducir()
    cancion.reproducir()

}