package Interfaces;

import Objetos.Alumno;
import java.util.List;

public interface AlumnoRepositorio {
    List<Alumno> cargar() throws Exception;
    void guardar(List<Alumno> alumnos) throws Exception;
    String getRuta();
}
