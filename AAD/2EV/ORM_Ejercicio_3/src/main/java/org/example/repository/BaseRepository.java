package org.example.repository;

import jakarta.persistence.EntityManager;

public interface BaseRepository<T, ID> {
    T findById(EntityManager em, ID id);
    void persist(EntityManager em, T entity);
    T merge(EntityManager em, T entity);
    void remove(EntityManager em, T entity);
}