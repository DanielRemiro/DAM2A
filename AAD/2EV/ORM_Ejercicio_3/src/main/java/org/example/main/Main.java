package org.example.main;

import org.example.model.Libro;
import org.example.service.LibreriaService;
import org.example.util.JPAUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibreriaService service = new LibreriaService();

        System.out.println("=== 1. CREAR DATOS INICIALES ===");
        Long idEditorial = service.crearDatosIniciales();

        System.out.println("\n=== 2. LISTAR LIBROS INICIALES ===");
        imprimirLibros(service, idEditorial);

        System.out.println("\n=== 3. AÑADIR NUEVO LIBRO ===");
        Libro nuevoLibro = new Libro("El Señor de los Anillos", "999-000", 25.50);
        service.addLibro(idEditorial, nuevoLibro);

        System.out.println("\n=== 4. LISTAR DESPUES DE AÑADIR ===");
        imprimirLibros(service, idEditorial);

        JPAUtil.shutdown();
    }

    private static void imprimirLibros(LibreriaService service, Long idEditorial) {
        List<Libro> lista = service.listaLibrosEditorial(idEditorial);
        if (lista != null) {
            for (Libro l : lista) {
                System.out.println("- " + l.getTitulo() + " (" + l.getPrecio() + "€)");
            }
        } else {
            System.out.println("Editorial no encontrada.");
        }
    }
}