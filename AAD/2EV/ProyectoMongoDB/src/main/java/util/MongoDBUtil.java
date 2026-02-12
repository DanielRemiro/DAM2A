package util;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoDBUtil {

    private static MongoClient client;
    private static MongoDatabase db;

    private MongoDBUtil() {}

    public static MongoDatabase getDatabase() {
        if (db == null) {

            CodecRegistry pojoCodecRegistry = fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build())
            );

            ConnectionString cs = new ConnectionString("mongodb://localhost:27017/");

            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(cs)
                    .codecRegistry(pojoCodecRegistry) // <--- ¡ESTA LÍNEA FALTABA!
                    .build();

            client = MongoClients.create(settings);

            db = client.getDatabase("blog_db");
        }
        return db;
    }

    public static void close() {
        if (client != null) {
            client.close();
            client = null;
            db = null;
        }
    }
}