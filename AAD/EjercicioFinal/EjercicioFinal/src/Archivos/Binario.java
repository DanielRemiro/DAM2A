package Archivos;

import Interfaces.GuardarInformacion;

import java.io.*;

public class Binario implements GuardarInformacion {

    @Override
    public void leer() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            List<T> lista = (List<T>) ois.readObject();
            System.out.println("Datos leídos correctamente de " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

    }

    @Override
    public void escribir() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(lista);
            System.out.println("Datos guardados correctamente en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

    }
}
