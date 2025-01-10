package emp;

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

abstract class Employee{
    private int emp_id;
    private String name;
    private int age;
    double salary;
    private Designation designation;
 
    Employee(String var1, int var2, double var3, Designation var4, int var5) {
        this.name = var1;
        this.age = var2;
        this.salary = var3;
        this.designation = var4;
        this.emp_id = var5;
    }

    final int getId(){
        return this.emp_id;
    }
 
    final void display() {
        System.out.println("\n");
        System.out.println("The following are the details of this Employee : \nName : " + this.name + "\nAge : " + this.age + "\nSalary : " + this.salary + "\nDesignation : "+this.designation);
        System.out.println("\n\n");
    }
 
    abstract void raiseSalary();
}

final class Clerk extends Employee{
    Clerk(String name, int age, Designation designation, int id){
        super(name, age, 20000, designation, id);
    }

    void raiseSalary() {
        salary += 2000;
    }
}

final class Programmer extends Employee{
    Programmer(String name, int age, Designation designation, int id){
        super(name, age, 30000, designation, id);
    }

    void raiseSalary() {
        salary += 5000;
    }
}

final class Manager extends Employee{
    Manager(String name, int age, Designation designation, int id){
        super(name, age, 100000, designation, id);
    }

    void raiseSalary() {
        salary += 15000;

    }
}


public class Main {

    static int idExists(Employee[] employees, int id){
        if(employees[id] == null)
            return -1;
        return id;
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        Boolean looping = true;

        Employee employees[] = new Employee[1000];

        InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r);

        while(looping){
            System.out.print("1) Create \n2) Display \n3) Raise Salary \n4) Remove \n5) Exit \nPick one number of the following : ");
            int num = sc.nextInt();

            if(num == 1){
                boolean subloop = true;

                while(subloop){
                    System.out.print("\n1) Clerk \n2) Programmer \n3) Manager \n4) Exit \nPick one number of the following : ");
                    int num2 = sc.nextInt();

                    if(num2 == 4){
                        subloop = false;
                        break;
                    }

                    System.out.print("Enter the id of the employee : ");
                    int id = sc.nextInt();

                    if(idExists(employees, id) != -1){
                        System.out.println("The id you entered already exists!");
                        System.out.println("-----------------------------------------------------------------------");
                        continue;
                    }

                    System.out.print("Enter the name of Employee : ");
                    String name= br.readLine(); 
                    System.out.print("Enter the age of Employee : ");
                    int age = sc.nextInt();

                    if(num2 == 1){
                        Employee c = new Clerk(name, age, Designation.CLERK, id);
                        employees[id] = c;
                    }
                    else if(num2 == 2){
                        Employee c = new Programmer(name, age, Designation.PROGRAMMER, id);
                        employees[id] = c;
                    }
                    else if(num2 == 3){
                        Employee c = new Manager(name, age, Designation.MANAGER, id);
                        employees[id] = c;
                    }
                    else{
                        System.out.println("Please enter a valid number!");
                    }
                    System.out.println("-----------------------------------------------------------------------");

                }
            }
            else if(num == 2){
                for(int i=0;i<employees.length;i++){
                    if(employees[i] != null){
                        System.out.println("Employee "+i);
                        employees[i].display();
                    }
                }
            }
            else if(num == 3){
                for(int i=0;i<employees.length;i++){
                    if(employees[i] != null){
                        employees[i].raiseSalary();
                    }
                }
            }
            else if(num == 4){
                System.out.print("Enter the id of the employee you want to remove : ");
                int removeId = sc.nextInt();

                int temp = idExists(employees, removeId);

                if(temp == -1){
                    System.out.println("The Employee ID you entered doesn't exist!");
                }
                else{
                    employees[temp].display();
                    System.out.print("Do you realy want to remove this employee : ");
                    String response = br.readLine();
                    if(response.charAt(0) == 'Y' || response.charAt(0) == 'y'){
                        employees[temp] = null;
                        System.out.println("The Employee is successfully removed!");
                    }
                }
            }
            else if(num == 5){
                looping = false;
            }
            else{
                System.out.println("Please enter a valid number!");
            }
            System.out.println("-----------------------------------------------------------------------");
        }

        sc.close();
    }
    
}