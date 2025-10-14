package ejercicio14p;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class LeerArchivo {
    
    private String lineaAux;
    private String datosDivididos[]=new String[9];
    private double altitud,latitud;
    private final double radioTierra=6750;
    
    
    public void obtenerDatos(double altitudUsuario,double latitudUsuario,double distanciaMaxima){

        try {
            
            BufferedReader br =new BufferedReader(new FileReader("datos_abiertos_aparcabicis.txt"));
            
            
            while((lineaAux=br.readLine())!=null){
                
                datosDivididos=lineaAux.split(",");
                datosDivididos[7].replaceAll("\"","");
                datosDivididos[7].replaceAll("\\[","");
                datosDivididos[8].replaceAll("\"","");
                datosDivididos[8].replaceAll("\\]","");
                
                altitud=Double.parseDouble(datosDivididos[7]);
                latitud=Double.parseDouble(datosDivididos[8]);
                
            }
            
            
        } catch (FileNotFoundException ex) {
            
            System.out.println("Error, no existe el archivo.");
            
        }catch(IOException io){
            
            System.out.println("Error");
            
        }
        
    }
    
    public boolean comprobarDistancia(double altitudUsuario, double latitudUsuario, double distanciaMaxima,double altitudPuesta, double latitudPuesta) {
    
    // Convertir la diferencia de latitud a kilómetros (1 grado ≈ 111 km)
        double diferenciaLatitud = (latitudPuesta - latitudUsuario) * 111.0;

    // Calcular la diferencia de altitud en km (asumimos que viene en metros)
        double diferenciaAltitud = (altitudPuesta - altitudUsuario) / 1000.0;

    // Aplicar el teorema de Pitágoras
        double distancia = Math.sqrt(Math.pow(diferenciaLatitud, 2) + Math.pow(diferenciaAltitud, 2));

    // Comprobar si la distancia es válida
        return distancia <= distanciaMaxima;
        
    }
    
}
