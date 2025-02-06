


public class Searching<T> extends Database {
    final void search(T val, String parameter) {
        try {
        	String query;
            if(val.getClass() == String.class)
                query = "select * from EMPLOYEES where UPPER(data->>'" + parameter + "') like '" + val + "%';";
            else 
                query = "select * from EMPLOYEES where data->>'" + parameter + "' = '" + val + "';";
         
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {
            	System.out.println("ID : "+rs.getString(1)+" "+rs.getObject("data"));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
