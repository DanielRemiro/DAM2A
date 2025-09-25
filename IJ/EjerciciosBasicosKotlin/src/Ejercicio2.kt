//Escribe un programa que se encargue de comprobar si un número es o no primo.
//Una vez hecho imprime los números primos entre 1 y 100.

fun esPrimo(numero: Int): Boolean {

    var esPrimo = true

    if (numero <= 1) {

        esPrimo = false

    } else {

        for (i in 2..numero / 2) {

            if (numero % i == 0) {

                esPrimo = false

            }

        }

    }


    return esPrimo

}

fun main() {

    for (i in 1..100) {

        if (esPrimo(i)) {

            println(i)

        }

    }

}

