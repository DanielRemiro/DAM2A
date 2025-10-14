/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio25p;

/**
 *
 * @author dremi
 */

import java.util.Scanner;

public class Bicicleta  implements Vehiculo{
    
    int metrosRecorridos=0;
    
    @Override
    public void preguntarMover(){
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Quieres pedalear(0 para no pedalear,otro numero entero para pedalear): ");
        int numero= teclado.nextInt();
        
        if(numero!=0){
            
            mover();
            
        }else{
            
            System.out.println("");
            System.out.println("Has dejado de pedalear correctamente.");
            System.out.println("Has recorrido "+metrosRecorridos+ " metros.");
            
        }
        
    }
    
    @Override
    public void mover(){
        
        System.out.println("Se esta moviendo la bicicleta ....");
        metrosRecorridos=metrosRecorridos+5;
        preguntarMover();
        
    }
    
}
