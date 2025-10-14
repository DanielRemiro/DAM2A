package ejercicio18p;

/**
 *
 * @author dremi
 */

import java.util.Scanner;

public class Persona extends Mamifero {
    
    private String profesion;
    
    void insertarDatosPersona() {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Ingrese la profesion: ");
        profesion = teclado.nextLine();
        
    }
    
    void visualizarDatosPersona() {
        
        System.out.println("Profesión: " + profesion);
        
        visualizarDatosMamif();
        
    }

    public String getProfesion() {
        
        return profesion;
        
    }

    public void setProfesion(String profesion) {
        
        this.profesion = profesion;
        
    }
    
}

