package emp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        try{
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
    
            Boolean looping = true;
            Menu.initialize();
            Database.initialize();
    
            while(looping){
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
                                "1) Clerk \n2) Programmer \n3) Manager \n4) Other \n5) Exit \nPick one number of the following : ");
                        int num2 = Menu.readChoice(1, 5);
    
                        if (num2 == 5) {
                            subloop = false;
                            break;
                        }
                        Menu.InputData(num2);
                    }
                } else if (num == 2) {
                    System.out.print(
                            "On what basis do you want to sort the employees \n1) id \n2) Name \n3) Age \n4) Salary \n5) Designation \n6) Department \nChoose one of the above : ");
                    int sortingOrder = Menu.readChoice(1, 5);
    
                    switch (sortingOrder) {
                        case 1:
                            Database.display("eid");
                            break;
                        case 2:
                            Database.display("ename");
                            break;
                        case 3:
                            Database.display("eage");
                            break;
                        case 4:
                            Database.display("esalary");
                            break;
                        case 5:
                            Database.display("edesignation");
                            break;
                        case 6:
                            Database.display("edepartment");
                            break;
                    }
                } else if (num == 3) {
                    System.out.print("Enter the ID of the employee whose salary you want to raise : ");
                    int id = Menu.readChoice(0, 1000000);
                    if(Database.search(id) == 0){
                        continue;
                    }
                    System.out.print("By how much amount do you want to raise the salary : ");
                    int raise = Menu.readChoice(-50000, +50000);
                    Database.raiseSalary(raise, id);
                    
                } else if (num == 4) {
                    System.out.print("Enter the id of the employee you want to remove : ");
                    int removeId = Menu.readChoice(0, 10000000);
    
                    if(Database.search(removeId) == 0){
                        continue;
                    }
                    System.out.print("Do you realy want to remove this employee : ");
                    String response = br.readLine();
                    if (response.charAt(0) == 'Y' || response.charAt(0) == 'y') {
                        Database.remove(removeId);
                    }
                } else if (num == 5) {
                    System.out.print(
                            "On what basis do you want to search the employees \n1) id \n2) Name \n3) Age \n4) Salary \n5) Designation \n6) Department \nChoose one of the above : ");
                    int searchingOrder = Menu.readChoice(1, 6);
    
                    switch (searchingOrder) {
                        case 1:
                            System.out.print("Enter the ID of the employee you want to search : ");
                            int searchId = Menu.readChoice(0, 10000000);
                            Database.search(searchId);
                            break;
                        case 2:
                            System.out.print("Enter the Name of the employee you want to search : ");
                            String name = (br.readLine()).toUpperCase();
                            new Searching<String>().search(name, "ename");
                            break;
                        case 3:
                            System.out.print("Enter the age of the employee you want to search : ");
                            int age = Menu.readChoice(21, 60);
                            new Searching<Integer>().search(age, "eage");
                            break;
                        case 4:
                            System.out.print("Enter the salary of the employee you want to search : ");
                            double salary = Double.parseDouble(br.readLine());
                            new Searching<Double>().search(salary, "esalary");
                            break;
                        case 5:
                            System.out.print("Enter the Designation of the employee you want to search : ");
                            String designation = (br.readLine()).toUpperCase();
                            new Searching<String>().search(designation, "edesignation");
                            break;
                        case 6:
                            System.out.print("Enter the Department of the employee you want to search : ");
                            String department = (br.readLine()).toUpperCase();
                            new Searching<String>().search(department, "edepartment");
                            break;
                    }
                }
                else if (num == 6) {
                    looping = false;
                } 
                else {
                    System.out.println("Please enter a valid number (1-5)!");
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            Menu.closing();
            Database.closing();
        }
    }
}

// Changes

// 1) Use dao design pattern to reuse the code