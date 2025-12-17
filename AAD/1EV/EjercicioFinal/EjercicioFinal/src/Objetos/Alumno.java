package Objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Alumno implements Serializable {
    private String id;
    private String nombre;
    private String email;
    private List<Matricula> matriculas = new ArrayList<>();

    public Alumno(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public Alumno() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Matricula> getMatriculas() { return matriculas; }
    public void setMatriculas(List<Matricula> matriculas) { this.matriculas = matriculas; }

    public void agregarMatricula(Matricula m) { matriculas.add(m); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Alumno{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", matriculas=[");
        for (Matricula m : matriculas) {
            sb.append("\n    ").append(m);
        }
        sb.append("\n]}");
        return sb.toString();
    }
}
