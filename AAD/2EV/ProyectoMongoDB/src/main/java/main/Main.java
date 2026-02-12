package main;

import modelos.Comentario;
import modelos.Post;
import repository.PostRepository;
import util.MongoDBUtil;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PostRepository repo = new PostRepository();

        System.out.println("--- INICIO DEL BLOG ---");

        // CREATE
        Post post1 = new Post(
                "Bienvenido a Accesso a datos con Java y MongoDB",
                "Este es un post sobre MongoDB y Java",
                Arrays.asList("java", "mongodb", "sergio","mejorProfesor"),
                Date.from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault()).toInstant())
        );

        Post post2 = new Post(
                "Lenguajes de programacion",
                "Hoy aprendemos cobol",
                Arrays.asList("cobol", "oscar"),
                Date.from(LocalDateTime.now().minusDays(1).atZone(java.time.ZoneId.systemDefault()).toInstant())
        );

        repo.guardarPost(post1);
        repo.guardarPost(post2);

        //READ
        System.out.println("\n--- LISTA DE TODOS LOS POSTS ---");
        List<Post> todos = repo.listarTodos();
        todos.forEach(System.out::println);

        // UPDATE
        System.out.println("\n--- ANADIENDO COMENTARIO ---");

        repo.agregarComentario(post1.getId(), new Comentario("Profesor excelente, me encanta el curso"));

        // UPDATE
        System.out.println("\n--- MODIFICANDO TITULO ---");
        repo.actualizarTitulo(post1.getId(), "Bienvenida a Java y MongoDB Avanzado");

        // READ
        System.out.println("\n--- BUSCANDO POR ETIQUETA 'cobol' ---");
        List<Post> cocinaPosts = repo.buscarPorEtiqueta("cobol");
        cocinaPosts.forEach(System.out::println);

        // DELETE
        //System.out.println("\n--- ELIMINANDO EL SEGUNDO POST ---");
        //repo.eliminarPost(post2.getId());

        //FINAL
        System.out.println("\n--- LISTA FINAL ---");
        repo.listarTodos().forEach(System.out::println);

        MongoDBUtil.close();
    }
}