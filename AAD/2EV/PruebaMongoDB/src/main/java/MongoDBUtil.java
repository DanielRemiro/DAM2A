import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class MongoDBUtil {


    private static MongoClient client;
    private static MongoDatabase db;


    private MongoDBUtil() {}


    public static MongoDatabase getDatabase() {
        if (db == null) {
            ConnectionString cs = new ConnectionString("mongodb://localhost:27017/");


            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(cs)
                    .build();


            client = MongoClients.create(settings);
            db = client.getDatabase("centro_fp");
        }
        return db;
    }


    public static void close() {
        if (client != null) client.close();
        client = null;
        db = null;
    }
}
