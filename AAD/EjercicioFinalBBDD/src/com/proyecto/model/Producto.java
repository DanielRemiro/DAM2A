package com.proyecto.model;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int categoriaId; // FK Relación 1-N
    private byte[] imagen;   // Campo BLOB

    public Producto() {}
    public Producto(String nombre, double precio, int categoriaId) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoriaId = categoriaId;
    }

    // Getters y Setters omitidos por brevedad (genéralos en tu IDE)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getCategoriaId() { return categoriaId; }
    public void setCategoriaId(int categoriaId) { this.categoriaId = categoriaId; }
    public byte[] getImagen() { return imagen; }
    public void setImagen(byte[] imagen) { this.imagen = imagen; }

    @Override
    public String toString() { return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]"; }
}