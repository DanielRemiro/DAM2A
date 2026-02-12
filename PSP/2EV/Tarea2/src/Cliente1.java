import java.io.*;
import java.net.*;

public class Cliente1 {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PUERTO = 5000;

        try {
            System.out.println("Iniciando cliente...");
            Socket socket = new Socket(HOST, PUERTO);

            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

            String mensajeRecibido = entrada.readUTF();
            System.out.println("Mensaje recibido del servidor: " + mensajeRecibido);

            salida.writeUTF(mensajeRecibido);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}