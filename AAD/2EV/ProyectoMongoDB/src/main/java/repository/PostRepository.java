package repository;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import modelos.Comentario;
import modelos.Post;
import org.bson.types.ObjectId;
import util.MongoDBUtil;

import java.util.ArrayList;
import java.util.List;

public class PostRepository {

    private final MongoCollection<Post> collection;

    public PostRepository() {
        MongoDatabase db = MongoDBUtil.getDatabase();

        this.collection = db.getCollection("posts", Post.class);
    }

    // --- CREATE ---
    public void guardarPost(Post post) {
        collection.insertOne(post);
        System.out.println("Post guardado con ID: " + post.getId());
    }

    // --- READ ---
    public List<Post> listarTodos() {
        List<Post> posts = new ArrayList<>();
        collection.find().into(posts);
        return posts;
    }

    public List<Post> buscarPorEtiqueta(String etiqueta) {
        List<Post> posts = new ArrayList<>();

        collection.find(Filters.eq("etiquetas", etiqueta)).into(posts);
        return posts;
    }

    // --- UPDATE ---
    public void agregarComentario(ObjectId idPost, Comentario comentario) {

        collection.updateOne(
                Filters.eq("_id", idPost),
                Updates.push("comentarios", comentario)
        );
        System.out.println("Comentario anadido.");
    }

    public void actualizarTitulo(ObjectId idPost, String nuevoTitulo) {
        collection.updateOne(
                Filters.eq("_id", idPost),
                Updates.set("titulo", nuevoTitulo)
        );
        System.out.println("Titulo actualizado.");
    }

    // --- DELETE ---
    public void eliminarPost(ObjectId idPost) {
        collection.deleteOne(Filters.eq("_id", idPost));
        System.out.println("Post eliminado.");
    }
}