
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
                System.out.println("ID : "+rs.getString(1)+" "+rs.getObject("data"));
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final void raiseSalary(int raise, int id) {
        try{
        	String query = "update EMPLOYEES set data = esalary+"+raise+" where eid = "+id+";";
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final int search(int id){
        try{
        	String query = "select * from employees where id = "+id+";";
        	rs = stmt.executeQuery(query);
            int count = 0;
            System.out.println("The following are the details of this Employee : ");
            while(rs.next()){
                System.out.println("ID : "+rs.getString(1)+" "+rs.getObject("data"));
                count++;
            }
            if(count==0){
                System.out.println("The entered ID doesn't exist!");
            }
            return count;
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }

    static final void remove(int id){
        try{
        	String query = "DELETE FROM EMPLOYEES WHERE id = "+id+";";
            stmt.executeUpdate(query);
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
