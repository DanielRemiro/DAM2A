// Archivo: GestorCSV.java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorCSV {

    /**
     * Metodo 1: Lee un archivo CSV y devuelve una lista de objetos Producto.
     *
     * @param rutaArchivo La ruta del archivo CSV a leer.
     * @return Una lista (ArrayList) con los productos leídos.
     */
    public List<Producto> leerProductosDeCSV(String rutaArchivo) {
        List<Producto> listaProductos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // Omitimos la cabecera

            while ((linea = br.readLine()) != null) {
                try {
                    String[] datos = linea.split(",");
                    if (datos.length == 3) {
                        int id = Integer.parseInt(datos[0].trim());
                        String nombre = datos[1].trim();
                        double precio = Double.parseDouble(datos[2].trim());
                        listaProductos.add(new Producto(id, nombre, precio));
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("Error al procesar la línea: " + linea + " | Motivo: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de entrada: " + e.getMessage());
        }

        return listaProductos;
    }

    /**
     * Metodo 2: Escribe una lista de productos en un nuevo archivo CSV.
     *
     * @param listaProductos La lista de productos a escribir.
     * @param rutaArchivo    La ruta donde se guardará el nuevo archivo CSV.
     */
    public void escribirProductosEnCSV(List<Producto> listaProductos, String rutaArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            // Escribimos la cabecera
            bw.write("id,nombre,precio\n");

            // Recorremos la lista y escribimos cada producto
            for (Producto p : listaProductos) {
                String linea = String.format("%d,%s,%.2f", p.getId(), p.getNombre(), p.getPrecio()).replace(',', '.');
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Archivo CSV generado exitosamente en: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo de salida: " + e.getMessage());
        }
    }
}