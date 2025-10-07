import java.io.File;
import java.io.IOException;

//1.3 Crea un fichero y determina si se ha creado o si ya existía.

public class Ejercicio1_3 {

    public static void main(String[] args) {

        File f=new File("fichero.txt");
        try {

            if(f.createNewFile()){

                System.out.println("File creado.");

            }else {
                System.out.println("File ya estaba creado.");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
