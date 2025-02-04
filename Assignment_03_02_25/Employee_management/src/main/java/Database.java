import org.bson.Document;

import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;

public class Database {

    static MongoClient mongoClient;
    static MongoDatabase database;
    static MongoCollection collection;
    
    static void initialize(){
        try{
            if(mongoClient == null){
            	mongoClient = MongoClients.create("mongodb://localhost:27017");
            	database = mongoClient.getDatabase("EmployeeManagement");
        		collection = database.getCollection("Employees");
            }

        }
        catch(Exception e){
            System.out.println(e);
        }

    } 

    static final void createEmployee(int id, String name, int age, double salary, String designation, String department){
        try{
        	collection.insertOne(new Document().append("eid", id).append("ename", name).append("eage", age).append("esalary", salary).append("edesignation", designation).append("edepartment", department));
        	System.out.println("Successfully inserted");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final void display(String value) {

        try{
        	Bson projection = Projections.excludeId();
        	Bson sorter = Sorts.ascending(value);
        	FindIterable<Document> i = collection.find().projection(projection).sort(sorter);
        	
        	for(Document d : i) {
    			System.out.println(d.toJson());
    		}

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final void raiseSalary(int raise, int id) {
        try{
        	Bson filter = Filters.eq("eid", id);
    		Bson update = Updates.inc("esalary", raise);
    		
    		collection.updateOne(filter, update);
    		
    		System.out.println("Salary Raised successfully!");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final long search(int id){
        try{
        	Bson filter = Filters.eq("eid", id);
        	return collection.countDocuments(filter);
        	
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }

    static final void remove(int id){
        try{
        	Bson filter = Filters.eq("eid", id);
    		
    		collection.deleteOne(filter);
    		System.out.println("Employee Removed successfully!");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    static final boolean idExists(int id) {
    	try {
        	Bson filter = Filters.eq("eid", id);
        	if(collection.countDocuments(filter)==0) 
        		return false;
        	return true;
    	}
    	catch(Exception e) {
    		System.out.println(e);
    		return true;
    	}
    }

    static final void closing(){
        try{
            if(mongoClient != null)
            	mongoClient.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
