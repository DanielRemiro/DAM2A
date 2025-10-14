package ejercicio18p;

/**
 *
 * @author dremi
 */

import java.util.Scanner;

public class Mamifero extends Animal {
    
    private int numeroHuesos;
    private int numeroExtremidades;

    void insertarDatosMamif() {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Ingrese el numero de crias: ");
        setNumeroCrias(teclado.nextInt());
        
        System.out.print("Ingrese el numero de huesos: ");
        numeroHuesos = teclado.nextInt();
        
        System.out.print("Ingrese el numero de extremidades: ");
        numeroExtremidades = teclado.nextInt();
    }
    
    void visualizarDatosMamif() {
        
        System.out.println("Numero de crias: " + getNumeroCrias());
        System.out.println("La cantidad de huesos que tiene es: " + numeroHuesos);
        System.out.println("El numero de extremidades es: " + numeroExtremidades);
    }
}
