package ejercicio12p;

/**
 *
 * @author dremi
 */
public abstract class Material {
    
    static final int annoActual=2025;
    private String titulo;
    private int anno_publicacion;

    Material(String titulo,int anno_publicacion){
        
        this.titulo=titulo;
        this.anno_publicacion=anno_publicacion;
        
    }
    
     public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnno_publicacion() {
        return anno_publicacion;
    }

    public void setAnno_publicacion(int anno_publicacion) {
        this.anno_publicacion = anno_publicacion;
    }

    public abstract void comprobarAntiguedad();
    
    
}
