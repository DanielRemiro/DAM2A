package Menus;

import Archivos.Binario;
import Archivos.Csv;
import Archivos.Xml;
import Interfaces.GuardarInformacion;
import Menus.MenuOpciones;

import java.util.Scanner;

public class MenuMain {

    private Scanner sc = new Scanner(System.in);

    public void Menu() {
        while (true) {
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1. Trabajar con Binario");
            System.out.println("2. Trabajar con CSV");
            System.out.println("3. Trabajar con XML");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            String opcion = sc.nextLine();

            GuardarInformacion gestor;

            switch (opcion) {
                case "1":
                    gestor = new Binario();
                    break;
                case "2":
                    gestor = new Csv();
                    break;
                case "3":
                    gestor = new Xml();
                    break;
                case "4":
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            // Llama al submenú
            MenuOpciones subMenu = new MenuOpciones(gestor);
            subMenu.Menu();
        }
    }
}
