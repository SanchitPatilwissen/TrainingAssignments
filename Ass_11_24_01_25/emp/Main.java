package emp;

import java.util.*;
import java.io.*;

enum Designation {
    CEO,
    CLERK,
    PROGRAMMER,
    MANAGER,
}

public class Main {
    public static void main(String[] args) throws IOException {

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        Database db = new Database();
        db.readAll();
        Ceo.findCeo(db);

        Boolean looping = true;

        while (looping) {
            System.out.println(
                    "-------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.print(
                    "1) Create \n2) Display \n3) Raise Salary \n4) Remove \n5) Search \n6) Update \n7) Exit \nPick one number of the following : ");
            int num = Menu.readChoice(1, 7);

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

                    if (db.employees.get(id) != null) {
                        System.out.println("The id you entered already exists!");
                        continue;
                    }
                    Menu.InputData(num2, id, db);
                }
            } else if (num == 2) {
                int count = 0;
                System.out.print(
                        "On what basis do you want to sort the employees \n1) id \n2) Name \n3) Age \n4) Salary \n5) Designation \nChoose one of the above : ");
                int sortingOrder = Menu.readChoice(1, 5);

                List<Employee> sortedEmployees = new ArrayList<Employee>();

                for (var id : db.employees.keySet()) {
                    sortedEmployees.add(db.employees.get(id));
                }

                switch (sortingOrder) {
                    case 1:
                    Collections.sort(sortedEmployees, new IDSorter());
                    break;
                    case 2:
                    Collections.sort(sortedEmployees, new NameSorter());
                    break;
                    case 3:
                    Collections.sort(sortedEmployees, new AgeSorter());
                    break;
                    case 4:
                    Collections.sort(sortedEmployees, new SalarySorter());
                    break;
                    case 5:
                    Collections.sort(sortedEmployees, new DesignationSorter());
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
                for (var id : db.employees.keySet()) {
                    if (db.employees.get(id) != null) {
                        ((Employee) db.employees.get(id)).raiseSalary();
                    }
                }
            } else if (num == 4) {
                System.out.print("Enter the id of the employee you want to remove : ");
                int removeId = Menu.readChoice(0, 10000000);

                if (db.employees.get(removeId) == null) {
                    System.out.println("The Employee ID you entered doesn't exist!");
                } else {
                    System.out.println("-----------------------------------------------------------------");
                    if(db.employees.get(removeId) instanceof Ceo){
                        System.out.println("Cannot Remove CEO!");
                    }
                    else{
                        db.employees.get(removeId).display();
                        System.out.print("Do you realy want to remove this employee : ");
                        String response = br.readLine();
                        if (response.charAt(0) == 'Y' || response.charAt(0) == 'y') {
                            db.employees.remove(removeId);
                            System.out.println("The Employee is successfully removed!");
                        }
                    }
                }
            } else if (num == 5) {
                System.out.print(
                        "On what basis do you want to search the employees \n1) id \n2) Name \n3) Age \n4) Salary \n5) Designation \nChoose one of the above : ");
                int searchingOrder = Menu.readChoice(1, 5);
                

                System.out.print("Enter the ID of the employee you want to search : ");
                int searchId = Menu.readChoice(0, 10000000);
                TreeSet<Employee> sortedEmployees = null;
                if (db.employees.get(searchId) == null)
                    System.out.println("No employee of this ID exists!");
                else {
                    System.out.println("-----------------------------------------------------------------");
                    ((Employee) db.employees.get(searchId)).display();
                }
            } else if(num == 6){
                System.out.println("Enter the ID you want to update : ");
                int id = Menu.readChoice(0, 10000000);
                if(db.employees.get(id) == null)
                    System.out.println("Invalid ID entered!");
                else
                    Menu.updateEmployee(id, db);

            } else if (num == 7) {
                looping = false;
            } else {
                System.out.println("Please enter a valid number (1-5)!");
            }
        }
        db.appendAll();
    }
}


// 1) AbstractFactory for employee creation
// 2) Template CEO and then the rest
// 3) Iterator implementation