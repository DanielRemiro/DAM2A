package com.proyecto.main;

import com.proyecto.model.Producto;
import com.proyecto.repository.ProductoRepositoryJDBC;
import com.proyecto.repository.Repository;
import com.proyecto.service.GestorBaseDatos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- INICIO APP ---");

        // 1. Inicialización y Transacciones [cite: 12, 47]
        GestorBaseDatos gestor = new GestorBaseDatos();
        gestor.inicializar();

        // 2. Uso del Repository
        Repository<Producto> repo = new ProductoRepositoryJDBC();

        // 3. CRUD: Insertar (Create)
        System.out.println("\n--- INSERTANDO PRODUCTO ---");
        Producto p1 = new Producto("Portátil Gaming", 1200.50, 1); // Categoria 1 creada en init

        // Simulación carga imagen BLOB (asegúrate de tener una imagen de prueba o comenta esto)
        try {
            File file = new File("imagen_prueba.jpg");
            if(file.exists()) {
                p1.setImagen(Files.readAllBytes(file.toPath()));
                System.out.println("Imagen cargada en memoria.");
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo de imagen (no es crítico).");
        }

        repo.guardar(p1);
        System.out.println("Producto guardado.");

        // 4. CRUD: Listar (Read)
        System.out.println("\n--- LISTANDO PRODUCTOS ---");
        List<Producto> lista = repo.listar();
        lista.forEach(System.out::println);

        // 5. CRUD: Modificar (Update)
        if (!lista.isEmpty()) {
            System.out.println("\n--- MODIFICANDO PRODUCTO ---");
            Producto aModificar = lista.get(0);
            aModificar.setPrecio(999.99);
            repo.guardar(aModificar); // Al tener ID, hará UPDATE
        }

        // 6. CRUD: Eliminar (Delete)
        // repo.eliminar(1);
        // System.out.println("Producto eliminado");

        System.out.println("\n--- FIN APP ---");
    }
}