import java.io.File;

//1.5 Elimina un fichero y determina si se ha eliminado o no

public class Ejercicio1_5 {

    public static void main(String[] args) {

        File f=new File("fichero.txt");

        if(f.exists()){

            f.delete();

            System.out.println("Fichero eliminado");

        }else{

            System.out.println("Fichero no encontrado");

        }

    }

}
