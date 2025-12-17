package Ejercicio7;

public class Restaurant {
    private int currentBowls = 0; // Empieza vacío para que el chef cocine al inicio
    private int capacity;

    public Restaurant(int capacity) {
        this.capacity = capacity;
    }

    // Método para el Cliente
    public synchronized void eatSoup(int customerId) throws InterruptedException {
        // Si no hay sopa, esperamos
        while (currentBowls == 0) {
            System.out.println("Cliente " + customerId + " esperando sopa...");
            wait();
        }

        currentBowls--;
        System.out.println("Cliente " + customerId + " comió sopa. Quedan: " + currentBowls);

        // Si tomé el último tazón, despierto al cocinero
        if (currentBowls == 0) {
            System.out.println(">>> ¡OIGA CHEF! ¡SE ACABÓ LA SOPA! <<<");
            notifyAll();
        }
    }

    // Método para el Cocinero
    public synchronized void prepareSoup() throws InterruptedException {
        // Si hay sopa, el chef duerme
        while (currentBowls > 0) {
            wait();
        }

        System.out.println("Cocinero: Preparando " + capacity + " tazones...");
        Thread.sleep(1500); // Simula tiempo de cocina
        currentBowls = capacity;
        System.out.println("Cocinero: ¡Sopa lista! A dormir.");

        // Despertamos a los clientes que esperaban
        notifyAll();
    }
}