package Ejercicio6;

class LegProducer implements Runnable {
    private WareHouse warehouse;

    public LegProducer(WareHouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(500); // Tiempo de producción
                warehouse.storeLeg();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BoardProducer implements Runnable {
    private WareHouse warehouse;

    public BoardProducer(WareHouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1200); // Producir un tablero es más lento
                warehouse.storeTabletop();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TableBuilder implements Runnable {
    private WareHouse warehouse;

    public TableBuilder(WareHouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                warehouse.buildTable();
                Thread.sleep(2000); // Tiempo ensamblando mesa
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}