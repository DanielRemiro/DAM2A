package ejercicio11p;

import java.io.*;
import java.util.ArrayList;

public class Gestion {

    ArrayList<Alumno> lista = new ArrayList<>();

    public void anadirLista() {
        
        Alumno a = new Alumno("Daniel", true, 1, 8.15f);
        Alumno a2 = new Alumno("Ana", false, 3, 4f);
        Alumno a3 = new Alumno("Alex", true, 2, 0f);
        
        lista.add(a);
        lista.add(a2);
        lista.add(a3);
        
    }

    public void escribirDatosB() {
        
        File archivo = new File("alumno.dat");
        
        boolean existe = archivo.exists();

        try {
            
            FileOutputStream fos = new FileOutputStream(archivo, true);
            
            ObjectOutputStream oos;

            if (existe) {
                
                oos = new MiObjectOutputStream(fos); 
                
            } else {
                
                oos = new ObjectOutputStream(fos); 
                
            }

            for (Alumno al : lista) {
                
                oos.writeObject(al);
                
            }

            oos.close();
            fos.close();

            System.out.println("Datos añadidos al archivo.");

        } catch (IOException e) {
            
            System.out.println("Error");
            
        }
        
    }

    public void leerDatos() {
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("alumno.dat"))) {
            
            while (true) {
                
                Alumno a = (Alumno) ois.readObject();
                
                System.out.println(a.toString());
                
            }
            
        } catch (EOFException e) {
            
            System.out.println("Fin del archivo.");
            
        } catch (IOException | ClassNotFoundException e) {
            
            System.out.println("Error");
            
        }
        
    }
    
}
