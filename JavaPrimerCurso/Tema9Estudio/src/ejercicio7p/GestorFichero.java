package ejercicio7p;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class GestorFichero {
    
    public void leerArchivo(String nombreArchivo,String palabra){
        
        String lineaAux;
        
        try {
            
            File f=new File(nombreArchivo);
            
            File f2=new File("ejemplo1.txt");
            
            Scanner sc=new Scanner(f);
            
            BufferedWriter bw=new BufferedWriter(new FileWriter(f2));
            
            while(sc.hasNextLine()){
                
                lineaAux=sc.nextLine();
                lineaAux=lineaAux.replaceAll("\\b"+palabra+"\\b","");
                
                bw.write(lineaAux);
                bw.newLine();
                
            }
            
            bw.close();
            
            sc.close();
            
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(GestorFichero.class.getName()).log(Level.SEVERE, null, ex);
            
        }catch(IOException exio){
            
            System.out.println("Error");
            
        }
        
    }

}
