package Ejercicio4;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread[] people = new Thread[10];

        for (int i = 0; i < 10; i++) {
            people[i] = new Thread(new Person(counter));
            people[i].start();
        }

        try {
            for (int i = 0; i < 10; i++) {
                people[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valor final del contador: " + counter.getCount());
    }
}