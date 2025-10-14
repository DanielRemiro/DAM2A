package ejercicio18p;

/**
 *
 * @author dremi
 */
import java.util.Scanner;
public class Principal {
    
    public static void main(String args[]){
        
        Scanner teclado = new Scanner(System.in);
        
        Animal animal=new Animal();
        Mamifero mamifero = new Mamifero();
        Persona persona = new Persona();
        
        System.out.println("*******************");
        System.out.println("Datos del animal");
        System.out.println("*******************");
        
        System.out.println("Escriba el numero de crias: ");
        int criasUsuario=teclado.nextInt();
        animal.setNumeroCrias(criasUsuario);
        
        System.out.println("--------------------------------------");
        
        System.out.println("*******************");
        System.out.println("Datos del mamifero");
        System.out.println("*******************");
        
        mamifero.insertarDatosMamif();
        
        System.out.println("--------------------------------------");
        
        System.out.println("*******************");
        System.out.println("Datos de la persona");
        System.out.println("*******************");
        
        persona.insertarDatosMamif();
        persona.insertarDatosPersona();
        
        System.out.println("--------------------------------------");
        
        System.out.println("*******************");
        System.out.println("DATOS GUARDADOS");
        System.out.println("*******************");
        
        System.out.println("--------------------------------------");
        
        System.out.println("*******************");
        System.out.println("Visualizar datos del animal");
        System.out.println("*******************");
        
        System.out.println("El numero de crias es: "+animal.getNumeroCrias());
        
        System.out.println("--------------------------------------");
        
        System.out.println("*******************");
        System.out.println("Visualizar datos del mamifero");
        System.out.println("*******************");
        
        mamifero.visualizarDatosMamif();
        
         System.out.println("--------------------------------------");
        
        System.out.println("*******************");
        System.out.println("Visualizar datos de la persona");
        System.out.println("*******************");
        
        persona.visualizarDatosPersona();
        
        
        
    }
    
}
