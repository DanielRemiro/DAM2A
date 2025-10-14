package mainp;

import gestorp.GestorFlota;
import java.util.Scanner;
import menup.Menu;



public class Main {

        public static void main(String[] args) {
            
            GestorFlota gf =new GestorFlota();
            Scanner teclado=new Scanner(System.in);
            int eleccion;
            
            do{
                
                Menu.Menu();
                System.out.println("--> ");
                eleccion=teclado.nextInt();
                teclado.nextLine();
                
                switch(eleccion){
                    
                    case 1 -> gf.anadirCoche();
                    
                    case 2 -> gf.pedirViaje();
                        
                    case 3 -> System.out.println("Hola");
                    
                    default -> System.out.println("No has elegido un numero correcto.");
                    
                }
                
            }while(eleccion<4&&eleccion>0);
                
        }

}
