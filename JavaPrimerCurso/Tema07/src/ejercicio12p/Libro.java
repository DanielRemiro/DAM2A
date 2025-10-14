package ejercicio12p;

/**
 *
 * @author dremi
 */

public class Libro extends Material implements Prestable{
    
    private boolean estaPrestado=false;
    private String autor;
    private int numeroPaginas;
    
    Libro(String titulo,int anno_publicacion,String autor,int numeroPaginas){
        
        super(titulo,anno_publicacion);
        this.autor=autor;
        this.numeroPaginas=numeroPaginas;
        
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public boolean getEstaPrestado() {
        return estaPrestado;
    }
    
    @Override
    public void prestar()throws Excepcion{
        
        if(estaPrestado==true){
            
            throw new Excepcion("El libro "+getTitulo()+" ya esta prestado.");
            
        }else{
            
           estaPrestado=true;
           System.out.println("Prestado correctamente.");
            
        }
        
    }
    
    @Override
    public void devolver(){
        
        if(estaPrestado==true){
            
            estaPrestado=false;
        
            System.out.println("Se ha devuelto el libro");
            
        }else{
            
            System.out.println("No esta prestado el libro.");
            
        }
        
    }
    
    @Override
    public void comprobarAntiguedad(){
        
        int antiguedad=annoActual-getAnno_publicacion();
        
            if(antiguedad>=100){
            
                System.out.println("El libro es antiguo.");
            
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


