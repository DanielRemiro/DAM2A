package proveedoresp;

import java.time.LocalDate;

public class InsumoProveedor {

    private int id;
    private String nombre;
    private LocalDate fechaCaducidad;
    private boolean esEspecial;
    private double precio;

    public InsumoProveedor(int id, String nombre, LocalDate fechaCaducidad, boolean esEspecial, double precio) {

        this.id = id;
        this.nombre = nombre;
        this.fechaCaducidad = fechaCaducidad;
        this.esEspecial = esEspecial;
        this.precio = precio;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public boolean isEsEspecial() {
        return esEspecial;
    }

    public void setEsEspecial(boolean esEspecial) {
        this.esEspecial = esEspecial;
    }

    @Override
    public String toString() {
        return "InsumoProveedor{" + "id=" + id + ", nombre=" + nombre + ", fechaCaducidad=" + fechaCaducidad + ", esEspecial=" + esEspecial + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InsumoProveedor other = (InsumoProveedor) obj;
        return this.id == other.id;
    }

}
