// Dada una lista de 20  enteros, crea una función que devuelva una lista con solo
// los números mayores que una cantidad que solicites como parámetro por teclado.

fun main(){

    val lista1=listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
    val lista2 = mutableListOf<Int>()
    println("Elige el numero que partir: ")
    val mayorque=readLine()!!.toInt()

    for(i in lista1){

        if(mayorque<i){

            lista2.add(i)

        }

    }

    println(lista2)

}
