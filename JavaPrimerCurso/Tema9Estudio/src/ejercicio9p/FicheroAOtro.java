package ejercicio9p;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class FicheroAOtro {

    public void leerFicheros(String fichero1,String fichero2){
        
        try {
            File f1=new File(fichero1);
            Scanner sc1=new Scanner(f1);
            
            File f2=new File(fichero2);
            Scanner sc2=new Scanner(f2);
            
            BufferedWriter bw=new BufferedWriter(new FileWriter("juntos.txt"));
            
            while(sc1.hasNextLine()||sc2.hasNextLine()){
                
                if(sc1.hasNextLine()){
                    
                    bw.write(sc1.nextLine());
                    
                }
                
                if(sc2.hasNextLine()){
                    
                    bw.write(sc2.nextLine());
                    
                }
                
            }
            
            sc1.close();
            sc2.close();
            bw.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheroAOtro.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ioex){
            
            System.out.println("Error");
            
        }
        
    }
    
    
}
