package Archivos;

import Interfaces.GuardarInformacion;
import Objetos.Alumno;
import Objetos.Asignatura;
import Objetos.Matricula;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Xml implements GuardarInformacion {

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
            System.out.println("Lectura del XML completada.");
        } catch (IOException e) {
            System.out.println("Error al leer XML: " + e.getMessage());
        }
    }

    @Override
    public void escribir(Object obj) {
        String archivo = elegirArchivo();
        boolean nuevoArchivo = !new File(archivo).exists();

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {

            // Si es la primera vez que se escribe, abrimos el tag raíz
            if (nuevoArchivo) pw.println("<objetos>");

            if (obj instanceof Alumno a) {
                pw.println("  <alumno>");
                pw.println("    <id>" + a.getId() + "</id>");
                pw.println("    <nombre>" + a.getNombre() + "</nombre>");
                pw.println("    <email>" + a.getEmail() + "</email>");
                pw.println("  </alumno>");

            } else if (obj instanceof Asignatura as) {
                pw.println("  <asignatura>");
                pw.println("    <id>" + as.getId() + "</id>");
                pw.println("    <nombre>" + as.getNombre() + "</nombre>");
                pw.println("    <creditos>" + as.getCreditos() + "</creditos>");
                pw.println("  </asignatura>");

            } else if (obj instanceof Matricula m) {
                pw.println("  <matricula>");
                pw.println("    <idAlumno>" + m.getIdAlumno() + "</idAlumno>");
                pw.println("    <idAsignatura>" + m.getIdAsignatura() + "</idAsignatura>");
                pw.println("    <fecha>" + sdf.format(m.getFecha()) + "</fecha>");
                pw.println("    <nota>" + m.getNota() + "</nota>");
                pw.println("  </matricula>");

            } else {
                System.out.println("Tipo de objeto no reconocido para XML.");
                return;
            }

            System.out.println("Datos guardados correctamente en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al escribir XML: " + e.getMessage());
        }
    }

    public String elegirArchivo() {
        System.out.print("Ingrese el nombre del archivo XML (ej. datos.xml): ");
        return sc.nextLine();
    }
}
