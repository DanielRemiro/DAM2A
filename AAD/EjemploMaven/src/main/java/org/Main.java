package org;

import jakarta.persistence.*;
import org.Model.Tarea;

public class Main {
    public static void main() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm-clase");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Tarea t = new Tarea("Mi primera tarea");
        Tarea t2 = new Tarea("Mi segunda tarea");
        Tarea t3 = new Tarea("Mi tercera tarea");

        entityManager.persist(t);
        entityManager.persist(t2);
        entityManager.persist(t3);

        System.out.println("Modificando tarea 2");
        t2.setTitulo("Modificando titulo 2");

        System.out.println("tarea guardada con id: " + t);
        System.out.println("tarea2 guardada con id: " + t2);
        System.out.println("tarea3 guardada con id: " + t3);

        transaction.commit();
        entityManager.close();

        entityManager= entityManagerFactory.createEntityManager();
        transaction= entityManager.getTransaction();
        transaction.begin();

        System.out.println("Modificando tarea 1");
        t.setTitulo("Modificando titulo 1");

        entityManager.merge(t);
        t3=entityManager.merge(t3);
        entityManager.remove(t3);

        transaction.commit();
        entityManager.close();

    }
}
