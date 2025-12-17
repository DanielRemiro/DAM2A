/*1. Modificar el ejercicio 1 para utilizar ProcessBuilder y que guarde el
resultado en un archivo txt. Necesitarás utilizar el metodo redirectOutput.*/


import java.io.File;
import java.io.IOException;

public class Ejercicio2_1 {

    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();
        String command;
        String outputFileName = "ip_result.txt";

        // 1. Determinar el comando según el sistema operativo
        if (os.contains("win")) {
            command = "ipconfig";
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            command = "ip"; // Para ProcessBuilder, es mejor separar comando y argumento
        } else {
            System.out.println("Sistema operativo no compatible.");
            return;
        }

        System.out.println("-> Ejecutando el comando para " + System.getProperty("os.name") + "...");
        System.out.println("-> El resultado se guardará en el archivo: " + outputFileName);

        try {
            // 2. Crear una instancia de ProcessBuilder
            ProcessBuilder processBuilder;
            if (os.contains("linux") || os.contains("nix")) {
                // En Linux, "ip addr" son dos partes: el comando y su argumento
                processBuilder = new ProcessBuilder("ip", "addr");
            } else {
                // En Windows, "ipconfig" es un solo comando
                processBuilder = new ProcessBuilder(command);
            }


            // 3. Redirigir la salida estándar del proceso al archivo especificado
            File outputFile = new File(outputFileName);
            processBuilder.redirectOutput(outputFile);

            // Opcional: Redirigir también la salida de error al mismo archivo
            // processBuilder.redirectErrorStream(true);

            // 4. Iniciar el proceso
            Process process = processBuilder.start();

            // 5. Esperar a que el proceso termine
            // Esto es importante para asegurar que el archivo se ha escrito completamente
            int exitCode = process.waitFor();

            System.out.println("-------------------------------------------------");
            if (exitCode == 0) {
                System.out.println("¡Exito! La información de la red ha sido guardada en '" + outputFile.getAbsolutePath() + "'.");
            } else {
                System.out.println(" El comando finalizo con un código de error: " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Ocurrio un error al ejecutar el proceso:");
            e.printStackTrace();
        }
    }
}