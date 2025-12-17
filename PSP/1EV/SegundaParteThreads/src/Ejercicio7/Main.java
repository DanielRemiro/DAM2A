package Ejercicio7;

public class Main {
    // Constantes de configuración
    public static final int SOUP_CAPACITY = 4;
    public static final int TOTAL_CUSTOMERS = 12; // 12 clientes = 3 recargas exactas

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(SOUP_CAPACITY);

        // Iniciamos al Cocinero
        Chef chef = new Chef(restaurant);
        chef.setDaemon(true); // El cocinero morirá cuando terminen los clientes
        chef.start();

        // Iniciamos a los Clientes
        Thread[] customers = new Thread[TOTAL_CUSTOMERS];
        for (int i = 0; i < TOTAL_CUSTOMERS; i++) {
            customers[i] = new Thread(new Customer(i + 1, restaurant));
            customers[i].start();
        }

        // Esperamos a que todos coman
        try {
            for (int i = 0; i < TOTAL_CUSTOMERS; i++) {
                customers[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--- Todos los clientes han comido. El restaurante cierra. ---");
    }
}