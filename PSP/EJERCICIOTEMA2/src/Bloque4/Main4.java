package Bloque4;

public class Main4 {
    private static final int NUM_PEOPLE = 10;
    private static final int ATTEMPTS_PER_PERSON = 1000;
    private static final int EXPECTED_COUNT = NUM_PEOPLE * ATTEMPTS_PER_PERSON;

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread[] peopleThreads = new Thread[NUM_PEOPLE];
        for (int i = 0; i < NUM_PEOPLE; i++) {
            Person personTask = new Person(counter);
            peopleThreads[i] = new Thread(personTask, "Person-" + (i + 1));
        }

        System.out.println("--- Simulación sin Sincronización ---");
        System.out.println("Intentos totales esperados: " + EXPECTED_COUNT);
        System.out.println("Iniciando " + NUM_PEOPLE + " hilos para incrementar el contador...");

        long startTime = System.currentTimeMillis();
        for (Thread t : peopleThreads) {
            t.start();
        }

        long endTime = System.currentTimeMillis();
        int finalCount = counter.getCount();

        System.out.println("-------------------------------------");
        System.out.println("Resultado final del contador: " + finalCount);
        System.out.println("Tiempo de simulación: " + (endTime - startTime) + "ms");

        if (finalCount != EXPECTED_COUNT) {
            System.err.println("\n*** ¡ERROR DE CONCURRENCIA ENCONTRADO! ***");
            System.err.println("El resultado NO coincide con los intentos esperados.");
            System.err.println("Diferencia: " + (EXPECTED_COUNT - finalCount));
        } else {
            System.out.println("\n[AVISO] Aunque el resultado coincida, la falta de sincronización \npuede causar fallos en otras ejecuciones.");
        }

        solveConcurrencyError(counter);
    }

    private static void solveConcurrencyError(Counter oldCounter) {
        System.out.println("\n\n--- Simulación con Sincronización (Solución) ---");

        // Usamos la nueva clase CounterSynchronized
        CounterSynchronized syncCounter = new CounterSynchronized();

        // Declarar e inicializar los hilos (personas)
        Thread[] syncPeopleThreads = new Thread[NUM_PEOPLE];
        for (int i = 0; i < NUM_PEOPLE; i++) {
            Person syncPersonTask = new Person(syncCounter);
            syncPeopleThreads[i] = new Thread(syncPersonTask, "Sync-Person-" + (i + 1));
        }

        System.out.println("Iniciando " + NUM_PEOPLE + " hilos con **synchronized**...");

        long startTime = System.currentTimeMillis();
        for (Thread t : syncPeopleThreads) {
            t.start();
        }

        try {
            for (Thread t : syncPeopleThreads) {
                t.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long endTime = System.currentTimeMillis();
        int finalCount = syncCounter.getCount();

        System.out.println("-------------------------------------");
        System.out.println("Resultado final del contador Sincronizado: " + finalCount);
        System.out.println("Tiempo de simulación: " + (endTime - startTime) + "ms");

        if (finalCount == EXPECTED_COUNT) {
            System.out.println("\n*** ¡SOLUCIÓN EXITOSA! ***");
            System.out.println("El resultado coincide exactamente con los intentos esperados.");
        } else {
            System.err.println("\n[ERROR] El error persistió. Revisa la implementación de synchronized.");
        }
    }
}

class CounterSynchronized extends Counter {

    @Override
    public synchronized void increment() {
        super.increment();
    }
}