package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.model.Autor;
import org.example.model.Editorial;
import org.example.model.Libro;
import org.example.repository.AutorRepository;
import org.example.repository.EditorialRepository;
import org.example.repository.LibroRepository;
import org.example.util.JPAUtil;

import java.util.List;

public class LibreriaService {

    private final EditorialRepository editorialRepository = new EditorialRepository();
    private final AutorRepository autorRepository = new AutorRepository();
    private final LibroRepository libroRepository = new LibroRepository();


    public Long crearDatosIniciales() {
        EntityManager em = JPAUtil.getEntityManager();
        Long editorialId = null;
        try {
            em.getTransaction().begin();

            Editorial ed = new Editorial("Planeta", "España");

            Libro l1 = new Libro("Clean Code", "978-0132", 45.00);
            Libro l2 = new Libro("Java Effective", "978-0133", 50.00);

            ed.addLibro(l1);
            ed.addLibro(l2);

            editorialRepository.persist(em, ed);

            Autor a1 = new Autor("Robert C. Martin", "USA");
            Autor a2 = new Autor("Joshua Bloch", "USA");
            autorRepository.persist(em, a1);
            autorRepository.persist(em, a2);

            em.getTransaction().commit();
            editorialId = ed.getId();
            System.out.println(">> Datos iniciales creados. Editorial ID: " + editorialId);

        } catch (Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        return editorialId;
    }

    public List<Libro> listaLibrosEditorial(Long idEditorial) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Libro> libros = null;
        try {
            Editorial ed = editorialRepository.findById(em, idEditorial);
            if(ed != null) {
                libros = ed.getLibros();
                libros.size(); // Inicializar la colección
            }
        } finally {
            em.close();
        }
        return libros;
    }


    //Añadir un autor existente a un libro existente
    public void addAutorALibro(Long autorId, Long libroId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Autor autor = autorRepository.findById(em, autorId);
            Libro libro = libroRepository.findById(em, libroId);

            if (autor != null && libro != null) {
                libro.addAutor(autor); // Helper
                libroRepository.merge(em, libro); // Actualizamos libro (owner)
                System.out.println(">> Asignado autor " + autor.getNombre() + " al libro " + libro.getTitulo());
            } else {
                System.out.println(">> Error: Autor o Libro no encontrado.");
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Crear un libro nuevo, asignarlo a una editorial y añadirle autores por ID
    public void addLibroConAutores(Long editorialId, Libro nuevoLibro, List<Long> autoresIds) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            // Vincular Editorial (si existe)
            if (editorialId != null) {
                Editorial ed = editorialRepository.findById(em, editorialId);
                if (ed != null) {
                    ed.addLibro(nuevoLibro); // Helper 1:N
                }
            }

            // Vincular Autores (si hay lista)
            if (autoresIds != null) {
                for (Long idAutor : autoresIds) {
                    Autor autor = autorRepository.findById(em, idAutor);
                    if (autor != null) {
                        nuevoLibro.addAutor(autor); // Helper N:M
                    }
                }
            }

            // Persistir Libro
            libroRepository.persist(em, nuevoLibro);

            em.getTransaction().commit();
            System.out.println(">> Libro creado con autores: " + nuevoLibro.getTitulo());

        } catch (Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Listar los autores de un libro
    public List<Autor> listarAutoresLibro(Long libroId) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Autor> autores = null;
        try {
            Libro libro = libroRepository.findById(em, libroId);
            if (libro != null) {
                autores = libro.getAutores();
                autores.size();
            }
        } finally {
            em.close();
        }
        return autores;
    }

    //Listar los libros de un autor
    public List<Libro> listarLibrosAutor(Long autorId) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Libro> libros = null;
        try {
            Autor autor = autorRepository.findById(em, autorId);
            if (autor != null) {
                libros = autor.getLibros();
                libros.size();
            }
        } finally {
            em.close();
        }
        return libros;
    }
}