package implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class DatabaseController {
    static Connection con;
    static Statement stmt;
    static ResultSet rs;
    static PreparedStatement pstm;
    
    static void initialize(){
        try{
            // Class.forName("org.postgres.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CarMart", "postgres", "tiger");
            stmt = con.createStatement();

        }
        catch(Exception e){
            System.out.println(e);
        }

    } 

    static final void enterCar(Car car) {
        try {
            pstm = con.prepareStatement("INSERT INTO CAR (COMPANY_NAME, MODEL, SEATER, FUEL_TYPE, CAR_TYPE, PRICE, SOLD) values (?, ?, ?, ?::car_fuel_type, ?::car_type_values, ?, ?);");
            String fuelType = car.getFuelType().name();
            String carType = car.getCarType().name();

            pstm.setString(1, car.getCompany());
            pstm.setInt(2, car.getModel());
            pstm.setInt(3, car.getSeater());
            pstm.setString(4, fuelType); 
            pstm.setString(5, carType);   
            pstm.setDouble(6, car.getPrice());
            pstm.setBoolean(7, car.isSold());  

            // Execute the SQL insert statement
            pstm.execute();
    
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

    static final void updatePrice(double newPrice, int id) {
        try{
            String query = "update car set price = "+newPrice+" where car_id = "+id+";";
            stmt.executeUpdate(query);
            System.out.println("Record Updated");
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

    static final Set<String> allCompanies(){
        try{
            Set<String> companies = new HashSet<>();
            String query = "select * from COMPANY;";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                companies.add(rs.getString(1));
            }
            return companies;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    static final void allCarsSold(){
        try{
            String query = "select * from CAR where sold = true;";
            rs = stmt.executeQuery(query);
            System.out.println("Following are sold cars");
            while(rs.next()){
                display();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final boolean isExists(int id){
        try{
            String query = "select * from CAR where car_id = "+id+";";
            rs = stmt.executeQuery(query);
            System.out.println("Following are the details of this car");
            boolean exists = false;
            while(rs.next()){
                display();
                exists = true;
            }
            return exists;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    static final void companyWiseCars(String company){
        try{
            String query = "select * from CAR where company_name = '"+company+"';";
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

    static final void typeWiseCars(CarType type){
        try{
            String query = "select * from CAR where car_type = '"+type.name()+"';";
            rs = stmt.executeQuery(query);
            System.out.println("Following are "+type+" cars");
            while(rs.next()){
                display();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final void sold(int id) {
        try{
            String query = "update car set sold = true where car_id = "+id+";";
            stmt.executeUpdate(query);
            System.out.println("Record Updated");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    static final void rangeWiseCars(int mini, int maxi){
        try{
            String query = "select * from CAR where price between "+mini+" and "+maxi+";";
            rs = stmt.executeQuery(query);
            System.out.println("Following are cars in desired range : ");
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
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(con != null) con.close();
            if(pstm != null) pstm.close();
        }
        catch(Exception e){
            System.out.println("Exception occured while closing the Database resources!");
        }
    }

}
