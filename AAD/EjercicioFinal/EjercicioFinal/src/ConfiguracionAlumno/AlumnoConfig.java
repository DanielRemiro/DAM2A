package ConfiguracionAlumno;

import Objetos.Alumno;
import Interfaces.AlumnoRepositorio;
import Archivos.*;

import java.io.FileInputStream;
import java.util.*;

public class AlumnoConfig {

    private AlumnoRepositorio repo;
    private List<Alumno> memoria = new ArrayList<>();

    public AlumnoConfig() {
        Properties p = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            p.load(fis);
        } catch (Exception e) {
            System.out.println("No se encontró config.properties. Usando CSV por defecto.");
        }

        String tipo = p.getProperty("persistence", "csv").toLowerCase();
        String ruta = p.getProperty("ruta", "data/alumnos.csv");

        switch (tipo) {
            case "xml" -> repo = new Xml(ruta);
            case "binario" -> repo = new Binario(ruta);
            default -> repo = new Csv(ruta);
        }
    }

    public void cargar() throws Exception { memoria = repo.cargar(); }
    public void guardar() throws Exception { repo.guardar(memoria); }

    public List<Alumno> listar() { return memoria; }

    public void agregar(Alumno a) {
        memoria.removeIf(x -> x.getId().equals(a.getId()));
        memoria.add(a);
    }

    public Alumno buscar(String id) {
        return memoria.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean eliminar(String id) { return memoria.removeIf(a -> a.getId().equals(id)); }

    public String getRuta() { return repo.getRuta(); }
}
