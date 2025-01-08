// Clerk (salary:20000 + incr:2000), Programmer (30000 + 5000), Manager (100000 + 15000)
 
// java EmployeeManagementApp
 
// ---------------------

// 1. Create

// 2. Display

// 3. Raise Salary

// 4. Exit

// ----------------------

// Enter choice :- 1

// ---------------------

// 1. Clerk

// 2. Programmer

// 3. Manager

// 4. Exit

// ----------------------

// Enter choice :- 2

// Enter name : Suman

// Enter age : 25

// ---------------------

// 1. Clerk

// 2. Programmer

// 3. Manager

// 4. Exit

// ----------------------

// Enter choice :- 4
 
 
 
// Total no. of employees created/added : 7

import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;

class Employee2{
    private String name;
    private int age;
    private double salary;
 
    Employee2(String var1, int var2, double var3) {
       this.name = var1;
       this.age = var2;
       this.salary = var3;
    }
 
    void display() {
        System.out.println("-------------------------------------------------------------------------------\n");
        System.out.println("The following are the details of this employee : \nName : " + this.name + "\nAge : " + this.age + "\nSalary : " + this.salary);
        System.out.println("\n-------------------------------------------------------------------------------");
    }
 
    void raiseSalary(int var1) {
       this.salary += (double)var1;
    }
}

class Clerk extends Employee2{
    Clerk(String name, int age){
        super(name, age, 20000);
    }

    void raiseSalary() {
        raiseSalary(2000);
    }
}

class Programmer extends Employee2{
    Programmer(String name, int age){
        super(name, age, 30000);
    }

    void raiseSalary() {
        raiseSalary(5000);
    }
}

class Manager extends Employee2{
    Manager(String name, int age){
        super(name, age, 100000);
    }

    void raiseSalary() {
        raiseSalary(15000);
    }
}

public class Assignment2 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        Boolean looping = true;
        
        ArrayList<Clerk> clerks = new ArrayList<Clerk>();
        ArrayList<Programmer> programmers = new ArrayList<Programmer>();
        ArrayList<Manager> managers = new ArrayList<Manager>();


        InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r);

        while(looping){
            System.out.print("1) Create \n2) Display \n3) Raise Salary \n4) Exit \nPick one number of the following : ");
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

                    System.out.print("Enter the name of Employee : ");
                    String name= br.readLine(); 
                    System.out.print("Enter the age of Employee : ");
                    int age = sc.nextInt();

                    if(num2 == 1){
                        Clerk c = new Clerk(name, age);
                        clerks.add(c);
                    }
                    else if(num2 == 2){
                        Programmer c = new Programmer(name, age);
                        programmers.add(c);
                    }
                    else if(num2 == 3){
                        Manager c = new Manager(name, age);
                        managers.add(c);
                    }
                    else{
                        System.out.println("Please enter a valid number!");
                    }
                    System.out.println("-----------------------------------------------------------------------");

                }
            }
            else if(num == 2){
                int j = 0;
                for(int i=0;i<clerks.size();i++){
                    System.out.println((j+1)+" Employee");
                    clerks.get(i).display();
                    j++;
                }
                for(int i=0;i<programmers.size();i++){
                    System.out.println((j+1)+" Employee");
                    programmers.get(i).display();
                    j++;
                }
                for(int i=0;i<managers.size();i++){
                    System.out.println((j+1)+" Employee");
                    managers.get(i).display();
                    j++;
                }
            }
            else if(num == 3){
                for(int i=0;i<clerks.size();i++){
                    clerks.get(i).raiseSalary();
                }
                for(int i=0;i<programmers.size();i++){
                    programmers.get(i).raiseSalary();
                }
                for(int i=0;i<managers.size();i++){
                    managers.get(i).raiseSalary();
                }
            }
            else if(num == 4){
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
