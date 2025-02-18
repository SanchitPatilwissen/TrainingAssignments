package com.example.demo;

import java.io.BufferedReader;
import java.util.*;
import java.io.*;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

@Component
public class Main {
	public static void main(String[] args, BeanFactory factory) throws Exception {

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        // Employee employees[] = new Employee[1000];
        // HashMap<Integer, Employee> employees = new HashMap<Integer, Employee>();
        Database.readAll(factory);

        Boolean looping = true;

        while (looping) {
            System.out.println(
                    "-------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.print(
                    "1) Create \n2) Display \n3) Raise Salary \n4) Remove \n5) Search \n6) Exit \nPick one number of the following : ");
            int num = Menu.readChoice(1, 6);

            if (num == 1) {
                boolean subloop = true;

                while (subloop) {
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.print(
                            "1) Clerk \n2) Programmer \n3) Manager \n4) CEO \n5) Exit \nPick one number of the following : ");
                    int num2 = Menu.readChoice(1, 5);

                    if (num2 == 5) {
                        subloop = false;
                        break;
                    }
                    System.out.print("Enter the id of the employee : ");
                    int id = Menu.readChoice(0, 10000000);

                    if (Database.employees.get(id) != null) {
                        System.out.println("The id you entered already exists!");
                        System.out.println("-----------------------------------------------------------------------");
                        continue;
                    }
                    Menu.InputData(num2, id, factory);
                }
            } else if (num == 2) {
                int count = 0;
                System.out.print(
                        "On what basis do you want to sort the employees \n1) id \n2) Name \n3) Age \n4) Salary \n5) Designation \nChoose one of the above : ");
                int sortingOrder = Menu.readChoice(1, 5);

                TreeSet<Employee> sortedEmployees = null;

                switch (sortingOrder) {
                    case 1:
                    sortedEmployees = new TreeSet<Employee>(new IDSorter());
                    break;
                    case 2:
                    sortedEmployees = new TreeSet<Employee>(new NameSorter());
                    break;
                    case 3:
                    sortedEmployees = new TreeSet<Employee>(new AgeSorter());
                    break;
                    case 4:
                    sortedEmployees = new TreeSet<Employee>(new SalarySorter());
                    break;
                    case 5:
                    sortedEmployees = new TreeSet<Employee>(new DesignationSorter());
                }
                
                for (var id : Database.employees.keySet()) {
                    sortedEmployees.add(Database.employees.get(id));
                }
                
                for (var emp : sortedEmployees) {
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("Employee " + emp.getId());
                    emp.display();
                    count++;
                }
                if (count == 0)
                    System.out.println("No Employees to Display");
            } else if (num == 3) {
                for (var id : Database.employees.keySet()) {
                    if (Database.employees.get(id) != null) {
                        ((Employee) Database.employees.get(id)).raiseSalary();
                    }
                }
            } else if (num == 4) {
                System.out.print("Enter the id of the employee you want to remove : ");
                int removeId = Menu.readChoice(0, 10000000);

                if (Database.employees.get(removeId) == null) {
                    System.out.println("The Employee ID you entered doesn't exist!");
                } else {
                    System.out.println("-----------------------------------------------------------------");
                    ((Employee) Database.employees.get(removeId)).display();
                    System.out.print("Do you realy want to remove this employee : ");
                    String response = br.readLine();
                    if (response.charAt(0) == 'Y' || response.charAt(0) == 'y') {
                        Database.employees.remove(removeId);
                        System.out.println("The Employee is successfully removed!");
                    }
                }
            } else if (num == 5) {
                System.out.print(
                        "On what basis do you want to search the employees \n1) id \n2) Name \n3) Age \n4) Salary \n5) Designation \nChoose one of the above : ");
                int searchingOrder = Menu.readChoice(1, 5);

                System.out.print("Enter the ID of the employee you want to search : ");
                int searchId = Menu.readChoice(0, 10000000);
                TreeSet<Employee> sortedEmployees = null;
                if (Database.employees.get(searchId) == null)
                    System.out.println("No employee of this ID exists!");
                else {
                    System.out.println("-----------------------------------------------------------------");
                    ((Employee) Database.employees.get(searchId)).display();
                }
            } else if (num == 6) {
                looping = false;
            } else {
                System.out.println("Please enter a valid number (1-5)!");
            }
        }
        Database.appendAll();
    }
}
