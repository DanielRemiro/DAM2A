package ejercicio04p;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CalcularCantidad {

    public static int contarPalabrasConBuffer(String rutaArchivo) {
        
        int cantidadPalabras = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            
            String linea;
            
            while ((linea = br.readLine()) != null) {
               
                String[] palabras = linea.split("\\s+");
                cantidadPalabras += palabras.length;
                
            }
            
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }
        
        return cantidadPalabras;
        
    }

}
