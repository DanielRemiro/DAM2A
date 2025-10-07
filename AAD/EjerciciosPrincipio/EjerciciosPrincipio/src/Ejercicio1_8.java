//1.8 Lista todos los archivos de una carpeta y sus subcarpetas, con su ruta desde la ubicación actual. No deben aparecer las carpetas

import java.io.File;

public class Ejercicio1_8 {

    public static void main(String[] args) {

        String nombre="carpeta1";

        mostrarContenido(new File(nombre));

    }

    static void mostrarContenido(File carpeta){

        File[]contenido= carpeta.listFiles();

        for(File f:contenido){

            if(f.isDirectory()){

                mostrarContenido(f);

            }else{

                System.out.println(f.getName());

            }

        }

    }

}
