package Ejercicio6;

public class Main {
    public static void main(String[] args) {
        WareHouse warehouse = new WareHouse();

        // 1 Productor de patas
        Thread legProducer = new Thread(new LegProducer(warehouse));
        // 1 Productor de tableros
        Thread boardProducer = new Thread(new BoardProducer(warehouse));
        // 1 Fabricante de mesas
        Thread tableBuilder = new Thread(new TableBuilder(warehouse));

        legProducer.start();
        boardProducer.start();
        tableBuilder.start();
    }
}