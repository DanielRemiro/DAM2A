package ejercicio16p;

/**
 *
 * @author dremi
 */
public class Jefe  extends Empleado{
    
     String tituloUniversitario;
     String departamentoResponsable;
    
    Jefe(double sueldo, String nombre,String tituloUniversitario,String departamentoResponsable){
        
        super(sueldo,nombre);
        this.tituloUniversitario=tituloUniversitario;
        this.departamentoResponsable=departamentoResponsable;
        
    }
    
}
