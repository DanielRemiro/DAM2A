package ficherotexto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author dremi
 */

public class FicheroTextoClase {
    
    public void escribirFicheroTexto(String nombre, boolean anadir, String texto) {
        
        try (FileWriter fw = new FileWriter(nombre, anadir)) {
            
            fw.write(texto);
            
        } catch (IOException ex) {
            
            System.out.println("Error al escribir el fichero.");
            
            ex.printStackTrace();
            
        }
        
    }

    public void leerFichero(String nombre) {
        
        int caracter;
        
        try (FileReader fr = new FileReader(nombre)) {
            
            while ((caracter = fr.read()) != -1) {
                
                System.out.print((char)caracter);
                
            }
            
        } catch(FileNotFoundException e){
            
            System.out.println("Error");
            
        }catch (IOException ex) {
            
            System.out.println("Error al leer el fichero.");
            
            ex.printStackTrace();
            
        }
       
    }
    
    public void escribirFicheroPrintWriter(String nombreFichero,boolean anadir){
        
        try {
            
            FileWriter f=new FileWriter(nombreFichero,anadir);
            PrintWriter p=new PrintWriter(f);
            //pw=newPrintWriter(new FileWriter(nombreFichero,anadir));
            
            p.println("Ejemplo de PrintWriter");
            
            p.println(4.55);
            
            for(int i=1;i<11;i++){
                
                p.print(i+" ");
                
            }
            
            p.close();
            
        } catch(FileNotFoundException e){
            
            System.out.println("Error, no hay archivo");
            
        }catch (IOException ex) {
            
            System.out.println("Error IOException");
            
        }

    }
    
    public void leerFicheroScanner(String nombreArchivo) {
        
        try {
            
            Scanner scanner = new Scanner(new FileReader(nombreArchivo));
            
            int suma=0;
            
            while (scanner.hasNextLine()) {
                
                System.out.println(scanner.nextLine());
                
            }
            
            scanner.close();
            
            scanner = new Scanner(new FileReader(nombreArchivo));
            
            while (scanner.hasNext()) {
                
                if (scanner.hasNextInt()) {
                    
                    suma += scanner.nextInt();
                    
                } else {
                    
                    scanner.next(); 
                    
                }
                
            }
            
            scanner.close();
            
            System.out.println(suma);
            
        } catch (FileNotFoundException e) {
            
            System.out.println("Error, archivo no encontrado.");
            
        }
        
    }

}
