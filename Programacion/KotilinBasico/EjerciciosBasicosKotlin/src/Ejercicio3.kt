//Crea un programa que invierta el orden de una cadena de texto
// sin usar funciones propias del lenguaje que lo hagan de forma automática.
//Ejemplo :  Si le pasamos "Viva Kotlin" nos retornaría "niltoK aviV"

fun main(){

    var cadenaTexto:String="Daniel Remiro"

    for (i in cadenaTexto.length-1 downTo 0){

        print(cadenaTexto[i])

    }

}
