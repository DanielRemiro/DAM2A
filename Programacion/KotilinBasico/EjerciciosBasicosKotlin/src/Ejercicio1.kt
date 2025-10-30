//Escribe un programa que muestre por consola (con un print) los números
// de 1 a 100 sustituyendo los diferentes números por las siguientes cadenas:
// - Múltiplos de 3 por la palabra "hacker".
// - Múltiplos de 5 por la palabra "matter".
// - Múltiplos de 3 y de 5 a la vez por la palabra "hacker-matter".

fun main(){

    for(i in 1..100){

        if(i%3==0&&i%5==0){

            println("hacker-matter")

        }else if(i%3==0){

            println("hacker")

        }else if(i%5==0){

            println("matter")

        }else{

            println(i)

        }

    }

}