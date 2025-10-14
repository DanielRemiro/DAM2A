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

public class Coche implements Vehiculo{
    
    @Override
    public void preguntarMover(){
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Si quieres mover el coche tendras que meter marcha y acelerar.");
        
        System.out.println("Escribe un numero para meter primera marcha ");
        int numeroMarcha = teclado.nextInt();
        
        System.out.println("Escribe otro numero para acelerar: ");
        int numeroAcelerar=teclado.nextInt();
        
        mover();
        
    }
    
    @Override
    public void mover(){

        System.out.println("Se esta moviendo el coche ....");
       
    }
    
}
