package Run;

import ConfiguracionAlumno.AlumnoConfig;
import Menus.MenuOpciones;

public class Main {
    public static void main(String[] args) {
        AlumnoConfig service = new AlumnoConfig();
        // Crea la configuración del sistema y prepara la lista de alumnos y la persistencia
        // (según lo que esté definido en config.properties: CSV, XML o binario)

        MenuOpciones menu = new MenuOpciones(service);
        // Crea el menú interactivo y le pasa la configuración para que pueda operar sobre los alumnos

        menu.mostrarMenu();
        // Muestra el menú en consola y espera la interacción del usuario
        // Aquí se pueden listar, agregar, eliminar alumnos y matrículas, cargar o guardar datos

        System.out.println("Aplicación finalizada.");
        // Mensaje que indica que la aplicación terminó tras salir del menú
    }
}
