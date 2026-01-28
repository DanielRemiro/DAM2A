package org.example.Main;


import org.example.Model.Perfil;
import org.example.Model.Usuario;
import org.example.Util.JPAUtil;
import jakarta.persistence.EntityManager;
import org.hibernate.LazyInitializationException;

public class Main {
    public static void main(String[] args) {


        Long usuarioId = null;

        // Crear y Persistir
        System.out.println("=== FASE 1: PERSISTENCIA Y CASCADE ===");
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Usuario u = new Usuario("Juan Perez");
            Perfil p = new Perfil("Desarrollador Java", "555-1234");

            //  Asignación bidireccional (Usamos el metodo helper)
            u.asignarPerfil(p);

            em.persist(u);

            usuarioId = u.getId();
            System.out.println("Usuario guardado con ID: " + usuarioId);

            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        // Probar FetchType (EAGER vs LAZY) ---
        System.out.println("\n= FETCH TYPE  ===");
        EntityManager em2 = JPAUtil.getEntityManager();
        Usuario usuarioRecuperado = null;

        try {
            usuarioRecuperado = em2.find(Usuario.class, usuarioId);
            System.out.println("Usuario recuperado: " + usuarioRecuperado.getNombre());


            System.out.println("Clase del Perfil: " + usuarioRecuperado.getPerfil().getClass().getSimpleName());

        } finally {
            em2.close();
        }

        // Intentamos acceder al perfil YA CERRADA la sesión
        try {
            System.out.println("Intentando acceder al perfil fuera de sesión...");
            System.out.println("Bio del Perfil: " + usuarioRecuperado.getPerfil().getBio());
            System.out.println("Acceso exitoso ");
        } catch (LazyInitializationException e) {
            System.out.println("ERROR: LazyInitializationException capturada.");
            System.out.println("   Causa: Acceso a relación LAZY sin sesión activa.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Probar Cascade REMOVE ---
        System.out.println("\nCASCADE REMOVE ===");
        EntityManager em3 = JPAUtil.getEntityManager();
        try {
            em3.getTransaction().begin();

            Usuario uBorrar = em3.find(Usuario.class, usuarioId);
            if (uBorrar != null) {
                System.out.println("Borrando usuario...");

                em3.remove(uBorrar);
            }

            em3.getTransaction().commit();
            System.out.println("Usuario eliminado.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em3.close();
        }

        JPAUtil.shutdown();
    }
}