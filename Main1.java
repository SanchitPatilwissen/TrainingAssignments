import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;

enum Designation{
    CLERK,
    PROGRAMMER,
    MANAGER
}

class Employee{
    private String name;
    private Designation designation;
    private int age;
    private double salary;

    Employee(String name, int age, double salary, Designation designation){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.designation = designation;
    }

    String getName(){
        return this.name;
    }

    void display(){
        System.out.println("The following are the details of thiSs employee : \nName : "+ this.name + "\nAge : "+ this.age + "\nSalary : "+ this.salary + "\nDesignation : "+ this.designation);
    }

    void raiseSalary(int amt){
        salary = salary + amt;
    }
}

public class Main1{
    public static void main(String[] args) throws IOException{
        // Employee e = new Employee("Sanchit", 21, 25000.00, "Programmer");
        // e.display();

        Scanner sc = new Scanner(System.in);

        Boolean looping = true;
        
        ArrayList<Employee> employees = new ArrayList<Employee>();

        InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r);

        while(looping){
            System.out.print("1) Add Employee \n2) Increment Employee Salary \n3) Display All Employees \n4) Display a particular Employee \n5) Exit \nPick one number of the following : ");
            int num = sc.nextInt();

            if(num == 1){
                String name, designation;
                int age;
                double salary;

                System.out.print("Enter the name of Employee : ");
                name=br.readLine(); 
                System.out.print("Enter the age of Employee : ");
                age = sc.nextInt();
                System.out.print("Enter the salary of Employee : ");
                salary = sc.nextDouble();
                System.out.print("Enter the Designation of Employee : ");
                designation = sc.next();

                Designation val = Designation.CLERK;

                if(designation.equalsIgnoreCase("clerk")){
                    val = Designation.CLERK;
                }
                else if(designation.equalsIgnoreCase("programmer")){
                    val = Designation.PROGRAMMER;
                }
                else if(designation.equalsIgnoreCase("manager")){
                    val = Designation.MANAGER;
                }
                else{
                    System.out.println("Invalid Designation!");
                    System.out.println("\n ------------------------------------------------------------------------------------------------------------------");
                    continue;
                }

                Employee e = new Employee(name, age, salary, val);

                employees.add(e);
            }
            else if(num == 2){
                System.out.print("Enter the serial number of the Employee : ");
                int index = sc.nextInt();

                if(index>employees.size()){
                    System.out.println("Index out of bound");
                    continue;
                }

                System.out.print("Enter the amount by which you want to increment : ");
                int amt = sc.nextInt();

                employees.get(index-1).raiseSalary(amt);
            }
            else if(num == 3){

                System.out.println("The Employees are : ");
                for(int i = 0; i<employees.size();i++){
                    System.out.println((i+1)+") "+employees.get(i).getName());
                }
            }
            else if(num == 4){
                System.out.print("Enter the serial number of the Employee : ");
                int index = sc.nextInt();

                if(index>employees.size()){
                    System.out.println("Index out of bound");
                    continue;
                }

                employees.get(index-1).display();
            }
            else if(num == 5){
                looping = false;
            }
            else{
                System.out.println("Please Enter a valid number!");
            }

            System.out.println("\n ------------------------------------------------------------------------------------------------------------------");
        }

        sc.close();
    }
}