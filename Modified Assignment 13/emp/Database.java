package emp;

import java.sql.*;

public class Database {
    static Connection con;
    static Statement stmt;
    static ResultSet rs;
    static PreparedStatement pstm;
    
    static void initialize(){
        try{
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Employee_management", "postgres", "tiger");
            stmt = con.createStatement();

        }
        catch(Exception e){
            System.out.println(e);
        }

    } 

    static final void createEmployee(String name, int age, double salary, String designation, String department){
        try{
            pstm = con.prepareStatement("insert into EMPLOYEE (ename, eage, esalary, edesignation, edepartment) values (?, ?, ?, ?, ?);");

            pstm.setString(1, name);
            pstm.setInt(2, age);
            pstm.setDouble(3, salary);
            pstm.setString(4, designation);
            pstm.setString(5, department);

            pstm.execute();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final void display(String value) {

        try{
            String query = "select * from EMPLOYEE order by "+value+";";
            rs = stmt.executeQuery(query);
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
            String query = "update EMPLOYEE set esalary = esalary+"+raise+" where eid = "+id+";";
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final int search(int id){
        try{
            String query = "select * from EMPLOYEE where eid = "+id+";";
            rs = stmt.executeQuery(query);
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
            String query = "DELETE FROM EMPLOYEE WHERE eid = "+id+";";
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final void closing(){
        try{
            rs.close();
            stmt.close();
            con.close();
            pstm.close();
        }
        catch(Exception e){
            // System.out.println(e);
        }
    }
}
