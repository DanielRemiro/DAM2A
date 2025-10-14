package Archivos;

import Interfaces.GuardarInformacion;
import java.io.*;
import java.util.Scanner;

public class Binario implements GuardarInformacion {

    private Scanner sc = new Scanner(System.in);

    @Override
    public void leer() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(elegirArchivo()))) {
            while (true) {
                try {
                    Object obj = ois.readObject();

                    if (obj != null) {
                        System.out.println(obj.getClass().getSimpleName() + ": " + obj);
                    }

                } catch (EOFException e) {
                    break; // fin de archivo
                }
            }
            System.out.println("Todos los objetos leídos correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

    }

    @Override
    public void escribir(Object obj) {

        String archivo = elegirArchivo();
        boolean append = new File(archivo).exists();

        try (ObjectOutputStream oos = append
                ? new AppendableObjectOutputStream(new FileOutputStream(archivo, true))
                : new ObjectOutputStream(new FileOutputStream(archivo))) {

            oos.writeObject(obj);
            System.out.println("Objeto guardado correctamente en " + archivo);

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public String elegirArchivo() {
        System.out.print("Ingrese el nombre del archivo (ej. datos.bin): ");
        return sc.nextLine();
    }

    /**
     * Clase interna para evitar escribir cabeceras duplicadas
     * cuando se hace append a un ObjectOutputStream existente.
     */
    private static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            // No escribir cabecera para evitar corrupción del archivo
            reset();
        }
    }
}
