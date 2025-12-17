/*2. Utilizando ProcessBuilder, realiza un programa en Java que admite como
parámetro de entrada el comando a ejecutar en la consola del sistema
operativo y muestre en pantalla el resultado. (Not all the command might
work)*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ejercicio2_2 {

    public static void main(String[] args) {
        // 1. Validar que se ha proporcionado un comando
        if (args.length == 0) {
            System.out.println("Error: Debes proporcionar un comando a ejecutar.");
            System.out.println("Ejemplo (Windows): java CommandExecutor ipconfig");
            System.out.println("Ejemplo (Linux):   java CommandExecutor ls -l");
            return;
        }

        System.out.println("Ejecutando comando: " + String.join(" ", args));
        System.out.println("-------------------------------------------------");

        try {
            // 2. Crear una instancia de ProcessBuilder con los argumentos recibidos
            ProcessBuilder pb = new ProcessBuilder(args);

            pb.redirectErrorStream(true);

            // 3. Iniciar el proceso
            Process process = pb.start();

            // 4. Leer y mostrar la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // 5. Esperar a que el proceso termine y mostrar el código de salida
            int exitCode = process.waitFor();
            System.out.println("-------------------------------------------------");
            System.out.println("El comando finalizó con código de salida: " + exitCode);
            if (exitCode != 0) {
                System.out.println("(Un código de salida distinto de 0 usualmente indica un error)");
            }

        } catch (IOException e) {
            System.err.println("Error al ejecutar el comando. ¿Estás seguro de que el comando '" + args[0] + "' existe?");
        } catch (InterruptedException e) {
            System.err.println("El proceso fue interrumpido.");
            Thread.currentThread().interrupt();
        }
    }
}