package modelos;

public class Comentario {
    private String contenido;

    public Comentario(String contenido) {}

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "contenido='" + contenido + '\'' +
                '}';
    }
}
