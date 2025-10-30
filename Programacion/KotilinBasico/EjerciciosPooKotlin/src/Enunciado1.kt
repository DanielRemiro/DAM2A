//Crea una clase Vehículo con propiedades marca y año.
// Haz una subclase Coche que añada modelo. Crea una lista de coches y muéstralos.

open class Vehiculo (val marca: String, val anno: Int)

class Coche(marca: String, anno: Int, val modelo: String) :Vehiculo(marca, anno)

fun main(){

    val coches = mutableListOf<Coche>()
    coches.add(Coche("Toyota",2005,"Corola"))
    coches.add(Coche("Porsche",2025,"GT3 RS"))
    coches.add(Coche("Ford",2000,"Fiesta"))

    for(coche in coches){

        println("Marca: ${coche.marca} , modelo: ${coche.modelo} y año: ${coche.anno}")

    }

}