package Bloque4;

public class Person implements Runnable {
    private static final int INCREMENT_ATTEMPTS = 1000;
    private final Counter sharedCounter;

    public Person(Counter counter) {
        this.sharedCounter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < INCREMENT_ATTEMPTS; i++) {
            sharedCounter.increment();
        }
    }
}