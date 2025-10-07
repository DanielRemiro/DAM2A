package Objetos;

import java.io.Serializable;
import java.util.Date;

public class Matricula implements Serializable {

    private String idAlumno;
    private String idAsignatura;
    private Date fecha;
    private double nota;

    public Matricula(String idAlumno, String idAsignatura, Date fecha, double nota) {
        this.idAlumno = idAlumno;
        this.idAsignatura = idAsignatura;
        this.fecha = fecha;
        this.nota = nota;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(String idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "idAlumno='" + idAlumno + '\'' +
                ", idAsignatura='" + idAsignatura + '\'' +
                ", fecha=" + fecha +
                ", nota=" + nota +
                '}';
    }
}
