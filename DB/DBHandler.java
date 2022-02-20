package DB;
import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import java.util.HashMap;
import java.util.Map;

public class DBHandler{
	static MongoClient client = MongoClients.create(System.getenv("MONGO_DB_URL"));
	static MongoDatabase database = client.getDatabase("Credentials");
	public static MongoCollection<Document> user_collection = database.getCollection("Users");
	public static MongoCollection<Document> notes_collection = database.getCollection("Notes");
	public static int createUser(String email, String passwd){
		try{
			System.out.println(email + " " + passwd);
			Document document = new Document("Email", email)
			.append("Password",passwd);
			user_collection.insertOne(document);
			return 1;
	    }catch(Exception e){
			return 0;
		}

	}
	public static long checkUser(String email, String passwd){
		try{
			System.out.println(email + " " + passwd);
			Document email_doc = new Document("Email", email);
			Document passwd_doc = new Document("Password", passwd);
			long result = user_collection.countDocuments(Filters.and(email_doc,passwd_doc));
			return result;
	    }catch(Exception e){
			return 0;
		}

	}
	public static int storePost(String email, String title, String cipher){
		try{
			Document document = new Document("Email", email)
			.append("Title",title)
			.append("Cipher",cipher);
			notes_collection.insertOne(document);
			return 1;
	    }catch(Exception e){
			return 0;
		}

	}
	public static int editPost(String email, String title, String cipher, String id){
		try{
			Document document = new Document("Email",email).append("_id",new ObjectId(id));
			UpdateResult opt = notes_collection.updateOne(Filters.and(Filters.eq("Email",email),Filters.eq("_id",new ObjectId(id))), Updates.combine(Updates.set("Title",title),Updates.set("Cipher",cipher)));
			return 1;
	    }catch(Exception e){
			return 0;
		}

	}
	public static MongoCursor<Document> getPost(String email){
		FindIterable<Document> fi = notes_collection.find(Filters.eq("Email",email));      
        MongoCursor<Document> cursor = fi.iterator();
		return cursor;
    }
}