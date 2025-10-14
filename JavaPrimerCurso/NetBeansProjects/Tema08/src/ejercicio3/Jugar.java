package ejercicio3;

/**
 *
 * @author dremi
 */

import java.util.ArrayList;

public class Jugar {
    
    private ArrayList<Ficha> fichasJuego = new ArrayList<>();
    
    private CrearFicha f = new CrearFicha();
    
    void unirFichas(){
        
        Ficha aux;
        boolean seRepite=false;
        
        for(int i=0;i<f.getListaFichas().size();i++){
            
            aux=f.getListaFichas().get(i);
            
            for(int j=i+1;j<f.getListaFichas().size();j++){
                
                if(f.getListaFichas().get(j).equals(aux)){
                    
                    seRepite=true;
                    
                }
                
            }
            
        }
        
    }
    
}
