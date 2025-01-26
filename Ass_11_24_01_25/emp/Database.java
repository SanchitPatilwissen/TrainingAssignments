package emp;

import java.util.*;
import java.io.*;

final class Database {
    LinkedHashMap<Integer, Employee> employees = new LinkedHashMap<Integer, Employee>();

    void readAll() {
        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser"));
            employees = (LinkedHashMap) ois.readObject();
            ois.close();
        }
        catch(FileNotFoundException e){
            System.out.println("No Employees to display!");
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }

    void appendAll() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.ser"));
            oos.writeObject(employees);
            oos.close();
        } catch (Exception e) {
            System.out.println("Not able to write to database!");
        }
    }    
}