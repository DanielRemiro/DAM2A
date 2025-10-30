
fun main(){

    println("adoro kotlin")

    var nombre : String="Maria"
    val apellido : String="Perez"

    nombre="Mario"

    val edad:Int=15

    println(nombre)

    println ("Su edad es ${edad+10}")

    //null safety

    var apellido2:String?=null

    println("Longitud de tu apellido es "+ (apellido2?.length ?:0))

    val oper1:Int=5
    val oper2:Int=7

    println("La suma es ${suma(oper1,oper2)}")


}

fun suma(a:Int,b:Int):Int{

    return a+b

}