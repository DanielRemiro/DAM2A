package Menus;

import Interfaces.GuardarInformacion;

import java.util.Scanner;

public class MenuOpciones {

    private GuardarInformacion gestor;
    private Scanner sc = new Scanner(System.in);

    public MenuOpciones(GuardarInformacion gestor) {
        this.gestor = gestor;
    }

    public void Menu() {
        while (true) {
            System.out.println("\n--- Submenú ---");
            System.out.println("1. Leer archivo");
            System.out.println("2. Escribir archivo");
            System.out.println("3. Volver al menú principal");
            System.out.print("Elige una opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    gestor.leer();
                    break;
                case "2":
                    System.out.print("Ingresa el objeto a guardar (como texto): ");
                    String obj = sc.nextLine();
                    gestor.escribir(obj);
                    break;
                case "3":
                    return; // vuelve al menú principal
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
