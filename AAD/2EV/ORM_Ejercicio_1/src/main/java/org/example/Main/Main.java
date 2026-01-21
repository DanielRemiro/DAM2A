package org.example.Main;

import jakarta.persistence.EntityManager;
import org.example.Model.Producto;
import org.example.Util.JPAUtil;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        Long idProducto = null; // Guardaremos el ID para usarlo en los pasos

        try {
            // ========================================================================
            // PASO PREVIO: Crear un producto para tener algo con qué trabajar
            // ========================================================================
            System.out.println("--- 0. PREPARACIÓN: Creando producto inicial ---");
            em.getTransaction().begin();
            Producto pInicial = new Producto("Monitor 4K", 300.00);
            em.persist(pInicial);
            em.getTransaction().commit();
            idProducto = pInicial.getId();
            // Limpiamos la caché del EntityManager para simular una recuperación real luego
            em.clear();
            System.out.println("Producto creado con ID: " + idProducto);


            // ========================================================================
            // 3. USO DE FIND (Lectura)
            // ========================================================================
            System.out.println("\n--- 3. FIND: Recuperando producto ---");
            // Nota: find() no requiere transacción obligatoria, pero los siguientes pasos sí.
            em.getTransaction().begin();

            Producto p = em.find(Producto.class, idProducto);
            System.out.println("Producto recuperado: " + p);
            // ESTADO ACTUAL: MANAGED (El EntityManager lo está vigilando)


            // ========================================================================
            // 4. MODIFICACIÓN ESTANDO MANAGED (Dirty Checking)
            // ========================================================================
            System.out.println("\n--- 4. MODIFICACIÓN MANAGED (Sin merge) ---");

            // Cambiamos el precio. NO llamamos a em.merge() ni em.persist()
            p.setPrecio(450.00);
            System.out.println("Valor en memoria cambiado a: " + p.getPrecio());

            // Al hacer commit, JPA detecta que 'p' (que es Managed) ha cambiado respecto a la BBDD.
            // Automáticamente lanza un UPDATE.
            em.getTransaction().commit();
            System.out.println("Commit realizado. Revisa tu BBDD, el precio debe ser 450.00");


            // ========================================================================
            // 5. DETACH y MERGE
            // ========================================================================
            System.out.println("\n--- 5. DETACH y MERGE ---");
            em.getTransaction().begin();

            // A. DETACH
            em.detach(p);
            // ESTADO ACTUAL: DETACHED (El EntityManager YA NO lo vigila)

            // Modificamos el precio en el objeto Java
            p.setPrecio(9999.00);
            System.out.println("Precio cambiado en objeto DETACHED a: " + p.getPrecio());

            // Hacemos commit (o flush) para probar que NO se guarda
            em.flush(); // Forzamos intento de sincronización
            System.out.println("Flush realizado sobre objeto detached. El precio en BBDD NO debe ser 9999.00");

            // B. MERGE
            // Para guardar los cambios de un objeto detached, usamos merge.
            // IMPORTANTE: merge devuelve una NUEVA referencia que sí es Managed. 'p' sigue detached.
            Producto pManaged = em.merge(p);

            // Ahora pManaged sí está vigilado. Al hacer commit se guardará el 9999.00
            em.getTransaction().commit();
            System.out.println("Commit post-merge realizado. Precio actualizado a: " + pManaged.getPrecio());

            // Actualizamos nuestra variable 'p' para que apunte al objeto gestionado para el siguiente paso
            p = pManaged;


            // ========================================================================
            // 6. REMOVE (Eliminación)
            // ========================================================================
            System.out.println("\n--- 6. REMOVE ---");
            em.getTransaction().begin();

            // Para eliminar, el objeto debe estar MANAGED (lo es, gracias al merge anterior)
            em.remove(p);
            // ESTADO ACTUAL: REMOVED (Marcado para borrar)

            em.getTransaction().commit();
            System.out.println("Producto eliminado. Si intentas buscarlo dará null.");

            // Verificación final
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