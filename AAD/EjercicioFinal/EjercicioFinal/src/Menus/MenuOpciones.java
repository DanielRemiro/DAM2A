package Menus;

import Objetos.Alumno;
import Objetos.Matricula;
import ConfiguracionAlumno.AlumnoConfig;

import java.text.SimpleDateFormat;
import java.util.*;

public class MenuOpciones {

    private final AlumnoConfig service;
    private final Scanner sc = new Scanner(System.in);

    public MenuOpciones(AlumnoConfig service) { this.service = service; }

    public void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("Repositorio: " + service.getRuta());
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

            try {
                switch (op) {
                    case "1" -> { service.cargar(); System.out.println("Datos cargados."); }
                    case "2" -> listar();
                    case "3" -> crearAlumno();
                    case "4" -> agregarMatricula();
                    case "5" -> eliminar();
                    case "6" -> { service.guardar(); System.out.println("Datos guardados."); }
                    case "0" -> salir = true;
                    default -> System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void listar() {
        List<Alumno> lista = service.listar();
        if (lista.isEmpty()) System.out.println("No hay alumnos.");
        else lista.forEach(System.out::println);
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
        } catch (Exception e) {
            System.out.println("Formato incorrecto.");
        }
    }

    private void eliminar() {
        System.out.print("ID a eliminar: ");
        String id = sc.nextLine();
        if (service.eliminar(id)) System.out.println("Eliminado.");
        else System.out.println("No encontrado.");
    }
}
