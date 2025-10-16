package Ejecutar;

import Menus.MenuMain;
import Procesos.GestionTareas;

import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int eleccion;
        GestionTareas gestionTareas = new GestionTareas();

        gestionTareas.agregarTareasProvisional();

        do {

            MenuMain.Menu();
            System.out.print("Elige una opción: ");
            eleccion = sc.nextInt();

            switch (eleccion) {
                case 1:
                    gestionTareas.agregarTarea();
                    break;

                case 2:
                    gestionTareas.eliminarTarea();
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        } while (eleccion != 3);

    }
}
