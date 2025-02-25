package implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseController {
    static Connection con;
    static Statement stmt;
    static ResultSet rs;
    static PreparedStatement pstm;
    
    static void initialize(){
        try{
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CarMart", "postgres", "tiger");
            stmt = con.createStatement();

        }
        catch(Exception e){
            System.out.println(e);
        }

    } 

    static final void enterCar(Car car) {
        try {
            pstm = con.prepareStatement("INSERT INTO CAR (COMPANY_NAME, MODEL, SEATER, FUEL_TYPE, CAR_TYPE, PRICE, SOLD) values (?, ?, ?, ?, ?, ?, ?);");
    
            pstm.setString(1, car.getCompany());
            pstm.setInt(2, car.getModel());
            pstm.setInt(3, car.getSeater());
            pstm.setString(4, car.getFuelType().name()); 
            pstm.setString(5, car.getCarType().name());   
            pstm.setDouble(6, car.getPrice());
            pstm.setBoolean(7, car.isSold());  
            // Execute the SQL insert statement
            pstm.execute();
    
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

    static final void updatePrice(int raise, int id) {
        try{
            String query = "update car set price = "+raise+" where car_id = "+id+";";
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final void display() throws Exception{
        System.out.println("The following are the details of this Car : \nID : "+rs.getString(1)+" \nCompany : " + rs.getString(2) + "\nModel : "
                    + rs.getString(3) + "\nSeater : " + rs.getString(4) + "\nFuelType : " + rs.getString(5) + "\nCarType : "
                    + rs.getString(6)+"\nPrice : "+ rs.getString(7));
    }

    static final void allCarsUnsold(){
        try{
            String query = "select * from CAR where sold = false;";
            rs = stmt.executeQuery(query);
            System.out.println("Following are unsold cars");
            while(rs.next()){
                display();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final void companyWiseCars(String company){
        try{
            String query = "select * from CAR where company_name = "+company+";";
            rs = stmt.executeQuery(query);
            System.out.println("Following are "+company+" cars");
            while(rs.next()){
                display();
            }
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
            System.out.println("Exception occured while closing the Database resources!");
        }
    }
}
