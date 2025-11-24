package com.proyecto.repository;
import java.util.List;

public interface Repository<T> {
    List<T> listar();
    T porId(int id);
    void guardar(T t);
    void eliminar(int id);
}