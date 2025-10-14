package Archivos;

import Interfaces.GuardarInformacion;
import Objetos.Alumno;
import Objetos.Asignatura;
import Objetos.Matricula;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Csv implements GuardarInformacion {

    private Scanner sc = new Scanner(System.in);
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void leer() {
        String archivo = elegirArchivo();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            System.out.println("Lectura del CSV completada.");
        } catch (IOException e) {
            System.out.println("Error al leer CSV: " + e.getMessage());
        }
    }

    @Override
    public void escribir(Object obj) {
        String archivo = elegirArchivo();

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {

            if (obj instanceof Alumno a) {
                pw.println(a.getId() + "," + a.getNombre() + "," + a.getEmail());

            } else if (obj instanceof Asignatura as) {
                pw.println(as.getId() + "," + as.getNombre() + "," + as.getCreditos());

            } else if (obj instanceof Matricula m) {
                pw.println(m.getIdAlumno() + "," + m.getIdAsignatura() + "," +
                        sdf.format(m.getFecha()) + "," + m.getNota());

            } else {
                System.out.println("Tipo de objeto no reconocido para CSV.");
                return;
            }

            System.out.println("Datos guardados correctamente en " + archivo);

        } catch (IOException e) {
            System.out.println("Error al escribir CSV: " + e.getMessage());
        }
    }

    public String elegirArchivo() {
        System.out.print("Ingrese el nombre del archivo CSV (ej. datos.csv): ");
        return sc.nextLine();
    }
}
