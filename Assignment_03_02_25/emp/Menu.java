package emp;

import java.util.Scanner;
import java.util.regex.*;
import java.io.*;

class Menu {
    private static int lower;
    private static int upper;
    private static Scanner sc;
    private static InputStreamReader r;
    private static BufferedReader br;

    static void initialize(){
        sc = new Scanner(System.in);
        r = new InputStreamReader(System.in);
        br = new BufferedReader(r);
    }


    static int readChoice(int low, int up) {
        lower = low;
        upper = up;

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

    static void InputData(int num2) {
        System.out.print("Enter the name of Employee : ");
        String name = Menu.validateName();

        System.out.print("Enter the age of Employee : ");
        int age = Menu.readChoice(21, 60);

        System.out.print("Enter the salary of Employee : ");
        double salary = Menu.readChoice(0, 10000000);
        
        System.out.print("1) Sales \n2) Finance \n3) HR \n4) IT \nSelect the department of Employee : ");
        int department = Menu.readChoice(1, 4); 

        EmployeeCreation(num2, name, age, salary, department);
    }

    static final void EmployeeCreation(int num2, String name, int age, double salary, int department) {
        String[] department_map = {"SALES", "FINANCE", "HR", "IT"};
        String[] designation_map = {"CLERK", "PROGRAMMAR", "MANAGER", "OTHER"};

        try {            
            Database.createEmployee(name, age, salary, designation_map[num2-1], department_map[department-1]);
        } catch (Exception e) {
            System.err.println("Something went wrong!");
        }
    }

    static void closing(){
        sc.close();
    }
}
