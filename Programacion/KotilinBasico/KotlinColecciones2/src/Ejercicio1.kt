//Ejercicio 1.  Dada una lista de 10 enteros,
// crea una función que devuelva una lista con el doble de cada número.

fun main(){

    val lista1 = listOf(1,2,3,4,5,6,7,8,9,10)
    val lista2 = mutableListOf<Int>()
    for(i in lista1){
        lista2.add(i*2)
    }

    println(lista2)
}
