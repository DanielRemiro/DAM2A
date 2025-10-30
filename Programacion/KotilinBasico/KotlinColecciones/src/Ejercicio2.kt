fun main() {
    val DAM2 = arrayOf("Jorge", "Diego", "JD", "Tomas")
    val dosDAM = arrayOf("Agustin", "Jhon", "Oscar", "Adrian")

    val claseCompleta = DAM2 + dosDAM

    val claseMutable = claseCompleta.toMutableList()

    // Cambiar el nombre en el índice 3
    claseMutable[3] = "Nacho"

    // Imprimir el nombre en la posición 3
    println(claseMutable[3])  // Nacho
}
