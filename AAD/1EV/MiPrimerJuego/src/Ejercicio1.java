/*1. Realiza un programa en Java que ejecute el comando correspondiente con
el sistema operativo donde se esté ejecutando (Windows o Linux), muestre
la dirección IP a través de la consola y muestre su resultado por pantalla.
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {

    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();
        String command;

        // Determinar el sistema operativo y asignar el comando adecuado
        if (os.contains("win")) {
            command = "ipconfig";//Windows
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            command = "ip addr"; // Comando para sistemas Linux/Unix
        } else {
            System.out.println("Sistema operativo no compatible.");
            return; // Termina el programa si el SO no es Windows o Linux
        }

        System.out.println("-> Ejecutando el comando '" + command + "' para " + System.getProperty("os.name") + "...");
        System.out.println("-------------------------------------------------");

        try {
            // 2. Ejecutar el comando en el sistema
            Process process = Runtime.getRuntime().exec(command);

            // 3. Leer la salida del comando ejecutado
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea;

            // 4. Imprimir cada línea de la salida en la consola
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            // Es una buena práctica esperar a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("-------------------------------------------------");
            System.out.println("-> El comando finalizo con código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            System.err.println("Error al ejecutar comando:");
            e.printStackTrace();
        }
    }
}