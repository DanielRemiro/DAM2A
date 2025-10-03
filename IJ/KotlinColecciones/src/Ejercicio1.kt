fun main() {
    // Array con 4 nombres de compañeros
    val DAM2 = arrayOf("Jorge", "Diego", "JD", "Tomas")

    // Array con otros 4 nombres de compañeros
    val dosDAM = arrayOf("Agustin", "Jhon", "Oscar", "Adrian")

    // Unir ambos arrays en uno nuevo
    val claseCompleta = DAM2 + dosDAM  // operador '+' une arrays

    // Imprimir todos los nombres uno por uno usando los índices
    for (i in claseCompleta.indices) {
        println(claseCompleta[i])
    }
}
