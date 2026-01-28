package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String isbn;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;

    public Libro() {}

    public Libro(String titulo, String isbn, double precio) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.precio = precio;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public Editorial getEditorial() { return editorial; }
    public void setEditorial(Editorial editorial) { this.editorial = editorial; }

    @Override
    public String toString() {
        return "Libro{id=" + id + ", titulo='" + titulo + "', precio=" + precio + "}";
    }
}