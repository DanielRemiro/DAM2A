// Archivo: Main.java
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Definimos las rutas de los archivos
        String archivoEntrada = "entrada.csv";
        String archivoSalida = "salida.csv";

        // 2. Creamos una instancia del gestor
        GestorCSV gestor = new GestorCSV();

        // 3. Llamamos al primer método para LEER y obtener la lista
        System.out.println("Leyendo datos de " + archivoEntrada + "...");
        List<Producto> productosLeidos = gestor.leerProductosDeCSV(archivoEntrada);

        // Verificación (opcional)
        System.out.println("Se han leído " + productosLeidos.size() + " productos.");

        // 4. Si la lista no está vacía, llamamos al segundo método para ESCRIBIR
        if (productosLeidos != null && !productosLeidos.isEmpty()) {
            System.out.println("Escribiendo datos en " + archivoSalida + "...");
            gestor.escribirProductosEnCSV(productosLeidos, archivoSalida);
        } else {
            System.out.println("No se leyeron datos o hubo un error, no se generará el archivo de salida.");
        }
    }
}