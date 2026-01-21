/*Lo más normal es que tu ordenador de clase tenga una interfaz de red cableada. Si no,
podría tener una interfaz de red inalámbrica. En cualquier caso, escribe un programa
que obtenga la dirección de broadcast para la red local en la que está esa interfaz.
Esto puede ser útil para algunos programas para UDP que se crearán después. Verifica
la información de todos los NetworkInterface que se pueden obtener con un método
estático de esta misma clase visto con anterioridad. Debe seleccionarse una interfaz para
la que exista una dirección IP para una red local, para lo que se puede utilizar el método
isSiteLocalAddress.*/

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Main_4 {

    public static void main(String[] args) {
        System.out.println("BUSCANDO DIRECCIÓN DE BROADCAST PARA RED LOCAL \n");

        try {

            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            if (interfaces == null) {
                System.out.println("No se encontraron interfaces de red.");
                return;
            }

            boolean encontrado = false;

            for (NetworkInterface networkInterface : Collections.list(interfaces)) {

                if (!networkInterface.isUp() || networkInterface.isLoopback()) {
                    continue;
                }

                List<InterfaceAddress> interfaceAddresses = networkInterface.getInterfaceAddresses();

                for (InterfaceAddress ia : interfaceAddresses) {
                    InetAddress address = ia.getAddress();

                    if (address.isSiteLocalAddress()) {

                        InetAddress broadcast = ia.getBroadcast();

                        if (broadcast != null) {
                            System.out.println("¡INTERFAZ ENCONTRADA!");
                            System.out.println(" Nombre Interfaz:    " + networkInterface.getDisplayName());
                            System.out.println(" Tu IP Local:        " + address.getHostAddress());
                            System.out.println(" DIRECCIÓN BROADCAST: " + broadcast.getHostAddress());
                            System.out.println("--------------------------------------------------");

                            encontrado = true;
                        }
                    }
                }
            }

            if (!encontrado) {
                System.out.println("No se encontro ninguna interfaz activa con dirección de red local .");
                System.out.println("Asegurate de estar conectado a una red Wi-Fi o Ethernet.");
            }

        } catch (SocketException e) {
            System.err.println("Error al acceder a las interfaces de red: " + e.getMessage());
        }
    }
}