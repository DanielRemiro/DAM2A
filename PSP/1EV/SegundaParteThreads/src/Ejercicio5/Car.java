package Ejercicio5;

public class Car extends Thread {
    private int id;
    private Parking parking;

    public Car(int id, Parking parking) {
        this.id = id;
        this.parking = parking;
    }

    @Override
    public void run() {
        try {
            System.out.println("Coche " + id + " listo para aparcar");
            parking.enter(id);

            // Simula tiempo aparcado (entre 1 y 3 segundos)
            Thread.sleep((long) (Math.random() * 2000 + 1000));

            parking.leave(id);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}