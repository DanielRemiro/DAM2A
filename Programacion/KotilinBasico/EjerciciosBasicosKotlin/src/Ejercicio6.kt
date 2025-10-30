//Escribe una programa, que pasando como parámetro una frase , encuentre:
//La primera posición de una letra dada
//La primera posición de una palabra dada
//Busque si una palabra se encuentra o no en la frase

fun main() {

    val frase = "El atelico de madrid va a ganar la liga esta temporada"

    val letra = 'o'
    val palabra = "esta"
    val palabraBuscada = "temporada"

    val posLetra = frase.indexOf(letra)

    if (posLetra != -1) {

        println("La letra '$letra' se encuentra en la posición: $posLetra")

    } else {

        println("La letra '$letra' no se encuentra en la frase")

    }

    val posPalabra = frase.indexOf(palabra)

    if (posPalabra != -1) {

        println("La palabra '$palabra' comienza en la posición: $posPalabra")

    } else {

        println("La palabra '$palabra' no se encuentra en la frase")

    }

    if (frase.contains(palabraBuscada)) {

        println("La palabra '$palabraBuscada' se encuentra en la frase")

    } else {

        println("La palabra '$palabraBuscada' NO se encuentra en la frase")

    }

}
