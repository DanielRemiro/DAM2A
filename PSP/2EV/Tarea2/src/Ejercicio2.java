import java.io.*;
import java.net.*;

public class  Ejercicio2 {
    public static void main(String[] args) {
        final int PUERTO = 6000;

        int numeroDeClientes = 3;

        try {
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor listo para atender a " + numeroDeClientes + " clientes.");

            for (int i = 1; i <= numeroDeClientes; i++) {

                System.out.println("Esperando al cliente número " + i + "...");
                Socket socketCliente = servidor.accept();

                DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());

                salida.writeUTF("Eres el cliente número " + i);

                socketCliente.close();
            }

            System.out.println("Se ha atendido a los " + numeroDeClientes + " clientes. Servidor finalizado.");
            servidor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}