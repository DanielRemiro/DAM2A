package ejercicio12p;

/**
 *
 * @author dremi
 */
public class Revista extends Material{
    
    String editorial;
    int numeroEdicion;
    
    Revista(String titulo,int anno_publicacion,String editorial,int numeroEdicion){
        
        super(titulo,anno_publicacion);
        this.editorial=editorial;
        this.numeroEdicion=numeroEdicion;
        
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }
 
    @Override
    public void comprobarAntiguedad(){
       
        int antiguedad=annoActual-getAnno_publicacion();
        
            if(antiguedad>=50){
            
                System.out.println("La revista es antigua.");
            
            }
        
    }
    
}
