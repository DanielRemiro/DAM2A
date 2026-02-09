import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class Main {

    public static void main(String[] args) {

        MongoDatabase db = MongoDBUtil.getDatabase();
        MongoCollection<Document> col = db.getCollection("alumnos");

        // Embedded: direccion
        Document direccion = new Document()
                .append("calle", "Batalla de Lepanto 30")
                .append("ciudad", "Zaragoza")
                .append("cp", "50002");

        // Array simple: asignaturas
        List<String> asignaturas = List.of("AD", "PSP", "DI");

        // Array de embedded: notas[]
        List<Document> notas = new ArrayList<>();
        notas.add(new Document("modulo", "AD").append("nota", 8.5));
        notas.add(new Document("modulo", "PSP").append("nota", 7.0));

        Document alumno1 = new Document()
                // datos normales
                .append("nombre", "Lucía Pérez")
                .append("edad", 19)
                .append("repetidor", false)
                .append("ciclo", "DAM")
                // arrays
                .append("asignaturas", asignaturas)
                // embedded
                .append("direccion", direccion)
                // array de embedded
                .append("notas", notas);

        col.insertOne(alumno1);

        // Otro alumno (con menos campos, para ver flexibilidad)
        Document alumno2 = new Document()
                .append("nombre", "Mario Ruiz")
                .append("edad", 20)
                .append("repetidor", true)
                .append("ciclo", "DAW")
                .append("asignaturas", List.of("DWEC", "DWES"))
                .append("direccion", new Document("calle", "Mayor").append("ciudad", "Zaragoza").append("cp", "50001"));

        col.insertOne(alumno2);

        // LISTAR TODOS
        System.out.println("=== TODOS LOS ALUMNOS ===");
        col.find().forEach(doc -> System.out.println(doc.toJson()));

        // CONSULTA: SOLO DAM
        System.out.println("\n=== SOLO CICLO DAM ===");
        col.find(eq("ciclo", "DAM")).forEach(doc -> System.out.println(doc.toJson()));

        MongoDBUtil.close();
    }
}

