package ejercicio27p;

/**
 *
 * @author dremi
 */

import java.util.Scanner;

public class Email implements Funciones{
    
    Movil movil= new Movil();
    
    @Override
    public void interfaz(){
        
        
        System.out.println(" Correo electronico ");
        System.out.println("|__________________|");
        System.out.println(" Principal ");
        System.out.println("-----------");
        
        movil.verCorreo();
        
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
        
        movil.verCorreoExacto(numero);
        
        System.out.println("_____________________");
            
        System.out.println("Escribir correo(0 para salir): ");
        escribir();
            
    }
    
    @Override
    public void escribir(){
        
        Scanner teclado = new Scanner(System.in);
        
        String mensaje=teclado.nextLine();
        
        if (mensaje.equals("0")) {
            
        } else {
            
            System.out.println("Correo enviado: " + mensaje);
            
            interfaz();
            
        }
        
    }
    
}