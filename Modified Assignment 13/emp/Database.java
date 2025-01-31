package emp;

// import java.sql.*;
import javax.sql.rowset.*;

public class Database {
    // static Connection con;
    // static Statement stmt;
    // static ResultSet rs;
    static JdbcRowSet rs;
    // static PreparedStatement pstm;
    
    static void initialize(){
        try{
            // if(con == null)
            //     con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee_management", "postgres", "tiger");
            // if(stmt == null)
            //     stmt = con.createStatement();
            if(rs == null){
                rs = RowSetProvider.newFactory().createJdbcRowSet();
                rs.setUrl("jdbc:postgresql://localhost:5432/employee_management");
                rs.setUsername("postgres");
                rs.setPassword("tiger");
            }

        }
        catch(Exception e){
            System.out.println(e);
        }

    } 

    static final void createEmployee(String name, int age, double salary, String designation, String department){
        try{
            // pstm = con.prepareStatement("insert into EMPLOYEE (ename, eage, esalary, edesignation, edepartment) values (?, ?, ?, ?, ?);");

            // pstm.setString(1, name);
            // pstm.setInt(2, age);
            // pstm.setDouble(3, salary);
            // pstm.setString(4, designation);
            // pstm.setString(5, department);

            // pstm.execute();

            rs.setCommand("SELECT * FROM EMPLOYEE"); // Select a table
            rs.execute();

            // Move to insert mode
            rs.moveToInsertRow();
            rs.updateString("ename", name);
            rs.updateInt("eage", age);
            rs.updateDouble("esalary", salary);
            rs.updateString("edesignation", designation);
            rs.updateString("edepartment", department);
            rs.insertRow(); // Insert the new row into the database

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final void display(String value) {

        try{
            String query = "select * from EMPLOYEE order by "+value+";";
            // rs = stmt.executeQuery(query);
            rs.setCommand(query);
            rs.execute();
            while(rs.next()){
                System.out.println("The following are the details of this Employee : \nID : "+rs.getString(1)+" \nName : " + rs.getString(2) + "\nAge : "
                    + rs.getString(3) + "\nSalary : " + rs.getString(4) + "\nDesignation : " + rs.getString(5) + "\nDepartment : "
                    + rs.getString(6));
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final void raiseSalary(int raise, int id) {
        try{
            String query = "SELECT * FROM EMPLOYEE WHERE eid = "+id+";";
            rs.setCommand(query);
            rs.execute();

            if (rs.next()) {
                // Update data in the row
                rs.updateDouble("esalary", rs.getDouble(4)+raise);
                rs.updateRow(); // Apply changes

                System.out.println("Row updated successfully!");
            }
            // stmt.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final int search(int id){
        try{
            String query = "select * from EMPLOYEE where eid = "+id+";";
            // rs = stmt.executeQuery(query);
            rs.setCommand(query);
            rs.execute();
            int count = 0;
            while(rs.next()){
                System.out.println("The following are the details of this Employee : \nID : "+rs.getString(1)+" \nName : " + rs.getString(2) + "\nAge : "
                    + rs.getString(3) + "\nSalary : " + rs.getString(4) + "\nDesignation : " + rs.getString(5) + "\nDepartment : "
                    + rs.getString(6));
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
            String query = "select * from EMPLOYEE where eid = "+id+";";
            // stmt.executeUpdate(query);
            rs.setCommand(query);
            rs.execute();

            if (rs.next()) {
                // Delete the row
                rs.deleteRow(); // Delete the current row
                System.out.println("Row deleted successfully!");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final void closing(){
        try{
            if(rs != null) rs.close();
            // if(stmt != null) stmt.close();
            // if(con != null) con.close();
            // if(pstm != null) pstm.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
