import java.io.File;

//1.4 Crea una carpeta y determina si se ha creado o si ya existía.

public class Ejercicio1_4 {

    public static void main(String[] args) {

        File f=new File("carpeta1");

        if(f.mkdir()){

            System.out.printf("Carpeta creada");

        }else {
            System.out.printf("Carpeta ya estaba creada");
        }

    }

}
