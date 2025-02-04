import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

public class Searching<T> extends Database {
    final void search(T val, String parameter) {
        try {
            Bson filter = Filters.eq(parameter, val);
            Bson projection = Projections.excludeId();
            FindIterable<Document> i = collection.find(filter).projection(projection);
    		
    		for(Document d : i) {
    			System.out.println(d.toJson());
    		}
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
