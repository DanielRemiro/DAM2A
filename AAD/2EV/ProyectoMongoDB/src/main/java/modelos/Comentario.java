package modelos;


import java.util.Date;

public class Comentario {
    private String contenido;

    public Comentario() {}

    public Comentario(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    @Override
    public String toString() {
        return "   -> Comentario: " + contenido;
    }
}