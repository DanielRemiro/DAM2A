package ejercicio6p;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class GestorFichero {
    
    public void leerArchivo(String nombreArchivo,String palabra){
        
        int contador=0;
        
        try {
            
            File f=new File(nombreArchivo);
            
            Scanner sc=new Scanner(f);
            
            while(sc.hasNext()){
                
                if(sc.next().equalsIgnoreCase(palabra)){
                    
                    contador++;
                    
                }
                
            }
            
            sc.close();
            
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(GestorFichero.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally{
            
            System.out.println("La cantidad de palabras es: "+contador);
            
        }
        
        
    }

}
