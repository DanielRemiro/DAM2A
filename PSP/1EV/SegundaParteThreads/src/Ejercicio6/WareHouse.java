package Ejercicio6;

public class WareHouse {
    private final int MAX_LEGS = 6;
    private final int MAX_TABLETOPS = 2;

    private int legs = 0;
    private int tabletops = 0;

    public synchronized void storeLeg() throws InterruptedException {
        while (legs >= MAX_LEGS) {
            wait();
        }
        legs++;
        System.out.println("Pata almacenada. Patas actuales: " + legs);
        notifyAll();
    }

    public synchronized void storeTabletop() throws InterruptedException {
        while (tabletops >= MAX_TABLETOPS) {
            wait();
        }
        tabletops++;
        System.out.println("Tablero almacenado. Tableros actuales: " + tabletops);
        notifyAll();
    }

    public synchronized void buildTable() throws InterruptedException {
        while (legs < 4 || tabletops < 1) {
            System.out.println("Esperando materiales... (Patas: " + legs + ", Tableros: " + tabletops + ")");
            wait();
        }
        legs -= 4;
        tabletops -= 1;
        System.out.println("--- MESA FABRICADA --- (Stock restante: " + legs + " patas, " + tabletops + " tableros)");
        notifyAll();
    }
}