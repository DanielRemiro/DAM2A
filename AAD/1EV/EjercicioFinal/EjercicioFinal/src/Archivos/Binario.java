package Archivos;

import Objetos.Alumno;
import Interfaces.AlumnoRepositorio;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Binario implements AlumnoRepositorio {

    private final Path ruta;
    // Ruta del archivo binario donde se guardarán o cargarán los alumnos

    public Binario(String rutaArchivo) {
        this.ruta = Paths.get(rutaArchivo);
        // Constructor que recibe la ruta del archivo y la convierte a Path
    }

    @Override
    public List<Alumno> cargar() throws IOException, ClassNotFoundException {
        if (!Files.exists(ruta)) return new ArrayList<>();
        // Si el archivo no existe, devuelve una lista vacía

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(ruta))) {
            return (List<Alumno>) ois.readObject();
            // Lee la lista completa de alumnos desde el archivo binario
            // Incluye todas las matrículas porque Alumno y Matricula implementan Serializable
        }
    }

    @Override
    public void guardar(List<Alumno> alumnos) throws IOException {
        Files.createDirectories(ruta.getParent() == null ? Paths.get(".") : ruta.getParent());
        // Asegura que la carpeta del archivo exista

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(ruta))) {
            oos.writeObject(alumnos);
            // Escribe toda la lista de alumnos en un archivo binario de forma serializada
            //se encarga de guardar la estructura completa de cada Alumno y sus matrículas
        }
    }

    @Override
    public String getRuta() { return ruta.toString(); }
    // Devuelve la ruta del archivo binario
}
