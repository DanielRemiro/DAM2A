package Ejercicio9;

import java.util.Scanner;

public class Restaurante {
    
    private Mesa[] mesas = new Mesa[10];
    
    private Scanner teclado = new Scanner(System.in);

    public Restaurante() {
        
        for (int i = 0; i < mesas.length; i++) {
            
            mesas[i] = new Mesa();
            
        }
        
    }

    public void iniciar() {
        
        boolean salir = false;

        while (salir==false) {
            
            System.out.println("\n1. Llegada de clientes");
            System.out.println("2. Liberar mesa");
            System.out.println("3. Ver estado de las mesas");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            
            int opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                
                case 1 -> llegadaClientes();
                case 2 -> liberarMesa();
                case 3 -> verMesas();
                case 4 -> salir = true;
                default -> System.out.println("Opcion no valida.");
                
            }
            
        }
        
    }

    private void llegadaClientes() {
        
        System.out.print("¿Cuantos comensales son?: ");
        
        int comensales = teclado.nextInt();
        
        teclado.nextLine();

        if (comensales > 4) {
            
            System.out.println("Lo siento, solo grupos de 4 personas como maximo.");
            
            return;
            
        }

        for (int i = 0; i < mesas.length; i++) {
            
            if (mesas[i].estaLibre()) {
                
                mesas[i].setSillas(comensales);
                
                System.out.println("Mesa " + (i + 1) + " reservada para " + comensales + " personas.");
                
                System.out.println("-------------------------");
                
                verMesas();
                
                return;
                
            }
            
        }

        System.out.println("Lo siento, no quedan mesas libres.");
        
    }

    private void liberarMesa() {
        
        System.out.print("¿Qué mesa quieres liberar? (1-10): ");
        
        int numero = teclado.nextInt();
        teclado.nextLine();

        if (numero < 1 || numero > 10) {
            
            System.out.println("Número de mesa no valido.");
            
            return;
            
        }

        mesas[numero - 1].liberarMesa();
        
        System.out.println("Mesa " + numero + " liberada.");
        
        System.out.println("-------------------------");
        
        verMesas();
        
    }

    private void verMesas() {
        
        for (int i = 0; i < mesas.length; i++) {
            
            System.out.println("Mesa " + (i + 1) + ": " +(mesas[i].estaLibre() ? "Libre" : mesas[i].getSillas() + " comensales"));
        
        }
        
    }
    
}
