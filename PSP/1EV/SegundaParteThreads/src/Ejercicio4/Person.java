package Ejercicio4;

public class Person implements Runnable {
    private Counter counter;

    public Person(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}