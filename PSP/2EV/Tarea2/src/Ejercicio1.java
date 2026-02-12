import java.io.*;
import java.net.*;

public class Ejercicio1 {
    public static void main(String[] args) {

        final int PUERTO = 5000;

        try {
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado. Esperando cliente...");

            Socket socketCliente = servidor.accept();
            System.out.println("Cliente conectado.");

            DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());
            DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());

            String mensajeParaCliente = "Mensaje desde el servidor.";
            salida.writeUTF(mensajeParaCliente);
            System.out.println("Mensaje enviado al cliente: " + mensajeParaCliente);

            String mensajeDevuelto = entrada.readUTF();
            System.out.println("El cliente me devolvió: " + mensajeDevuelto);

            socketCliente.close();
            servidor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}