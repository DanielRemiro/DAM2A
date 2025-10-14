package pruebahashsetclase;

import java.util.HashSet;
/**
 *
 * @author alu
 */
public class PruebaTreeSetClase {

    private static HashSet<Persona> personas=new HashSet<>();
    private static Persona p0,p1,p2,p3,p4;
    
    public static void main(String[] args) {
        p0=new Persona(0, "José");
        p1=new Persona(1, "Ana");
        p2=new Persona(2, "Pepe");
        p3=new Persona(3, "María");
        
        System.out.println("Añadimos p0 " + personas.add(p0));
        System.out.println("Añadimos p1 " + personas.add(p1));
        System.out.println("Añadimos p2 " + personas.add(p2));
        System.out.println("Añadimos p3 " + personas.add(p3));
        System.out.println("Añadimos p0 " + personas.add(p0));
        
        System.out.println(personas);
        
        mostrarCabecera("Verificamos con contains si contiene el objeto p0");
        System.out.println(personas.contains(p0));
        
        p4=new Persona(1, "Ana");
        System.out.println("Añadimos p4 " + personas.add(p4));
        
    }
    
    private static void mostrarCabecera(String info){
         System.out.println("\n****************************************************************");
         System.out.println("******************************************************************");
         System.out.println(info);
     } 
}
