package pruebafileclase;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author dremi
 */

public class PruebaFileClase {
    
    public static void main(String args[]){
        
        File f = new File("nueva_carpeta");
        
        String rutaArchivo="src/pruebafileclase/PruebaFileClase.java";
                
        String rutaCarpeta="src/pruebafileclase";
        
        //mostrarCaracFichero(rutaArchivo);
        
        //System.out.println("");
        
        //mostrarCaracCarpeta(rutaCarpeta);
        
        //crearArchivo("nuevo_archivo.txt");
        
        //crearCarpeta("nueva_carpeta");
        
        //borrarAoD("nueva_carpeta");
        
        //listarArchivos(f);
        
    }
    
    private static void mostrarCaracFichero(String rutaArchivo){
        
        File fichero=new File(rutaArchivo);
        
        if(fichero.exists()){
            
            System.out.println("El archivo existe.");
            
        }else{
            
            System.out.println("El archivo NO existe.");
            
        }
        
        System.out.println("Nombre: "+fichero.getName()+".");
        System.out.println("Tamano: "+fichero.length()+" bytes.");
        System.out.println("Ruta: "+fichero.getAbsolutePath()+".");
        
    }
    
    private static void mostrarCaracCarpeta(String rutaCarpeta){
        
        File carpeta=new File(rutaCarpeta);
        
        if(carpeta.exists()){
            
            System.out.println("La carpeta existe.");
            
        }else{
            
            System.out.println("La carpeta NO existe.");
            
        }
        
        System.out.println("Nombre: "+carpeta.getName()+".");
        System.out.println("Tamano: "+carpeta.length()+" bytes.");
        System.out.println("Ruta: "+carpeta.getAbsolutePath()+".");
        
    }
    
    private static void crearArchivo(String nombreArchivo){
        
        File f = new File(nombreArchivo);
        
        try {
            
            if(f.createNewFile()){
                
                System.out.println("Archivo creado.");
                
            }else{
                
                System.out.println("No creado, el archivo YA existe.");
                
            }
            
        } catch (IOException ex) {
            
            System.out.println("Error:");
            ex.printStackTrace();
            
        }
        
    }
    
    private static void crearCarpeta(String nombreCarpeta){
        
        File f = new File(nombreCarpeta);
      
            if(f.mkdir()){
                
                System.out.println("Directorio creado.");
                
            }else{
                
                System.out.println("No creado, el directorio YA existe.");
                
            }
            
    }
    
    private static void borrarAoD(String carpetaOdirectorio){
        
        File borrar = new File(carpetaOdirectorio);
        
        if(borrar.delete()){
            
            System.out.println("Borrado correcto.");
            
        }else{
            
            System.out.println("No se ha podido borrar.");
            
        }
        
        
    }
    
    private static void listarArchivos(File carpeta){
        
        if(carpeta.isDirectory()){
            
            File arrayFile[]=carpeta.listFiles();
            
            for(File f:arrayFile){
                
                if(f.isFile()){
                    
                    System.out.println("Archivo: "+f.getName());
                    
                }else if(f.isDirectory()){
                    
                    System.out.println("Carpeta: "+f.getName());
                    listarArchivos(f);
                    
                }
                
            }
            
        }else{
            
            System.out.println("No es una carpeta.");
            
        }
        
    }
    
}
