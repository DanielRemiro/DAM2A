package org.example.Main;

import jakarta.persistence.EntityManager;
import org.example.Model.Producto;
import org.example.Util.JPAUtil;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        Long idProducto = null;

        try {
            // ========================================================================
            // Crear un producto
            // ========================================================================
            System.out.println("--- 0. PREPARACIÓN: Creando producto inicial ---");
            em.getTransaction().begin();
            Producto pInicial = new Producto("Monitor 4K", 300.00);
            em.persist(pInicial);
            em.getTransaction().commit();
            idProducto = pInicial.getId();
            em.clear();
            System.out.println("Producto creado con ID: " + idProducto);


            // ========================================================================
            // USO DE FIND
            // ========================================================================
            System.out.println("\n--- 3. FIND: Recuperando producto ---");
            em.getTransaction().begin();

            Producto p = em.find(Producto.class, idProducto);
            System.out.println("Producto recuperado: " + p);
            // ESTADO ACTUAL: MANAGED (El EntityManager lo está vigilando)


            // ========================================================================
            // MODIFICACIÓN ESTANDO MANAGED
            // ========================================================================
            System.out.println("\n--- 4. MODIFICACIÓN MANAGED (Sin merge) ---");

            p.setPrecio(450.00);
            System.out.println("Valor en memoria cambiado a: " + p.getPrecio());

            em.getTransaction().commit();
            System.out.println("Commit realizado. Revisa tu BBDD, el precio debe ser 450.00");


            // ========================================================================
            // DETACH y MERGE
            // ========================================================================
            System.out.println("\n--- 5. DETACH y MERGE ---");
            em.getTransaction().begin();

            em.detach(p);

            p.setPrecio(9999.00);
            System.out.println("Precio cambiado en objeto DETACHED a: " + p.getPrecio());

            em.flush();
            System.out.println("Flush realizado sobre objeto detached. El precio en BBDD NO debe ser 9999.00");

            Producto pManaged = em.merge(p);

            em.getTransaction().commit();
            System.out.println("Commit post-merge realizado. Precio actualizado a: " + pManaged.getPrecio());

            p = pManaged;

            // ========================================================================
            // REMOVE
            // ========================================================================
            System.out.println("\n--- 6. REMOVE ---");
            em.getTransaction().begin();

            em.remove(p);

            em.getTransaction().commit();
            System.out.println("Producto eliminado. Si intentas buscarlo dará null.");

            Producto pBorrado = em.find(Producto.class, idProducto);
            System.out.println("Búsqueda post-delete: " + pBorrado);

        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            JPAUtil.shutdown();
        }
    }
}