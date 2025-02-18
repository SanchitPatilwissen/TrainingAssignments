package com.example.demo;

import java.io.*;
import java.util.*;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

@Component
public final class Database {
	static HashMap<Integer, Employee> employees = new HashMap<Integer, Employee>();

    static void readAll(BeanFactory factory) {
        try {
            RandomAccessFile fr = new RandomAccessFile("employees.csv", "r");
            String line = null;
            while ((line = fr.readLine()) != null) {
                int id, age;
                String name;
                double salary;
                int num2 = 0;

                String[] arr = line.split(",");

                for(String s : arr) System.out.print(s+" ");
                System.out.println();

                id = Integer.parseInt(arr[0]);
                name = arr[1];
                age = Integer.parseInt(arr[2]);
                salary = Double.parseDouble(arr[4]); 

                if (arr[3] == "CLERK")
                    num2 = 1;
                else if (arr[3] == "PROGRAMMER")
                    num2 = 2;
                else if (arr[3] == "MANAGER")
                    num2 = 3;
            
                Menu.EmployeeCreation(num2, name, age, id, factory);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void appendAll() {
        String st = "";
        for (var id : employees.keySet()) {
            st = st + id + "," + employees.get(id).getName() + "," + employees.get(id).getAge() + ","
            + employees.get(id).getDesignation() + "," + employees.get(id).getSalary();
            st = st + "\n";
        }
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("employees.csv"));
            pw.println(st);
            pw.flush();
            pw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
