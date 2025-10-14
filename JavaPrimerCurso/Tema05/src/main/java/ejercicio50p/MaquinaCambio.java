package ejercicio50p;

/**
 *
 * @author dremi
 * 
 *     50) Máquina cambio monedas: el usuario introducirá una cantidad de dinero. La máquina que sirve para cambiar monedas tiene billetes 
 * de 500, 200, 100, 50, 20, 10 y monedas de 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01.
La máquina tendrá que hacer la devolución con la mínima cantidad de billetes y o monedas posibles.
* 
 */

import java.util.Scanner;

public class MaquinaCambio {
    
    Scanner teclado=new Scanner(System.in);
    double dineroIntroducido;
    int dineroDado[]=new int[15];
    double cambio[]={500,200,100,50,20,10,5,2,1,0.5,0.2,0.1,0.05,0.02,0.01};
    
    void introducirDinero(){
        
        System.out.print("Introduce el dinero que desees para realizar el cambio: ");
        dineroIntroducido= teclado.nextDouble();
        
        maquina();
        
    }
    
    void maquina(){
        
        for(int i=0;i<cambio.length;i++){
            
            if(dineroIntroducido>=cambio[i]){
                
                dineroDado[i]=(int) ( dineroIntroducido/cambio[i]);
                dineroIntroducido=dineroIntroducido%cambio[i];
                
            }
            
        }
        
    }
    
    void devolverCambio(){
        
        for(int j=0;j<dineroDado.length;j++){
            if(dineroDado[j]!=0){
                
            System.out.println("Has recibido "+dineroDado[j]+" de "+cambio[j]+" euros.");
            
            }
        }
        
    }
    
}
