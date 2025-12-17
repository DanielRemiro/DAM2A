package Interfaces;

import Objetos.Alumno;
import java.util.List;

public interface AlumnoRepositorio {

    List<Alumno> cargar() throws Exception;
    // Metodo que debe implementar cualquier clase que maneje persistencia de alumnos.
    // Devuelve la lista de alumnos guardada en el archivo o repositorio.
    // Lanza excepción si ocurre un error al leer los datos.

    void guardar(List<Alumno> alumnos) throws Exception;
    // Metodo para guardar la lista de alumnos en el repositorio o archivo.
    // Lanza excepción si ocurre un error al escribir los datos.

    String getRuta();
    // Devuelve la ruta del archivo o repositorio que se está usando.
}
