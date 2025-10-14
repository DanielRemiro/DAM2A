package ejercicio59p;

import java.util.Random;

public class Bombo {

    Random random = new Random();
    int numerosUsados[] = new int[100];
    int contador = 0;
    private int[] linea1;
    private int[] linea2;
    private int[] linea3;

    public void setCarton(int[] linea1, int[] linea2, int[] linea3) {
        this.linea1 = linea1;
        this.linea2 = linea2;
        this.linea3 = linea3;
    }

    void tirarDelBombo() {
        while (linea1Completa() && linea2Completa() && linea3Completa()) {
            int numero = random.nextInt(101);
            numerosUsados[contador] = numero;
            verNumeroBombo();
            comprobarNumeroCarton();
            contador++;
        }
    }

    void comprobarNumeroCarton() {
        for (int i = 0; i < linea1.length; i++) {
            if (numerosUsados[contador - 1] == linea1[i]) {
                linea1[i] = 0;
            }
        }

        for (int i = 0; i < linea2.length; i++) {
            if (numerosUsados[contador - 1] == linea2[i]) {
                linea2[i] = 0;
            }
        }

        for (int i = 0; i < linea3.length; i++) {
            if (numerosUsados[contador - 1] == linea3[i]) {
                linea3[i] = 0;
            }
        }
        comprobarCartonCero();
    }

    void comprobarCartonCero() {
        boolean linea1Completa = true;
        boolean linea2Completa = true;
        boolean linea3Completa = true;

        for (int i = 0; i < linea1.length; i++) {
            if (linea1[i] != 0) {
                linea1Completa = false;
            }
        }

        for (int i = 0; i < linea2.length; i++) {
            if (linea2[i] != 0) {
                linea2Completa = false;
            }
        }

        for (int i = 0; i < linea3.length; i++) {
            if (linea3[i] != 0) {
                linea3Completa = false;
            }
        }

        if (linea1Completa) {
            System.out.println("¡Línea 1 COMPLETA!");
        }

        if (linea2Completa) {
            System.out.println("¡Línea 2 COMPLETA!");
        }

        if (linea3Completa) {
            System.out.println("¡Línea 3 COMPLETA!");
        }

        if (linea1Completa && linea2Completa && linea3Completa) {
            System.out.println("Has ganado el bingo");
        }
    }

    boolean linea1Completa() {
        boolean linea1Completa = true;
        for (int i = 0; i < linea1.length; i++) {
            if (linea1[i] != 0) {
                linea1Completa = false;
            }
        }
        return linea1Completa;
    }

    boolean linea2Completa() {
        boolean linea2Completa = true;
        for (int i = 0; i < linea2.length; i++) {
            if (linea2[i] != 0) {
                linea2Completa = false;
            }
        }
        return linea2Completa;
    }

    boolean linea3Completa() {
        boolean linea3Completa = true;
        for (int i = 0; i < linea3.length; i++) {
            if (linea3[i] != 0) {
                linea3Completa = false;
            }
        }
        return linea3Completa;
    }

    void verNumeroBombo() {
        System.out.println("Bombo= " + numerosUsados[contador - 1]);
    }
}
