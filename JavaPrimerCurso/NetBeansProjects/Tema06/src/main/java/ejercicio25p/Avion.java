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

public class Avion implements Vehiculo{
    
    @Override
    public void preguntarMover(){
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Si quieres mover el avion tendras que acelerar y despegar.");
        
        System.out.println("Escribe un numero para que el avion acelere: ");
        int numeroAcelerar = teclado.nextInt();
        
        System.out.println("Escribe otro numero para despegar: ");
        int numeroDespegar=teclado.nextInt();
        
        mover();
        
    }
    
    @Override
    public void mover(){

        System.out.println("Se esta moviendo el avion ....");
       
    }
    
}
