package Ejercicio8;

public class Main {
    public static void main(String[] args) {
        int numberOfPhilosophers = 5;
        Chopstick[] chopsticks = new Chopstick[numberOfPhilosophers];
        Thread[] philosophers = new Thread[numberOfPhilosophers];

        for (int i = 0; i < numberOfPhilosophers; i++) {
            chopsticks[i] = new Chopstick(i);
        }

        for (int i = 0; i < numberOfPhilosophers; i++) {
            Chopstick leftChopstick = chopsticks[i];
            Chopstick rightChopstick = chopsticks[(i + 1) % numberOfPhilosophers];

            // SOLUCIÓN AL DEADLOCK:
            // El último filósofo coge los palillos en orden inverso (Izquierda -> Derecha)
            // Los demás cogen en orden normal (Derecha -> Izquierda)
            if (i == numberOfPhilosophers - 1) {
                philosophers[i] = new Thread(new Philosopher(i, leftChopstick, rightChopstick));
            } else {
                philosophers[i] = new Thread(new Philosopher(i, rightChopstick, leftChopstick));
            }

            philosophers[i].start();
        }
    }
}