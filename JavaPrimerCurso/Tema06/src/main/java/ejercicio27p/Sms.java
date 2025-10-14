package ejercicio27p;

/**
 *
 * @author dremi
 */

import java.util.Scanner;

public class Sms implements Funciones{
    
    Movil movil= new Movil();
    
    @Override
    public void interfaz(){
        
        
        System.out.println("Mensajes");
        System.out.println("________");
        System.out.println("Numeros de telefono");
        System.out.println("___________________");
        
        movil.verNumeros();
        
        System.out.println("_________");
        System.out.println("(Numero negativo para salir)");
        
        elegir();
        
    }
    
    @Override
    public void elegir(){
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("");
        int numero = teclado.nextInt();
        System.out.println("");
        
        if(numero<0){
            
            movil.interfaz();
            
        }
        
        movil.verNumeroExacto(numero);
        
        System.out.println("________________________________");
            
        System.out.println("Escribir mensaje(0 para salir): ");
            escribir();
            
    }
    
    @Override
    public void escribir(){
        
        Scanner teclado = new Scanner(System.in);
        
        String mensaje=teclado.nextLine();
        
        if (mensaje.equals("0")) {
            
            interfaz();
            
        } else {
            
            System.out.println("Mensaje enviado: " + mensaje);
            System.out.println("Escribe un mensaje");
            
            escribir();
        }
        
        
    }
    
}