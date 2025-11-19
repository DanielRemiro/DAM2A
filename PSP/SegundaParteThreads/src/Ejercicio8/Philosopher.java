package Ejercicio8;

public class Philosopher implements Runnable {
    private int id;
    private Chopstick firstChopstick;
    private Chopstick secondChopstick;

    public Philosopher(int id, Chopstick first, Chopstick second) {
        this.id = id;
        this.firstChopstick = first;
        this.secondChopstick = second;
    }

    private void think() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        // Intenta coger el primer palillo
        synchronized (firstChopstick) {
            System.out.println("Filósofo " + id + " cogió el palillo " + firstChopstick.getId() + " (1/2).");

            Thread.sleep(100); // Pequeña pausa para evidenciar posibles bloqueos

            // Intenta coger el segundo palillo
            synchronized (secondChopstick) {
                System.out.println("Filósofo " + id + " cogió el palillo " + secondChopstick.getId() + " (2/2). COMIENDO.");
                Thread.sleep((long) (Math.random() * 1000));
            }

            System.out.println("Filósofo " + id + " soltó el palillo " + secondChopstick.getId());
        }
        System.out.println("Filósofo " + id + " soltó el palillo " + firstChopstick.getId());
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}