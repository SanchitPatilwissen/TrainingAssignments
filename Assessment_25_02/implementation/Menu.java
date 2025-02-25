package implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;

public class Menu {
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

    static FuelType inputFuelType(){
        int choice = readChoice(1, 5);
        return switch (choice) {
            case 1 -> FuelType.PETROL;
            case 2 -> FuelType.DIESEL;
            case 3 -> FuelType.CNG;
            case 4 -> FuelType.EV;
            default -> FuelType.POWER;
        };
    }

    static CarType inputCarType(){
        int choice = readChoice(1, 5);
        return switch (choice) {
            case 1 -> CarType.SUV;
            case 2 -> CarType.SEDAN;
            case 3 -> CarType.BUS;
            default -> CarType.TRUCK;
        };
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

        while (true) {
            try {
                name = br.readLine();
                break;
            } catch (NameException e) {
                System.out.print(e.getMessage());
            } catch (Exception e) {
                System.out.print("Please enter in valid format : ");
            }
        }
        return name;
    }

    static String validateCompany(Set<String> companies) {
        String name;

        while (true) {
            try {
                name = br.readLine();
                if(companies.contains(name)){
                    break;
                }
                else{
                    System.out.println("Please type the correct company : ");
                }
            } catch (NameException e) {
                System.out.print(e.getMessage());
            } catch (Exception e) {
                System.out.print("Please enter in valid format : ");
            }
        }
        return name;
    }

    static void closing(){
        try {
            sc.close();
            r.close();
            br.close();
        } catch (Exception e) {
            System.out.println("Exception occured while closing the IO resources!");
        }
    }
}
