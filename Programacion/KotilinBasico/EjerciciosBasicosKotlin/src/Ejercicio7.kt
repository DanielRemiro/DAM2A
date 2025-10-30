//Desarrolla un programa que realice los siguiente, dada una edad:
//Si la edad es menor que 18 muestre por pantalla “Eres menor de edad”
//Si la edad es igual a 18: “Ya eres mayor de edad!”
//Si la edad es mayor a 18: “Enhorabuena , ya puedes votar!”
//	Debes verificar que la edad introducida sea positiva o en caso contrario mostrar un mensaje de error.

fun main(){

    print("Escribe tu edad: ")
    val edad:Int =readLine()!!.toInt()
    println()

    if(edad>=0) {

        if (edad < 18) println("Eres menor de edad")
        else if (edad == 18) println("Ya eres mayor de edad!")
        else if (edad > 18) println("Enhorabuena , ya puedes votar!")

    }else{

        println("Error, edad negativa")

    }

}