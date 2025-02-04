
import java.sql.*;

import org.json.JSONObject;

public class Database {

	static Connection con;
    static Statement stmt;
    static ResultSet rs;
    static PreparedStatement pstm;
    
    static void initialize(){
    	try{
    		if(con == null)
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Sales_database", "postgres", "tiger");
            if(stmt == null)
                stmt = con.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }

    } 

    static final void createEmployee(String name, int age, double salary, String designation, String department){
        try{
        	JSONObject jsonObj = new JSONObject();

            jsonObj.put("ename", name);
            jsonObj.put("eage", age);
            jsonObj.put("esalary", salary);
            jsonObj.put("edesignation", designation);
            jsonObj.put("edepartment", department);
            
            pstm = con.prepareStatement("insert into EMPLOYEES (data) values (?::jsonb);");

            pstm.setString(1, jsonObj.toString());

            pstm.execute();
            System.out.println("Employee Created");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final void display(String value) {

        try{
        	String query;
        	if(value.equals("id")) {
        		query = "select * from employees order by "+value+";";
        	}
        	else
        		query = "select * from employees order by data->>'"+value+"';";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getObject("data"));
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final void raiseSalary(int raise, int id) {
        try{
        	
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final long search(int id){
        try{
        	return 1;
        	
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }

    static final void remove(int id){
        try{
        	
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    

    static final void closing(){
    	try{
    		if(stmt != null) stmt.close();
            if(con != null) con.close();
            if(pstm != null) pstm.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
