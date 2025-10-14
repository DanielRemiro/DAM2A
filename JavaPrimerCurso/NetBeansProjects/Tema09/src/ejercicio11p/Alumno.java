package ejercicio11p;

import java.io.Serializable;



public class Alumno implements Serializable{

    private String nombre;
    private boolean aprobado;
    private int convocatoria;
    private float nota;
    
    public Alumno(String nombre,boolean aprobado,int convocatoria,float nota){
        
        this.nombre=nombre;
        this.aprobado=aprobado;
        this.convocatoria=convocatoria;
        this.nota=nota;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public int getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(int convocatoria) {
        this.convocatoria = convocatoria;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
    @Override
    public String toString(){
        
        return "Nombre: "+nombre+", aprobado: "+aprobado+", convocatoria: "+convocatoria+" y nota: "+nota;
        
    }
    
}
