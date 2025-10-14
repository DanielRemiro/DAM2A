package ejercicio25p;

/**
 *
 * @author dremi
 */
public class Main {
    
    public static void main(String args[]){
        
        Simulador simulador=new Simulador();
        
        Bicicleta bicicleta = new Bicicleta();
        Avion avion = new Avion();
        Coche coche = new Coche();
        
        simulador.simulacionMovimiento(bicicleta);
        simulador.simulacionMovimiento(avion);
        simulador.simulacionMovimiento(coche);
        
        
    }
    
}
