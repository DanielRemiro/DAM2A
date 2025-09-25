//Crea un programa se encargue de transformar un número decimal
// a binario sin utilizar funciones propias del lenguaje


fun main(){

    val numeroDecimal:Int=20

    if (numeroDecimal == 0) {

        println("El número en binario es: 0")

    } else {

        var numero = numeroDecimal
        var binario = ""

        while (numero > 0) {
            val residuo = numero % 2
            binario = "$residuo$binario"
            numero /= 2
        }

        println("El número en binario es: $binario")

    }
}
