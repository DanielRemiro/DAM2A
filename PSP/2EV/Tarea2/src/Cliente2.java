import java.io.*;
import java.net.*;

public class Cliente2 {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PUERTO = 6000;

        try {
            Socket socket = new Socket(HOST, PUERTO);
            DataInputStream entrada = new DataInputStream(socket.getInputStream());

            // El cliente simplemente lee el mensaje y lo muestra
            String mensaje = entrada.readUTF();
            System.out.println("Servidor dice: " + mensaje);

            socket.close();

        } catch (IOException e) {
            // Si el servidor ya cerró o alcanzó el límite N, dará error aquí
            System.out.println("No se pudo conectar (¿Quizás el servidor ya atendió a todos los clientes?)");
        }
    }
}
