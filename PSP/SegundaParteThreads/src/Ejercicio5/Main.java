package Ejercicio5;

public class Main {
    public static void main(String[] args) {
        // Parking con capacidad para 3 coches
        Parking parking = new Parking(3);

        // Creamos 6 coches para forzar la espera
        int numberOfCars = 6;

        for (int i = 1; i <= numberOfCars; i++) {
            new Car(i, parking).start();
        }
    }
}