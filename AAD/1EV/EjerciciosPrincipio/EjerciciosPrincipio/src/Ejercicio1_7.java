
//1.7 Dado un directorio muestra el nombre de todos los archivos que contenga, o si está vacío

import java.io.File;

public class Ejercicio1_7 {

    public static void main(String[] args) {

        File f=new File("carpeta1");

        if(f.isDirectory()){

            for(String s:f.list()){

                System.out.println(s);

            }

        }else{

            System.out.printf("Carpeta no valida.");

        }

    }

}
