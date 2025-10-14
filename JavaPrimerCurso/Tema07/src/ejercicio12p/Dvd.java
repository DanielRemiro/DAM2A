package ejercicio12p;

/**
 *
 * @author dremi
 */
public class Dvd extends Material implements Prestable{
    
    boolean estaPrestado=false;
    String director;
    int duracion;
    
    Dvd(String titulo,int anno_publicacion,String director,int duracion){
        
        super(titulo,anno_publicacion);
        this.director=director;
        this.duracion=duracion;
        
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    @Override
    public void prestar()throws Excepcion{
        
        if(estaPrestado==true){
            
            throw new Excepcion("El Dvd "+getTitulo()+" ya esta prestado.");
            
        }else{
            
           estaPrestado=true;
           System.out.println("Prestado correctamente.");
            
        }
        
    }
    
    @Override
    public void devolver(){
        
        if(estaPrestado==true){
            
            estaPrestado=false;
        
            System.out.println("Se ha devuelto el dvd");
            
        }else{
            
            System.out.println("No esta prestado el dvd.");
            
        }
        
    }
    
    @Override
    public void comprobarAntiguedad(){
        
        int antiguedad=annoActual-getAnno_publicacion();
        
        if(antiguedad>=20){
            
            System.out.println("El dvd es antiguo.");
            
        }
        
    }
    
    @Override
    public void estaPrestado(){
        
        try{
            
            prestar();
            
        }
        
        catch(Excepcion e){
            
            System.out.println(":Error "+e.getMessage());
            
        }
        
    }
    
}