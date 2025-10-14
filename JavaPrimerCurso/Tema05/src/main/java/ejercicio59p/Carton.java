package ejercicio59p;

import java.util.Random;

public class Carton {

    Random random = new Random();
    int linea1[] = new int[10];
    int linea2[] = new int[10];
    int linea3[] = new int[10];

    public void setLinea1(int linea1[]) {
        this.linea1 = linea1;
    }

    public void setLinea2(int linea2[]) {
        this.linea2 = linea2;
    }

    public void setLinea3(int linea3[]) {
        this.linea3 = linea3;
    }

    void rellenarCarton() {
        for (int i = 0; i < linea1.length; i++) {
            linea1[i] = random.nextInt(10) + i * 10;
            linea2[i] = random.nextInt(10) + i * 10;
            linea3[i] = random.nextInt(10) + i * 10;
        }
        comprobarCarton();
    }

    void comprobarCarton() {
        for (int m = 0; m < linea1.length; m++) {
            while (linea1[m] == linea2[m] || linea1[m] == linea3[m] || linea2[m] == linea3[m]) {
                linea1[m] = random.nextInt(10) + m * 10;
                linea2[m] = random.nextInt(10) + m * 10;
                linea3[m] = random.nextInt(10) + m * 10;
            }
        }
        verCarton();
    }

    void verCarton() {
        for (int j = 0; j < linea1.length; j++) {
            System.out.print("x" + linea1[j]);
        }

        System.out.println("\n");

        for (int k = 0; k < linea2.length; k++) {
            System.out.print("x" + linea2[k]);
        }

        System.out.println("\n");

        for (int l = 0; l < linea3.length; l++) {
            System.out.print("x" + linea3[l]);
        }
        System.out.println("");
    }
}
