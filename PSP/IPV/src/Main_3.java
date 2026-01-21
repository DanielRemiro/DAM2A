/*Probablemente, tu ordenador está situado en una red local con direcciones privadas de tipo

C con máscara de red de 24 bits. Si es así, las direcciones son de tipo 192.168.X.Y, con

0<=X<=255 y constante para todos los hosts de la red, e Y variable con 0<=Y<=254, la

máscara de red es 255.255.255.0, y la dirección de broadcast es 192.168.X.255. Puedes

verificarlo ejecutando el comando ifconfig (en linux) o ipconfig (en Windows) y analizando la información que muestra.

Escribe un programa que permita determinar qué direcciones dentro de la red local son

alcanzables, es decir, cuáles están asignadas a una interfaz de red activa. Se puede escribir

el programa especificamente para la red particular. Es decir, no hace falta que sea genérico

y capaz de detectar automáticamente la red. Pero si hay que explicar cómo has averiguadorango de direcciones que va a probar, y escribirá después las direcciones IP alcanzables en

ese rango, utilizando el método isReachable. Si la máscara de red es de 24 bits, bastará

con un bucle para los valores del último byte para probar todas las direcciones.

Si tu ordenador no está en una red local con direcciones privadas de tipo C, seguramente

estará en una de tipo B, lo que puede complicar un poco las cosas, pero no mucho más. En

lugar de un bucle para el valor del último byte de la dirección IP, habrá que hacer un bucle

anidado para los dos últimos bytes. Si la máscara de red no es de 24 o 16 bits, la cosa se

complica bastante más.

Para crear las InetAddress se puede utilizar el método static InetAddress

getByAddress(byte[) addr) de InetAddress. Ten en cuenta que la primera dirección

del rango (bits para host todos a cero) es la dirección de la red, y que la última (bits para

host todos a uno) es la dirección de broadcast, y que ninguna de ellas corresponde

ningún host.*/

import java.io.IOException;
import java.net.InetAddress;

public class Main_3 {

    public static void main(String[] args) {

        int redByte1 = 192;
        int redByte2 = 168;
        int redByte3 = 1;

        int timeout = 100;

        System.out.println("Iniciando escaneo de la red " + redByte1 + "." + redByte2 + "." + redByte3 + ".0/24");
        System.out.println("Por favor espere, esto puede tardar unos momentos...");

        for (int i = 1; i < 255; i++) {

            try {

                byte[] ipAddr = new byte[] {
                        (byte) redByte1,
                        (byte) redByte2,
                        (byte) redByte3,
                        (byte) i
                };

                InetAddress address = InetAddress.getByAddress(ipAddr);

                if (address.isReachable(timeout)) {
                    System.out.println("Host activo: " + address.getHostAddress() + " (" + address.getHostName() + ")");
                }

            } catch (IOException e) {
                System.err.println("Error al escanear " + redByte1 + "." + redByte2 + "." + redByte3 + "." + i);
            }
        }

        System.out.println("Escaneo finalizado.");
    }
}