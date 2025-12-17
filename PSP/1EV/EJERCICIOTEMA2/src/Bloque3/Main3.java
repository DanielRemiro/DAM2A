package Bloque3;

public class Main3 {

    public static void main(String[] args) {

        HiloGenerico hiloMultiplicacion = new HiloGenerico(1, 2, "multiplicar");

        HiloGenerico hiloSuma = new HiloGenerico(1, 2, "sumar");

        hiloMultiplicacion.start();
        hiloSuma.start();

        try {

            hiloMultiplicacion.join();
            hiloSuma.join();

            double resultado1 = hiloMultiplicacion.getResultado();
            double resultado2 = hiloSuma.getResultado();

            if (resultado2 == 0) {
                System.out.println("Error: División por cero.");
            } else {
                double resultadoFinal = resultado1 / resultado2;
                System.out.println("El resultado final (con Thread) es: " + resultadoFinal);
            }

        } catch (InterruptedException e) {
            System.err.println("Hilo principal interrumpido.");
            Thread.currentThread().interrupt();
        }
    }
}

class HiloGenerico extends Thread {

    private double num1;
    private double num2;
    private String operacion;
    private double resultado;

    public HiloGenerico(double num1, double num2, String operacion) {
        this.num1 = num1;
        this.num2 = num2;
        this.operacion = operacion;
        this.resultado = 0;
    }

    @Override
    public void run() {
        switch (operacion) {
            case "multiplicar":
                this.resultado = this.num1 * this.num2;
                break;
            case "sumar":
                this.resultado = this.num1 + this.num2;
                break;

            default:
                System.err.println("Operación no válida: " + operacion);
        }
    }

    public double getResultado() {
        return this.resultado;
    }
}