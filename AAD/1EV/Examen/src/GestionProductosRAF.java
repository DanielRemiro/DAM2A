// Archivo: GestionProductosRAF.java
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class GestionProductosRAF {

    // Constantes para definir el tamaño del registro
    public static final int MAX_LONGITUD_NOMBRE = 20; // Máximo 20 caracteres para el nombre
    private static final int TAMANO_REGISTRO = 4 + (MAX_LONGITUD_NOMBRE * 2) + 8; // int (4) + String (20*2) + double (8)

    /**
     * Escribe una lista de productos en un archivo de acceso aleatorio.
     * @param listaProductos La lista de productos a guardar.
     * @param nombreArchivo El nombre del archivo .dat.
     */
    public static void escribirProductos(ArrayList<Producto> listaProductos, String nombreArchivo) {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "rw")) {
            for (int i = 0; i < listaProductos.size(); i++) {
                // Nos posicionamos en el lugar correcto del archivo para escribir el registro
                raf.seek((long) i * TAMANO_REGISTRO);

                Producto p = listaProductos.get(i);

                // 1. Escribir ID (int)
                raf.writeInt(p.getId());

                // 2. Escribir Nombre (String de tamaño fijo)
                StringBuffer sb = new StringBuffer(p.getNombre());
                sb.setLength(MAX_LONGITUD_NOMBRE); // Asegura una longitud fija
                raf.writeChars(sb.toString());

                // 3. Escribir Precio (double)
                raf.writeDouble(p.getPrecio());
            }
            System.out.println("Archivo '" + nombreArchivo + "' guardado correctamente con RAF.");

        } catch (IOException e) {
            System.err.println("Error de E/S al escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Lee una lista de productos desde un archivo de acceso aleatorio.
     * @param nombreArchivo El nombre del archivo .dat.
     * @return Un ArrayList con los productos leídos.
     */
    public static ArrayList<Producto> leerProductos(String nombreArchivo) {
        ArrayList<Producto> listaProductos = new ArrayList<>();

        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "r")) {
            long numRegistros = raf.length() / TAMANO_REGISTRO;

            for (int i = 0; i < numRegistros; i++) {
                // Nos posicionamos al inicio del registro a leer
                raf.seek((long) i * TAMANO_REGISTRO);

                // 1. Leer ID
                int id = raf.readInt();

                // 2. Leer Nombre
                char[] nombreChars = new char[MAX_LONGITUD_NOMBRE];
                for (int j = 0; j < MAX_LONGITUD_NOMBRE; j++) {
                    nombreChars[j] = raf.readChar();
                }
                // Convertir el array de chars a String y eliminar caracteres nulos de relleno
                String nombre = new String(nombreChars).trim();

                // 3. Leer Precio
                double precio = raf.readDouble();

                // Añadir el producto reconstruido a la lista
                listaProductos.add(new Producto(id, nombre, precio));
            }
            System.out.println("Archivo '" + nombreArchivo + "' leído correctamente con RAF.");

        } catch (IOException e) {
            System.err.println("Error de E/S al leer el archivo: " + e.getMessage());
        }

        return listaProductos;
    }
}