package modelos;

import java.lang.annotation.Documented;
import java.util.Date;
import java.util.List;

@Documented()
public class Post {
    private String titulo;
    private String mensaje;
    private List<String> etiquetas;
    private Date fechaPublicacion;
    private List<Comentario> comentarios;

    public Post(String titulo, String mensaje, List<String> etiquetas, Date fechaPublicacion, List<Comentario> comentarios) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.etiquetas = etiquetas;
        this.fechaPublicacion = fechaPublicacion;
        this.comentarios = comentarios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Post{" +
                "titulo='" + titulo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", etiquetas=" + etiquetas +
                ", fechaPublicacion=" + fechaPublicacion +
                ", comentarios=" + comentarios +
                '}';
    }


}
