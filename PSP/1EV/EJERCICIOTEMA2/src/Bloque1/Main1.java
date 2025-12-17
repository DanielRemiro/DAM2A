package Bloque1;

public class Main1 {

    public static void main(String[] args) {
        Tic hiloTic = new Tic();
        Tac hiloTac = new Tac();

        hiloTic.start();
        hiloTac.start();
    }
}

class Tic extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("TIC");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println("Hilo TIC interrumpido: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Tac extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("TAC");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println("Hilo TAC interrumpido: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}