package Archivos;

import Interfaces.GuardarInformacion;
import java.io.*;
import java.util.Scanner;

public class Binario implements GuardarInformacion {

    private Scanner sc=new Scanner(System.in);

    @Override
    public void leer(){

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(elegirArchivo()))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    System.out.println(obj);
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("Todos los objetos leídos correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

    }

    @Override
    public void escribir(Object obj){

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(elegirArchivo()))) {
            oos.writeObject(obj);
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

    }

    public String elegirArchivo(){

        System.out.println("Ingrese el nombre del archivo: ");
        String archivo=sc.nextLine();

        return archivo;
    }

}
