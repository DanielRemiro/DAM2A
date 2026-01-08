package org.Model;

import jakarta.persistence.*;

@Entity
@Table(name="tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean completada;
    private String titulo;

    public Tarea( String titulo) {
        this.titulo = titulo;
        this.completada = false;
    }

    public Tarea() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", completada=" + completada +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
