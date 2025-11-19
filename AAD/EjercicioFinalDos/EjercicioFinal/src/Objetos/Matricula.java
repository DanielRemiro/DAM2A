package Objetos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Matricula implements Serializable {
    private Date fecha;
    private double nota;

    public Matricula(Date fecha, double nota) {
        this.fecha = fecha;
        this.nota = nota;
    }

    public Matricula() {}

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Matricula{" +
                "fecha=" + sdf.format(fecha) +
                ", nota=" + nota +
                '}';
    }
}
