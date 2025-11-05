class LifeOff2 extends Thread {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LifeOff2() {}

    public LifeOff2(int countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print("#" + id + "(" + countDown + "), ");
            Thread.yield();
        }
        System.out.println("Lanzamiento {" + id + "}!");
    }
}

public class Main2 {

    public static void main(String[] args) {

        Thread t1 = new Thread(new LifeOff2());
        Thread t2 = new Thread(new LifeOff2());
        Thread t3 = new Thread(new LifeOff2());

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Comienza la cuenta atras (dicho desde el hilo main)");
    }
}

