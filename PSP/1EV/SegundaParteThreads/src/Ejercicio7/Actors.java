package Ejercicio7;

class Chef extends Thread {
    private Restaurant restaurant;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (true) {
                restaurant.prepareSoup();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Customer implements Runnable {
    private int id;
    private Restaurant restaurant;

    public Customer(int id, Restaurant restaurant) {
        this.id = id;
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            // Simula un tiempo aleatorio de llegada
            Thread.sleep((long) (Math.random() * 1000));
            restaurant.eatSoup(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}