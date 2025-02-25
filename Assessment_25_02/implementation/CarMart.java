package implementation;

import java.awt.Menu;

import Ass_13_29_01_25.Database;

public class CarMart {
    public static void main(String[] args) {
        boolean continueLoop = true;
        Menu.initialize();        
        DatabaseController.initialize();

        while(continueLoop){
            System.out.print("1. Add\n2. Search\n3. Update\n4. Sold\n5. Exit\nPick a choice : ");
            int choice = Menu.readChoice(1, 5);
            switch (choice) {
                case 1:
                    Car c = new Car();
                    System.out.println("Enter the Car Company : ");
                    c.setCompany(Menu.validateName());
                    System.out.println("Enter the Car Model : ");
                    c.setModel(Menu.readChoice(0, 1000));
                    System.out.println("Enter the Car seater : ");
                    c.setSeater(Menu.readChoice(1, 30));
                    System.out.println("1. Petrol\n2. Diesel\n3. CNG\n4. EV\n5. Power \nSelect the Car Fuel Type : ");
                    c.setFuelType(Menu.inputFuelType());
                    System.out.println("1. SUV\n2. Sedan\n3. Truck\n4. Bus\nSelect the Car Type : ");
                    c.setCarType(Menu.inputCarType());
                    System.out.println("Enter the Car Price : ");
                    c.setPrice(Menu.readChoice(0, 1000000));
                    DatabaseController.enterCar(c);
                    break;
                case 2:
                    boolean subloop = true;
                    while(subloop){
                        System.out.print("1. All Cars\n2. All Cars of specific company\n3. Type\n4. Price Range\n5. Exit\nPick a choice : ");
                        int subchoice = Menu.readChoice(1, 5);
                        switch (subchoice) {
                            case 1:
                                DatabaseController.allCarsUnsold();
                                break;
                            case 2:
                                String company = Menu.validateName();
                                DatabaseController.companyWiseCars(company);
                            default:
                                break;
                        }
                    }
                    break;
                case 3:
                    
                    break;
                case 4:

                    break;
                case 5:
                    continueLoop = false;
                    break;
            }
        }
        Menu.closing();
        DatabaseController.closing();
    }
    
}