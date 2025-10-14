package ejercicio25p;

/**
 *
 * @author dremi
 * 
 *     25) Tenemos un autobús con 10 plazas numeradas del 0 al 9. Se irá pidiendo a los usuarios que seleccionen su asiento. Si seleccionan un asiento que ya está ocupado, se le indicará al usuario mostrando un mensaje en el que diga “El asiento X ya está ocupado”. Si el asiento está libre se le expenderá el billete (muestra un mensaje por la pantalla que diga “Asiento X asignado”).
Cuando un usuario vaya a seleccionar un asiento, se le informará de cuántas plazas quedan libres.
El programa terminará cuando todas las plazas estén ocupadas.
* 
 */

import java.util.Scanner;

public class Autobus {
    
    Scanner teclado = new Scanner (System.in);
    int plazas[]=new int[10];
    int asientoSeleccionado;
    
    void infoPlazas(){
        
        for(int i=0;i<plazas.length;i++){
            
            if(plazas[i]!=1){
                
                System.out.println("La plaza numero "+ i+" esta libre.");
                
            }
            
        }
        
    }
    void pedirAsiento(){
        
        infoPlazas();
        System.out.print("Seleccione el asiento que quieras ocupar(del 0 al 9, escribe otro numero si no quieres ocupar ninguno): ");
        asientoSeleccionado=teclado.nextInt();
        
        seleccionAsiento();
        
    }
    
    void seleccionAsiento(){
        
        if(asientoSeleccionado<0 ||asientoSeleccionado>=10){
            
            System.out.print("Has salido correctamente.");
                    
        }else if(plazas[asientoSeleccionado]!=1){
            
            plazas[asientoSeleccionado]=1;
            
            System.out.print("Se le ha asignado correctamente el asiento numero: "+asientoSeleccionado);
            
            seleccionarMas();
            
        }else{
            
            System.out.print("El asiento "+ asientoSeleccionado+ " esta ocupado, seleccione otro");
            pedirAsiento();
            
        }
        
    }
    void seleccionarMas(){
        
        System.out.print("Si quiere seleccionar otro asiento por un numero distinto a 0: ");
        int eleccionMas=teclado.nextInt();
        
        if(eleccionMas!=0){
            
            pedirAsiento();
            
        }else{
            
            System.out.println("Muchas gracias, buenas tardes.");
            
        }
        
    }
    
}

