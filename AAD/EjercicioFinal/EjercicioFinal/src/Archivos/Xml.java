package Archivos;

import Interfaces.GuardarInformacion;
import java.io.*;
import java.util.Scanner;

public class Xml implements GuardarInformacion {

    private Scanner sc = new Scanner(System.in);

    @Override
    public void leer() {
        String archivo = elegirArchivo();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea); // aquí podrías convertirla a objeto si quisieras
            }
            System.out.println("Lectura del XML completada.");
        } catch (IOException e) {
            System.out.println("Error al leer XML: " + e.getMessage());
        }
    }

    @Override
    public void escribir(Object obj) {
        String archivo = elegirArchivo();

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) { // true para append opcional
            pw.println("<objeto>");
            pw.println(obj.toString()); // guarda la representación del objeto
            pw.println("</objeto>");
            System.out.println("Datos guardados correctamente en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al escribir XML: " + e.getMessage());
        }
    }

    public String elegirArchivo() {
        System.out.println("Ingrese el nombre del archivo XML:");
        return sc.nextLine();
    }
}
