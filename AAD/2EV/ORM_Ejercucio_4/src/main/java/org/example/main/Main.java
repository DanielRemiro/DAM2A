package org.example.main;

import org.example.model.Autor;
import org.example.model.Libro;
import org.example.service.LibreriaService;
import org.example.util.JPAUtil;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibreriaService service = new LibreriaService();

        System.out.println("=== 1. INICIALIZAR BASE DE DATOS ===");

        Long idEditorial = service.crearDatosIniciales();

        System.out.println("\n=== 2. ADD AUTOR A LIBRO (EXISTENTES) ===");
        service.addAutorALibro(1L, 1L);

        System.out.println("\n=== 3. ADD NUEVO LIBRO CON AUTORES ===");
        Libro libroNuevo = new Libro("Diseño de Patrones", "978-XYZ", 60.00);

        List<Long> idsAutores = Arrays.asList(1L, 2L);

        service.addLibroConAutores(idEditorial, libroNuevo, idsAutores);

        System.out.println("\n=== 4. LISTAR AUTORES DE UN LIBRO ===");

        Long idLibroReciente = libroNuevo.getId();
        System.out.println("Autores del libro '" + libroNuevo.getTitulo() + "':");

        List<Autor> autores = service.listarAutoresLibro(idLibroReciente);
        if(autores != null) {
            for(Autor a : autores) {
                System.out.println(" - " + a.getNombre() + " (" + a.getNacionalidad() + ")");
            }
        }

        System.out.println("\n=== 5. LISTAR LIBROS DE UN AUTOR ===");

        System.out.println("Libros del Autor ID 1:");
        List<Libro> librosAutor = service.listarLibrosAutor(1L);
        if(librosAutor != null) {
            for(Libro l : librosAutor) {
                System.out.println(" - " + l.getTitulo());
            }
        }

        JPAUtil.shutdown();
    }
}