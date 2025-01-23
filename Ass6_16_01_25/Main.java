import java.util.*;
import java.util.regex.*;
import java.io.*;

enum Designation {
    CEO,
    CLERK,
    PROGRAMMER,
    MANAGER,
}

abstract class Employee {
    private int emp_id;
    private String name;
    private int age;
    double salary;
    private Designation designation;

    Employee(String var1, int var2, double var3, Designation var4, int var5) throws Exception {
        if (!(this instanceof Ceo) && Ceo.isCeoNotThere()) {
            throw new Exception();
        }

        this.name = var1;
        this.age = var2;
        this.salary = var3;
        this.designation = var4;
        this.emp_id = var5;

    }

    final int getId() {
        return this.emp_id;
    }

    final String getName() {
        return this.name;
    }

    final double getSalary() {
        return this.salary;
    }

    final int getAge() {
        return this.age;
    }

    final Designation getDesignation() {
        return this.designation;
    }

    final void display() {
        System.out.println("The following are the details of this Employee : \nName : " + this.name + "\nAge : "
                + this.age + "\nSalary : " + this.salary + "\nDesignation : " + this.designation);
    }

    abstract void raiseSalary();
}

final class Clerk extends Employee {
    Clerk(String name, int age, Designation designation, int id) throws Exception {
        super(name, age, 20000, designation, id);
    }

    void raiseSalary() {
        salary += 2000;
    }
}

final class Programmer extends Employee {
    Programmer(String name, int age, Designation designation, int id) throws Exception {
        super(name, age, 30000, designation, id);
    }

    void raiseSalary() {
        salary += 5000;
    }
}

final class Manager extends Employee {
    Manager(String name, int age, Designation designation, int id) throws Exception {
        super(name, age, 100000, designation, id);
    }

    void raiseSalary() {
        salary += 15000;

    }
}

final class Ceo extends Employee {

    static private Ceo p1 = null;

    private Ceo(String name, int age, Designation designation, int id) throws Exception {
        super(name, age, 1000000, designation, id);
    }

    void raiseSalary() {
        salary += 50000;
    }

    static Ceo createCeo(String name, int age, Designation designation, int id) throws Exception {
        try {
            if (p1 == null) {
                p1 = new Ceo(name, age, designation, id);
                return p1;
            } else {
                throw new MultipleObjectException("Only 1 CEO can be there!");
            }
        } catch (MultipleObjectException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    static boolean isCeoNotThere() {
        if (p1 == null)
            return true;
        return false;
    }
}

class MultipleObjectException extends RuntimeException {
    MultipleObjectException() {
        super();
    }

    MultipleObjectException(String s) {
        super(s);
    }
}

class ChoiceException extends RuntimeException {
    ChoiceException() {
        super();
    }

    ChoiceException(String s) {
        super(s);
    }

    void display(int lower, int upper) {
        System.out.print("Please enter in range " + lower + " - " + upper + " : ");
    }
}

class NameException extends RuntimeException {
    NameException() {
        super();
    }

    NameException(String s) {
        super(s);
    }
}

class Menu {
    private static int lower;
    private static int upper;

    static int readChoice(int low, int up) {
        lower = low;
        upper = up;

        Scanner sc = new Scanner(System.in);

        int choice;

        while (true) {
            try {
                choice = sc.nextInt();
                if (choice < lower || choice > upper)
                    throw new ChoiceException();
                break;
            } catch (ChoiceException e) {
                e.display(lower, upper);
            } catch (Exception e) {
                System.out.print("Please Enter in valid Integer format : ");
                sc.next();
            }
        }
        return choice;
    }

    static String validateName() {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        String name;
        String regex_exp = "^[A-Z][a-z]* [A-Z][a-z]*$";

        while (true) {
            try {
                name = br.readLine();
                Pattern p1 = Pattern.compile(regex_exp);
                Matcher m1 = p1.matcher(name);

                if (m1.matches())
                    break;
                else
                    throw new NameException(
                            "Please Enter the name in valid Format(1st letters caps, 2 words consisting of letters only) : ");
            } catch (NameException e) {
                System.out.print(e.getMessage());
            } catch (Exception e) {
                System.out.print("Please enter in valid format : ");
            }
        }
        return name;
    }

    static void InputData(int num2, int id) {
        System.out.print("Enter the name of Employee : ");
        String name = Menu.validateName();

        System.out.print("Enter the age of Employee : ");
        int age = Menu.readChoice(21, 60);

        EmployeeCreation(num2, name, age, id);
    }

    static final void EmployeeCreation(int num2, String name, int age, int id) {
        Employee c = null;
        try {
            if (num2 == 1) {
                c = new Clerk(name, age, Designation.CLERK, id);
            } else if (num2 == 2) {
                c = new Programmer(name, age, Designation.PROGRAMMER, id);
            } else if (num2 == 3) {
                c = new Manager(name, age, Designation.MANAGER, id);
            } else if (num2 == 4) {
                c = Ceo.createCeo(name, age, Designation.CEO, id);
                System.out.println("CEO is created");
            }
            Database.employees.put(id, c);
        } catch (Exception e) {
            System.err.println("There must be a CEO present before creating other employees");
        }
    }
}

final class Database {
    static HashMap<Integer, Employee> employees = new HashMap<Integer, Employee>();

    static void readAll() {
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
            
                Menu.EmployeeCreation(num2, name, age, id);
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

public class Main {
    public static void main(String[] args) throws IOException {

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        // Employee employees[] = new Employee[1000];
        // HashMap<Integer, Employee> employees = new HashMap<Integer, Employee>();
        Database.readAll();

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
                    Menu.InputData(num2, id);
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

class NameSorter implements Comparator<Employee> {
    public int compare(Employee s1, Employee s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

class IDSorter implements Comparator<Employee> {
    public int compare(Employee s1, Employee s2) {
        return new Integer(s1.getId()).compareTo(s2.getId());
    }
}

class SalarySorter implements Comparator<Employee> {
    public int compare(Employee s1, Employee s2) {
        return new Double(s1.getSalary()).compareTo(s2.getSalary()) * -1;
    }
}

class AgeSorter implements Comparator<Employee> {
    public int compare(Employee s1, Employee s2) {
        return new Integer(s1.getAge()).compareTo(s2.getAge());
    }
}

class DesignationSorter implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        return e1.getDesignation().compareTo(e2.getDesignation());
    }
}


// 1) AbstractFactory for employee creation
// 2) Template CEO and then the rest
// 3) Iterator implementation