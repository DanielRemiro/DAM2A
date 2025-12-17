
//1.6 Elimina un directorio y determina si se ha eliminado o no (sólo se puede eliminar un directorio si esta vacío)

import java.io.File;

public class Ejercicio1_6 {

    public static void main(String[] args) {

        File f=new File("carpeta1");

        if(f.exists()){

            f.delete();

            System.out.println("Carpeta eliminada");

        }else {

            System.out.println("La carpeta no existe.");

        }

    }

}
