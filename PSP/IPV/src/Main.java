/*Escribe un programa que muestre información de todas las interfaces de red presentes en el sistema. No hace falta que muestre información de su configuración para IPv4 o IPv6 (es decir, direcciones
IP, máscaras de red, direcciones de broadcast, etc.). Antes de ejecutar el programa, asegúrate de que el ordenador tenga conexión
a internet, o al menos a una red local. ¿En qué cambia la salida
del programa cuando se desconecta el cable de red o se desactiva
la interfaz de red desde el sistema operativo? ¿Para qué tipos de
interfaces se muestra información? ¿Hay alguna que esté siempre
activa? ¿Cuál?*/


import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class Main {

    public static void main(String[] args) {
        try {

            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            if (interfaces == null) {
                System.out.println("No se encontraron interfaces de red.");
                return;
            }

            System.out.println("=== LISTADO DE INTERFACES DE RED DEL SISTEMA ===\n");


            for (NetworkInterface networkInterface : Collections.list(interfaces)) {

                System.out.println("Nombre (Sistema): " + networkInterface.getName());
                System.out.println("Nombre (Mostrar): " + networkInterface.getDisplayName());


                System.out.println("¿Está activa?: " + (networkInterface.isUp() ? "SÍ" : "NO"));
                System.out.println("¿Es Loopback?:      " + (networkInterface.isLoopback() ? "SÍ" : "NO"));
                System.out.println("¿Es Virtual?:       " + (networkInterface.isVirtual() ? "SÍ" : "NO"));
                System.out.println("MTU:                " + networkInterface.getMTU());


                byte[] mac = networkInterface.getHardwareAddress();
                if (mac != null) {
                    System.out.print("Dirección MAC:      ");
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                    }
                    System.out.println(sb.toString());
                } else {
                    System.out.println("Dirección MAC:      No disponible ");
                }

                System.out.println("------------------------------------------------");
            }

        } catch (SocketException e) {
            System.err.println("Error al obtener las interfaces: " + e.getMessage());
        }
    }
}