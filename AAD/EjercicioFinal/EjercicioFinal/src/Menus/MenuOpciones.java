package Menus;

import Objetos.Alumno;
import Objetos.Matricula;
import ConfiguracionAlumno.AlumnoConfig;

import java.text.SimpleDateFormat;
import java.util.*;

public class MenuOpciones {

    private final AlumnoConfig service;
    private final Scanner sc = new Scanner(System.in);
    // 'service' es la configuración y lista de alumnos.
    // 'sc' permite leer entradas del usuario desde consola.

    public MenuOpciones(AlumnoConfig service) { this.service = service; }
    // Constructor: recibe la configuración de alumnos para poder operar sobre ella.

    public void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            // Bucle principal del menú. Se repite hasta que el usuario elija salir.

            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("Repositorio: " + service.getRuta());
            // Muestra dónde se guardan/cargan los datos.

            System.out.println("""
                    1. Cargar datos
                    2. Listar alumnos
                    3. Añadir alumno
                    4. Añadir matrícula a alumno
                    5. Eliminar alumno
                    6. Guardar datos
                    0. Salir""");
            System.out.print("Opción: ");
            String op = sc.nextLine();
            // Muestra las opciones y lee la elección del usuario.

            try {
                switch (op) {
                    case "1" -> { service.cargar(); System.out.println("Datos cargados."); }
                    // Carga los alumnos desde el archivo configurado.
                    case "2" -> listar();
                    // Lista todos los alumnos y sus matrículas.
                    case "3" -> crearAlumno();
                    // Permite crear un nuevo alumno.
                    case "4" -> agregarMatricula();
                    // Agrega una matrícula a un alumno existente.
                    case "5" -> eliminar();
                    // Elimina un alumno por ID.
                    case "6" -> { service.guardar(); System.out.println("Datos guardados."); }
                    // Guarda los alumnos en el archivo configurado.
                    case "0" -> salir = true;
                    // Sale del bucle y termina la aplicación.
                    default -> System.out.println("Opción no válida.");
                    // Si se introduce cualquier otra opción.
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                // Captura errores de carga, guardado o parsing de datos.
            }
        }
    }

    private void listar() {
        List<Alumno> lista = service.listar();
        if (lista.isEmpty()) System.out.println("No hay alumnos.");
        else lista.forEach(System.out::println);
        // Muestra todos los alumnos con sus matrículas usando el toString() de Alumno.
    }

    private void crearAlumno() {
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        service.agregar(new Alumno(id, nombre, email));
        System.out.println("Alumno agregado.");
        // Crea un alumno nuevo con los datos introducidos y lo añade a la lista.
        // Si ya existe un alumno con el mismo ID, se reemplaza.
    }

    private void agregarMatricula() {
        System.out.print("ID del alumno: ");
        String id = sc.nextLine();
        Alumno a = service.buscar(id);
        if (a == null) {
            System.out.println("No encontrado.");
            return;
        }
        try {
            System.out.print("Fecha (dd/MM/yyyy): ");
            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
            System.out.print("Nota: ");
            double nota = Double.parseDouble(sc.nextLine());
            a.agregarMatricula(new Matricula(fecha, nota));
            System.out.println("Matrícula añadida.");
            // Pide fecha y nota, crea una matrícula y la añade al alumno.
            // Captura errores si el formato de la fecha o nota es incorrecto.
        } catch (Exception e) {
            System.out.println("Formato incorrecto.");
        }
    }

    private void eliminar() {
        System.out.print("ID a eliminar: ");
        String id = sc.nextLine();
        if (service.eliminar(id)) System.out.println("Eliminado.");
        else System.out.println("No encontrado.");
        // Elimina el alumno con el ID indicado.
        // Informa si se eliminó o si no existía.
    }
}
