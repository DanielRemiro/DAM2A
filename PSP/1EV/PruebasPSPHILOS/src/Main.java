class LifeOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount;

    public LifeOff() {}

    public LifeOff(int countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println("#" + id + "(" + countDown + "), ");
            countDown--;
        }
        System.out.println("Lanzamiento {" + id + "}!");
    }


}


public class Main  {

    public static void main(String[] args) {

        LifeOff lifeOff = new LifeOff();
        lifeOff.run();

        LifeOff lifeOff2 = new LifeOff();
        lifeOff2.run();

        LifeOff lifeOff3 = new LifeOff();
        lifeOff3.run();

        System.out.println("Comienza la cuenta atras");


    }

}
