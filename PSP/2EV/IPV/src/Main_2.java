
/*3.3.
Amplia el programa anterior para mostrar información de la configuración IP para cada
interfaz, al menos la dirección o direcciones IP, y las correspondientes máscaras de red y
direcciones de broadcast. Puedes utilizar el operador instanceof para distinguir cuándo
una dirección IP es IPv4 (clase Inet4Address) o IPvó (clase Inet6Address). */

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Main_2 {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            if (interfaces == null) {
                System.out.println("No se encontraron interfaces.");
                return;
            }

            System.out.println("=== CONFIGURACIÓN IP DE INTERFACES ===\n");

            for (NetworkInterface networkInterface : Collections.list(interfaces)) {

                System.out.println("INTERFAZ: " + networkInterface.getDisplayName() + " [" + networkInterface.getName() + "]");
                System.out.println("------------------------------------------------");

                List<InterfaceAddress> listaDirecciones = networkInterface.getInterfaceAddresses();

                if (listaDirecciones.isEmpty()) {
                    System.out.println("  (Sin configuración IP)");
                }

                for (InterfaceAddress interfaceAddress : listaDirecciones) {
                    InetAddress address = interfaceAddress.getAddress();

                    if (address instanceof Inet4Address) {
                        System.out.println("  [IPv4]");
                        System.out.println("    Dirección IP:       " + address.getHostAddress());

                        System.out.println("    Máscara (Prefijo):  /" + interfaceAddress.getNetworkPrefixLength());


                        if (interfaceAddress.getBroadcast() != null) {
                            System.out.println("    Broadcast:          " + interfaceAddress.getBroadcast().getHostAddress());
                        } else {
                            System.out.println("    Broadcast:          No aplica");
                        }

                    } else if (address instanceof Inet6Address) {
                        System.out.println("  [IPv6]");

                        System.out.println("    Dirección IP:       " + address.getHostAddress());
                        System.out.println("    Prefijo de Red:     /" + interfaceAddress.getNetworkPrefixLength());

                    }
                    System.out.println();
                }
                System.out.println("================================================\n");
            }

        } catch (SocketException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}