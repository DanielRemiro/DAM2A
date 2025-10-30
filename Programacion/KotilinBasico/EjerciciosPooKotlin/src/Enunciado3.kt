//Modela un sistema de empleados de una empresa.
// Todos los trabajadores de la empresa realizan las acciones de trabajar y descansar durante su jornada
// laboral.
// Además se debe poder calcular el salario que perciben. Existen dos tipos de trabajadores: Gerentes ,
// cuyo retribución es el salario base + 20% por ciento, y Desarrolladores, los cuales perciben el salario
// base + 10% en su salario.

//También, todos los trabajadores pueden ser susceptibles de ser evaluados en su desempeño laboral diario.
// Modela esto último como una interfaz con un metodo que devuelva una cadena con una frase sobre
// su desempeño.
//Finalmente crea una lista de trabajadores y recórrela mostrando cada uno de los aspectos
// señalados en el enunciado.

interface Empleado {
    val salarioBase: Double
    fun trabajar()
    fun descansar()
    fun calcularSalario(): Double
}

interface Evaluable {
    fun evaluarDesempeno(): String
}

class Gerente(override val salarioBase: Double = 1000.0) : Empleado, Evaluable {

    override fun trabajar() {
        println("El gerente está organizando reuniones y tomando decisiones.")
    }

    override fun descansar() {
        println("El gerente está descansando en su despacho.")
    }

    override fun calcularSalario(): Double {
        return salarioBase * 1.20
    }

    override fun evaluarDesempeno(): String {
        return "El gerente ha mostrado una gran capacidad de liderazgo."
    }
}

class Desarrollador(override val salarioBase: Double = 1000.0) : Empleado, Evaluable {

    override fun trabajar() {
        println("El desarrollador está escribiendo código y solucionando bugs.")
    }

    override fun descansar() {
        println("El desarrollador está tomando un descanso con café.")
    }

    override fun calcularSalario(): Double {
        return salarioBase * 1.10
    }

    override fun evaluarDesempeno(): String {
        return "El desarrollador ha tenido un rendimiento sobresaliente en sus tareas."
    }
}

fun main() {
    val empleados: List<Empleado> = listOf(Gerente(), Desarrollador(), Desarrollador(), Gerente())

    for (empleado in empleados) {
        empleado.trabajar()
        empleado.descansar()
        println("Salario calculado: ${empleado.calcularSalario()}")

        if (empleado is Evaluable) {
            println(empleado.evaluarDesempeno())
        }

    }
}
