package ConfiguracionAlumno;

import Objetos.Alumno;
import Interfaces.AlumnoRepositorio;
import Archivos.*;

import java.io.FileInputStream;
import java.util.*;

public class AlumnoConfig {

    private AlumnoRepositorio repo;
    private List<Alumno> memoria = new ArrayList<>();
    // 'repo' es la implementación concreta de persistencia (CSV, XML o binario)
    // 'memoria' es la lista de alumnos cargada en memoria durante la ejecución

    public AlumnoConfig() {
        Properties p = new Properties();
        try (FileInputStream fis = new FileInputStream("C:\\Users\\dremi\\Desktop\\DAM2A\\AAD\\EjercicioFinal\\out\\production\\EjercicioFinal\\Configuracion\\config.properties")) {
            p.load(fis);
            // Intenta leer el archivo de configuración para decidir tipo de persistencia y ruta
        } catch (Exception e) {
            System.out.println("No se encontró config.properties. Usando CSV por defecto.");
            // Si no encuentra el archivo, usa CSV como predeterminado
        }

        String tipo = p.getProperty("persistence", "csv").toLowerCase();
        String ruta = p.getProperty("ruta", "data/alumnos.csv");
        // Obtiene el tipo de persistencia y la ruta del archivo, con valores por defecto

        switch (tipo) {
            case "xml" -> repo = new Xml(ruta);
            case "binario" -> repo = new Binario(ruta);
            default -> repo = new Csv(ruta);
        }
        // Crea la instancia de repositorio según el tipo: XML, binario o CSV
    }

    public void cargar() throws Exception { memoria = repo.cargar(); }
    // Carga la lista de alumnos desde el repositorio y la guarda en memoria

    public void guardar() throws Exception { repo.guardar(memoria); }
    // Guarda la lista de alumnos en el repositorio configurado

    public List<Alumno> listar() { return memoria; }
    // Devuelve la lista de alumnos en memoria

    public void agregar(Alumno a) {
        memoria.removeIf(x -> x.getId().equals(a.getId()));
        memoria.add(a);
        // Añade un alumno, reemplazando cualquier alumno con el mismo ID
    }

    public Alumno buscar(String id) {
        return memoria.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
        // Busca un alumno por su ID en la lista de memoria
        // Devuelve null si no lo encuentra
    }

    public boolean eliminar(String id) { return memoria.removeIf(a -> a.getId().equals(id)); }
    // Elimina un alumno por su ID y devuelve true si se eliminó, false si no existía

    public String getRuta() { return repo.getRuta(); }
    // Devuelve la ruta del archivo o repositorio que se está usando
}
