package Objetos;

import java.io.Serializable;

public class Asignatura implements Serializable {

    private String id;
    private String nombre;
    private int creditos;

    public Asignatura(String id, String nombre, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", creditos=" + creditos +
                '}';
    }
}
