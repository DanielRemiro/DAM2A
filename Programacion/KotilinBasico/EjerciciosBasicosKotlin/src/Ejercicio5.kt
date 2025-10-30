//Crea una función que calcule el valor del parámetro perdido
// correspondiente a la ley de Ohm.  Ley de ohm
//- Enviaremos a la función 2 de los 3 parámetros (V, R, I),
// y retornará el valor del tercero (redondeado a 2 decimales).
// - Si los parámetros son incorrectos o insuficientes,
// la función retornará la cadena de texto "Valores inválidos"


fun main(){//Faltaria de determinar si hay mas de uno nulo, pero solo es listar las tres variables y ver si son nulo

    var v:Double?=10.0
    var r:Double?=20.0
    var i:Double?=null

    if(i==null){

        i=v!!/r!!

    }
    if(v==null){

        v=i!!*r!!

    }
    if(r==null){

        r=v!!/i!!

    }

    println("v=$v, r=$r, i=$i")

}
