package implementation;

import java.util.Set;

public class CarMart {
    public static void displayCompany(Set<String> companies){
        System.out.println("These are a list of companies");
        for(String company : companies){
            System.out.println(company);    
        }
    }

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
                    Set<String> companies = DatabaseController.allCompanies();
                    displayCompany(companies);
                    System.out.print("Enter the Car Company : ");
                    c.setCompany(Menu.validateCompany(companies));
                    System.out.print("Enter the Car Model : ");
                    c.setModel(Menu.readChoice(0, 1000));
                    System.out.print("Enter the Car seater : ");
                    c.setSeater(Menu.readChoice(1, 30));
                    System.out.print("1. Petrol\n2. Diesel\n3. CNG\n4. EV\n5. Power \nSelect the Car Fuel Type : ");
                    c.setFuelType(Menu.inputFuelType());
                    System.out.print("1. SUV\n2. Sedan\n3. Truck\n4. Bus\nSelect the Car Type : ");
                    c.setCarType(Menu.inputCarType());
                    System.out.print("Enter the Car Price : ");
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
                                System.out.print("Enter the name of the company : ");
                                String company = Menu.validateName();
                                DatabaseController.companyWiseCars(company);
                                break;
                            case 3:
                                System.out.print("1. SUV\n2. Sedan\n3. Truck\n4. Bus\nSelect the type of car : ");
                                CarType type = Menu.inputCarType();
                                DatabaseController.typeWiseCars(type);
                                break;
                            case 4:
                                System.out.print("Enter the minimum range of car : ");
                                int mini = Menu.readChoice(0, 10000000);
                                System.out.print("Enter the maximum range of car : ");
                                int maxi = Menu.readChoice(0, 10000000);
                                if(mini>maxi){
                                    System.out.println("Maximum value should be greater than minimum value!");
                                    break;
                                }
                                DatabaseController.rangeWiseCars(mini, maxi);
                            case 5:
                                subloop = false;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter the id of the employee : ");
                    int id = Menu.readChoice(0, 100000);
                    if(!DatabaseController.isExists(id)){
                        System.out.println("Sorry! Car with this id doesn't exist");
                        continue;
                    }
                    System.out.print("Enter the new price : ");
                    double newPrice = Menu.readChoice(0, 1000000);
                    DatabaseController.updatePrice(newPrice, id);
                    break;
                case 4:
                    boolean subloop2 = true;
                    while(subloop2){
                        System.out.print("1. All\n2. Update\n3. Exit\nPick a choice : ");
                        int subchoice = Menu.readChoice(1, 3);
                        switch (subchoice) {
                            case 1:
                                DatabaseController.allCarsSold();
                                break;
                            case 2:
                                System.out.println("Enter the car ID which you want to sell : ");
                                int carId = Menu.readChoice(0, 100000);
                                if(!DatabaseController.isExists(carId)){
                                    System.out.println("Sorry! Car with this id doesn't exist");
                                    continue;
                                }
                                DatabaseController.sold(carId);
                                break;
                            case 3:
                                subloop2 = false;
                                break;
                        }
                    }
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