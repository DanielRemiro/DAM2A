class Habitacion(val id:String ,val numero:Int, val tipo:tipoHabitacion, val precioPorNoche:Double,diasReserva:Int){
    fun comprobarbarDiasReserva(diasReserva:Int){
        this.diasReserva=diasReserva
        if(diasReserva<=0){
            println("Los días de reserva no pueden ser negativos ni cero")
        }
    }
}
enum class tipoHabitacion {
    INDIVIDUAL, DOBLE, SUITE
}
