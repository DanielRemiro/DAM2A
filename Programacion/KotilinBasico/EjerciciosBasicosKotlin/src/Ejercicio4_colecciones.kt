fun main() {
    // Crear lista mutable con 3 nombres
    val grupo = mutableListOf("Oscar", "Jhon", "Agustin")

    // Agregar Francisco y Blanca al final
    grupo.add("Francisco")
    grupo.add("Blanca")

    // Insertar María Isabel en la posición 2 (índice 1 → segundo lugar, índice 2 → tercer lugar)
    grupo.add(1, "María Isabel")

    // Cambiar el nombre en el índice 3 por Félix
    grupo[3] = "Félix"

    // Quitar el nombre Jorge
    grupo.remove("Jorge")

    // Comprobar si "Ad" está en la lista
    if ("Ad" in grupo) {
        println("Ad está en la lista.")
    } else {
        println("Ad no está en la lista.")
    }

    // Mostrar la lista resultante
    println(grupo)
}
