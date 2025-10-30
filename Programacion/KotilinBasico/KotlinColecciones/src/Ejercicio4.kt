fun main() {
    val grupo = mutableListOf("Oscar", "Jhon", "Agustin")

    grupo.add("Francisco")
    grupo.add("Blanca")

    grupo.add(1, "María Isabel")

    grupo[3] = "Félix"

    grupo.remove("Jorge")

    if ("Ad" in grupo) {
        println("Ad está en la lista.")
    } else {
        println("Ad no está en la lista.")
    }

    println(grupo)
}
