package Archivos;

import Objetos.Alumno;
import Objetos.Matricula;
import Interfaces.AlumnoRepositorio;

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Csv implements AlumnoRepositorio {

    private final Path ruta;

    public Csv(String rutaArchivo) {
        this.ruta = Paths.get(rutaArchivo);
    }

    @Override
    public List<Alumno> cargar() throws IOException {
        List<Alumno> lista = new ArrayList<>();
        if (!Files.exists(ruta)) return lista;
        try (BufferedReader br = Files.newBufferedReader(ruta)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // formato: id;nombre;email;fecha1|nota1,fecha2|nota2,...
                String[] partes = linea.split(";", -1);
                if (partes.length >= 3) {
                    Alumno a = new Alumno(partes[0], partes[1], partes[2]);
                    if (partes.length > 3 && !partes[3].isEmpty()) {
                        String[] matriculas = partes[3].split(",");
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        for (String m : matriculas) {
                            String[] datos = m.split("\\|");
                            if (datos.length == 2) {
                                Date fecha = sdf.parse(datos[0]);
                                double nota = Double.parseDouble(datos[1]);
                                a.agregarMatricula(new Matricula(fecha, nota));
                            }
                        }
                    }
                    lista.add(a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void guardar(List<Alumno> alumnos) throws IOException {
        Files.createDirectories(ruta.getParent() == null ? Paths.get(".") : ruta.getParent());
        try (BufferedWriter bw = Files.newBufferedWriter(ruta)) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (Alumno a : alumnos) {
                StringBuilder sb = new StringBuilder();
                sb.append(a.getId()).append(";")
                        .append(a.getNombre()).append(";")
                        .append(a.getEmail()).append(";");

                List<String> mats = new ArrayList<>();
                for (Matricula m : a.getMatriculas()) {
                    mats.add(sdf.format(m.getFecha()) + "|" + m.getNota());
                }
                sb.append(String.join(",", mats));
                bw.write(sb.toString());
                bw.newLine();
            }
        }
    }

    @Override
    public String getRuta() { return ruta.toString(); }
}
