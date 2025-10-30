// Archivo: GestionProductos.java
import java.io.*;
import java.util.ArrayList;

public class GestionProductos {

    /**
     * Escribe una lista de productos en un archivo binario.
     * @param listaProductos La lista de productos a guardar.
     * @param nombreArchivo El nombre del archivo .dat donde se guardará la lista.
     */
    public static void escribirProductos(ArrayList<Producto> listaProductos, String nombreArchivo) {
        try (FileOutputStream fos = new FileOutputStream(nombreArchivo);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(listaProductos); // Escribimos el ArrayList completo en el archivo
            System.out.println("Archivo '" + nombreArchivo + "' guardado correctamente.");

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Lee una lista de productos desde un archivo binario.
     * @param nombreArchivo El nombre del archivo .dat desde donde se leerá la lista.
     * @return Un ArrayList con los productos leídos o un ArrayList vacío si ocurre un error.
     */
    public static ArrayList<Producto> leerProductos(String nombreArchivo) {
        ArrayList<Producto> listaProductos = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(nombreArchivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            listaProductos = (ArrayList<Producto>) ois.readObject(); // Leemos el ArrayList completo
            System.out.println("Archivo '" + nombreArchivo + "' leído correctamente.");

        } catch (FileNotFoundException e) {
            System.err.println("Error: El archivo '" + nombreArchivo + "' no fue encontrado.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return listaProductos;
    }
}