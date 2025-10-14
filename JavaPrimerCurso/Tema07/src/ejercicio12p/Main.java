package ejercicio12p;

/**
 *
 * @author dremi
 */

import java.util.Scanner;

public class Main {
    
    public static void main(String args[]){
       
        Scanner teclado = new Scanner(System.in);
        int numeroElegido;
        
        GestionBiblioteca b = new GestionBiblioteca();
        
        b.inicializarMateriales();
        b.inicializarUsuarios();
        
        do{
            
            Menu.Menu();
        
            System.out.print("");
            numeroElegido= teclado.nextInt();
            
            switch(numeroElegido){
                
                case 1:
                    
                    b.altaMaterial();
                    break;
                    
                case 2:
                    
                    b.bajaMaterial();
                    break;
                    
                case 3: 
                    
                    b.altaUsuario();
                    break;
                    
                case 4:
                    
                    b.prestarMaterial();
                    break;
                    
                case 5:
                    
                    break;
                    
                default:
                    
                    System.out.println("Elige un numero correcto.");
                    break;
                
            }
            
        }while(numeroElegido!=5);
        
        System.out.println("Has salido correctamente.");
        
    }
    
}
