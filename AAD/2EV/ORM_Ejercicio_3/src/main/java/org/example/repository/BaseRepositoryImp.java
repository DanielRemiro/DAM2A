package org.example.repository;

import jakarta.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;

public abstract class BaseRepositoryImp<T, ID> implements BaseRepository<T, ID> {

    private Class<T> entityClass;

    // Truco de Java para saber qué clase es T en tiempo de ejecución
    @SuppressWarnings("unchecked")
    public BaseRepositoryImp() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T findById(EntityManager em, ID id) {
        return em.find(entityClass, id);
    }

    @Override
    public void persist(EntityManager em, T entity) {
        em.persist(entity);
    }

    @Override
    public T merge(EntityManager em, T entity) {
        return em.merge(entity);
    }

    @Override
    public void remove(EntityManager em, T entity) {
        em.remove(entity);
    }
}