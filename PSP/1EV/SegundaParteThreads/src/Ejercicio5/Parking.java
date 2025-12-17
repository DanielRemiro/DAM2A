package Ejercicio5;

public class Parking {
    private int capacity;
    private int occupied;

    public Parking(int capacity) {
        this.capacity = capacity;
        this.occupied = 0;
    }

    public synchronized void enter(int carId) throws InterruptedException {
        while (occupied >= capacity) {
            System.out.println("Estacionamiento lleno, el coche " + carId + " tiene que esperar");
            wait();
        }

        occupied++;
        System.out.println("Coche " + carId + " ha aparcado");
    }

    public synchronized void leave(int carId) {
        occupied--;
        System.out.println("Coche " + carId + " ha dejado un espacio libre.");
        notifyAll();
    }
}