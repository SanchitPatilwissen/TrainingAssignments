package com.example.demo.control;

import java.sql.*;

public class Database {
    static Connection con;
    static Statement stmt;
    static ResultSet rs;
    static PreparedStatement pstm;
    
    static void initialize(){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Authentication", "postgres", "tiger");
            stmt = con.createStatement();
            System.out.println("Database Initialized");
        }
        catch(Exception e){
            System.out.println(e);
        }

    } 

    static final void createCustomer(String id, String name, String pwd){
        try{
            pstm = con.prepareStatement("insert into authentication_details (id, name, password) values (?, ?, ?);");

            pstm.setString(1, id);
            pstm.setString(2, name);
            pstm.setString(3, pwd);

            pstm.execute();
            
            System.out.println("Customer created");

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static final boolean isIdPresent(String id){
        try{
            String query = "select * from authentication_details where id = '"+id+"';";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                return true;
            }
            return false;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    static final boolean search(String id, String pwd){
        try{
            String query = "select * from authentication_details where id = '"+id+"';";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                if(rs.getString(3).equals(pwd)) {
                	return true;
                }
                else {
                	return false;
                }
            }
            return false;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    static final String getName(String id) {
    	try{
            String query = "select * from authentication_details where id = '"+id+"';";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                return rs.getString(2);
            }
            return "";
        }
        catch(Exception e){
            System.out.println(e);
            return "";
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
            System.out.println(e);
        }
    }
}
