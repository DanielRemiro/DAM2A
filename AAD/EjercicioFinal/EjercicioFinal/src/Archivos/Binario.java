package Archivos;

import Objetos.Alumno;
import Interfaces.AlumnoRepositorio;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Binario implements AlumnoRepositorio {

    private final Path ruta;

    public Binario(String rutaArchivo) {
        this.ruta = Paths.get(rutaArchivo);
    }

    @Override
    public List<Alumno> cargar() throws IOException, ClassNotFoundException {
        if (!Files.exists(ruta)) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(ruta))) {
            return (List<Alumno>) ois.readObject();
        }
    }

    @Override
    public void guardar(List<Alumno> alumnos) throws IOException {
        Files.createDirectories(ruta.getParent() == null ? Paths.get(".") : ruta.getParent());
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(ruta))) {
            oos.writeObject(alumnos);
        }
    }

    @Override
    public String getRuta() { return ruta.toString(); }
}
