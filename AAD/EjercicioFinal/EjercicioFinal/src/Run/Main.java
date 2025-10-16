package Run;

import ConfiguracionAlumno.AlumnoConfig;
import Menus.MenuOpciones;

public class Main {
    public static void main(String[] args) {
        AlumnoConfig service = new AlumnoConfig();
        MenuOpciones menu = new MenuOpciones(service);
        menu.mostrarMenu();
        System.out.println("Aplicación finalizada.");
    }
}
