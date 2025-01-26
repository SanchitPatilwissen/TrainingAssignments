package emp;

import java.util.Scanner;
import java.util.regex.*;
import java.io.*;

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

    static void InputData(int num2, int id, Database db) {
        System.out.print("Enter the name of Employee : ");
        String name = Menu.validateName();

        System.out.print("Enter the age of Employee : ");
        int age = Menu.readChoice(21, 60);

        EmployeeCreation(num2, name, age, id, db);
    }

    static void updateEmployee(int id, Database db){
        System.out.print("Enter the name of Employee : ");
        String name = Menu.validateName();

        System.out.print("Enter the age of Employee : ");
        int age = Menu.readChoice(21, 60);

        db.employees.get(id).update(name, age);
        db.employees.get(id).setSalary();        

    }

    static final void EmployeeCreation(int num2, String name, int age, int id, Database db) {
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
                if(c == null) return;
            }
            db.employees.put(id, c);
        } catch (Exception e) {
            System.err.println("There must be a CEO present before creating other employees");
        }
    }
}
