package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.model.Editorial;
import org.example.model.Libro;
import org.example.repository.EditorialRepository;
import org.example.util.JPAUtil;

import java.util.List;

public class LibreriaService {

    // Inyectamos (manualment) el repositorio
    private final EditorialRepository editorialRepository = new EditorialRepository();

    // 1. CrearDatosIniciales
    public Long crearDatosIniciales() {
        EntityManager em = JPAUtil.getEntityManager();
        Long editorialId = null;
        try {
            em.getTransaction().begin();

            Editorial ed = new Editorial("Planeta", "España");
            Libro l1 = new Libro("Clean Code", "978-0132", 45.00);
            Libro l2 = new Libro("Java Effective", "978-0133", 50.00);

            // Usamos el helper para relacionar bidireccionalmente
            ed.addLibro(l1);
            ed.addLibro(l2);

            // Al tener CascadeType.ALL, basta con persistir la Editorial
            editorialRepository.persist(em, ed);

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

    // 2. AddLibro (Añade un libro a una editorial existente)
    public void addLibro(Long idEditorial, Libro libro) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Editorial ed = editorialRepository.findById(em, idEditorial);
            if(ed != null) {
                ed.addLibro(libro);

                editorialRepository.merge(em, ed);
                System.out.println(">> Libro añadido correctamente a " + ed.getNombre());
            } else {
                System.out.println(">> Editorial no encontrada");
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Libro buscarLibro(Long idLibro) {
        EntityManager em = JPAUtil.getEntityManager();
        Libro libro = null;
        try {
            libro = em.find(Libro.class, idLibro);
        } finally {
            em.close();
        }
        return libro;
    }

    public List<Libro> listaLibrosEditorial(Long idEditorial) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Libro> libros = null;
        try {
            Editorial ed = editorialRepository.findById(em, idEditorial);
            if(ed != null) {
                libros = ed.getLibros();
                libros.size();
            }
        } finally {
            em.close();
        }
        return libros;
    }
}