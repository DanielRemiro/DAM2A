package ejercicio18p;

/**
 *
 * @author dremi
 */
public class Animal {
    
    private int numeroCrias;
    
    void setNumeroCrias(int numeroCrias){
        
        this.numeroCrias=numeroCrias;
        
    }
    
    int getNumeroCrias(){
        
        return numeroCrias;
        
    }
    
    void alimentarAnimal(){
        
        System.out.println(" Esta comiendo ....");
        
    }
    
}
