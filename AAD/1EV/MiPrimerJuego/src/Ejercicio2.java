/*2. Utiliza el objeto Runtime para obtener información del equipo donde se
ejecuta el programa. Muestra la información acerca del número de
procesadores disponibles.
*/

public class Ejercicio2 {

    public static void main(String[] args) {
        // 1. Obtener la instancia única del objeto Runtime
        Runtime runtime = Runtime.getRuntime();

        // 2. Usar el metodo para obtener el número de procesadores disponibles
        int numberOfProcessors = runtime.availableProcessors();

        // 3. Mostrar la información por pantalla de forma clara
        System.out.println("-> Obteniendo información del sistema...");
        System.out.println("----------------------------------------");
        System.out.println("Número de procesadores disponibles: " + numberOfProcessors);
        System.out.println("----------------------------------------");
    }
}