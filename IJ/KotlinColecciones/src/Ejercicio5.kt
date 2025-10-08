//Crea un MutableSet llamado ConjuntoClase con 4 nombres de compañeros
//Imprime su tamaño.
//Agrega a “Blanca”.
//Agrega a “Lucía” otra vez (nombre repetido).
//Imprime el tamaño de nuevo.
//Quita a Diego.
//Comprueba si “Esmeralda” está en el conjunto.
// Imprime el conjunto y los resultados de tamaño y existencia.

fun main(){

    val ConjuntoClase=mutableSetOf("Diego","Jorge","Oscar","Lucia")
    println("El tamaño de la lista es: ${ConjuntoClase.size}")

    ConjuntoClase.add("Blanca")
    ConjuntoClase.add("Lucia")

    println("El tamaño de la nueva lista es: ${ConjuntoClase.size}")

    ConjuntoClase.remove("Diego")

    println("La lista contiene a Esmeralda: ${ConjuntoClase.contains("Esmeralda")}")
    println(ConjuntoClase)
    println("El tamaño de la lista es: ${ConjuntoClase.size}")

}