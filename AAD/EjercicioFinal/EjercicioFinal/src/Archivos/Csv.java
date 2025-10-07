package Archivos;

import Interfaces.GuardarInformacion;
import Objetos.Alumno;
import Objetos.Asignatura;
import Objetos.Matricula;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Csv implements GuardarInformacion {

    @Override
    public void leer() {

        leerAlumno(nombreArchivo);
        leerAsignatura(nombreArchivo);
        leerMatricula(nombreArchivo);

    }

    public static List<Alumno> leerAlumno(String archivo) {
        List<Alumno> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(Alumno.fromCSV(linea));
            }
        } catch (IOException e) {
            System.out.println("Error al leer CSV: " + e.getMessage());
        }
        return lista;
    }

    public static List<Asignatura> leerAsignatura(String archivo) {
        List<Asignatura> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(Asignatura.fromCSV(linea));
            }
        } catch (IOException e) {
            System.out.println("Error al leer CSV: " + e.getMessage());
        }
        return lista;
    }

    public static List<Matricula> leerMatricula(String archivo) {
        List<Matricula> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(Matricula.fromCSV(linea));
            }
        } catch (Exception e) {
            System.out.println("Error al leer CSV: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void escribir() {

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (T item : lista) {
                pw.println(item.toString());
            }
            System.out.println("Datos guardados en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al escribir CSV: " + e.getMessage());
        }

    }

}
