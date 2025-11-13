package Bloque2;

import java.util.Random;
import java.util.Scanner;

public class Main2 {

    static int puntuacion = 0;

    public static void main(String[] args) {

        JuegoSuma juegoThread = new JuegoSuma();
        juegoThread.start();

        System.out.println("Comienzo de la Calculadora Humana en ...");

        try {
            for (int i = 3; i > 0; i--) {
                System.out.println(i + "...");
                Thread.sleep(1000);
            }
            System.out.println("¡Empezamos!");

            Thread.sleep(10000);

        } catch (InterruptedException e) {
            System.err.println("Hilo principal interrumpido.");
            Thread.currentThread().interrupt();
        }

        juegoThread.interrupt();

        try {
            juegoThread.join(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Fin del juego, puntuacion: " + puntuacion);
    }
}

class JuegoSuma extends Thread {

    private Random random = new Random();

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (!Thread.currentThread().isInterrupted()) {
            try {
                int num1 = random.nextInt(90) + 10;
                int num2 = random.nextInt(90) + 10;
                int respuestaCorrecta = num1 + num2;

                System.out.print(num1 + " + " + num2 + " = ");

                if (scanner.hasNextInt()) {
                    int respuestaUsuario = scanner.nextInt();

                    if (respuestaUsuario == respuestaCorrecta) {
                        Main2.puntuacion++;
                        System.out.println("¡Correcto!");
                    } else {
                        System.out.println("¡Respuesta incorrecta!");
                    }
                } else {
                    System.out.println("Por favor, introduce solo números.");
                    scanner.next();
                }

            } catch (java.util.NoSuchElementException | IllegalStateException e) {
                break;
            }
        }
        scanner.close();
    }
}