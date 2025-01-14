package emp;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
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

class ChoiceException extends RuntimeException{
    ChoiceException(){
        super();
    }

    ChoiceException(String s){
        super(s);
    }

    void display(int lower, int upper){
        System.out.print("Please enter in range "+lower+" - "+upper+" : ");
    }
}

class Menu{
    private static int lower;
    private static int upper;

    static int readChoice(int low, int up){
        lower = low;
        upper = up;

        Scanner sc = new Scanner(System.in);

        int choice;
        
        while(true){
            try{
                choice = sc.nextInt();
                if(choice<lower || choice>upper)
                    throw new ChoiceException();
                break;
            }
            catch(ChoiceException e){
                e.display(lower, upper);
            }
            catch(Exception e){
                System.out.print("Please Enter in valid Integer format : ");
                sc.next();
            }
        }

        return choice;
    }
}

public class Main {

    static int idExists(Employee[] employees, int id){
        if(employees[id] == null)
            return -1;
        return id;
    }

    public static void main(String[] args) throws IOException{
        
        Employee employees[] = new Employee[1000];

        InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r);
        
        Boolean looping = true;

        while(looping){
            System.out.print("1) Create \n2) Display \n3) Raise Salary \n4) Remove \n5) Exit \nPick one number of the following : ");
            int num = Menu.readChoice(1, 5);

            if(num == 1){
                boolean subloop = true;

                while(subloop){
                    System.out.print("\n1) Clerk \n2) Programmer \n3) Manager \n4) Exit \nPick one number of the following : ");
                    int num2 = Menu.readChoice(1, 4);
                    

                    if(num2 == 4){
                        subloop = false;
                        break;
                    }

                    System.out.print("Enter the id of the employee : ");
                    int id = Menu.readChoice(0, 99);

                    if(idExists(employees, id) != -1){
                        System.out.println("The id you entered already exists!");
                        System.out.println("-----------------------------------------------------------------------");
                        continue;
                    }

                    System.out.print("Enter the name of Employee : ");
                    String name= br.readLine(); 

                    System.out.print("Enter the age of Employee : ");
                    int age = Menu.readChoice(21, 60);


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
                int removeId = Menu.readChoice(0, 99);

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
                System.out.println("Please enter a valid number (1-5)!");
            }
            System.out.println("-----------------------------------------------------------------------");
        }
    }
    
}
