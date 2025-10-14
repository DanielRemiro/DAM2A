package ejercicio09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class AlternarFicheros {

    
    void imprimirLineas(String fichero1,String fichero2){
      
        try(Scanner sc1=new Scanner(new File(fichero1));
        Scanner sc2=new Scanner(new File(fichero2))){
        
            while(sc1.hasNextLine()||sc2.hasNextLine()){
            
                if(sc1.hasNextLine()){
            
                    System.out.println(sc1.nextLine());
                
                }
            
                if(sc2.hasNextLine()){
            
                    System.out.println(sc2.nextLine());
            
                }
            
            }
        
            sc1.close();
            sc2.close();
        
        }catch(FileNotFoundException e){
            
            System.out.println("Error, no existe el archivo");
            
        }
        
    }
    
}