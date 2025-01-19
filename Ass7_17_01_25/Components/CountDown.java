package Components;

public final class CountDown{

    static private int count = 10;

    public static void display() throws InterruptedException{
        System.out.println("\n------------------------------------------------------------------------------------------\n");
        System.out.println("Race countdown begins...........");
        Thread.sleep(500);
        while(count!=0){
            System.out.println(count--);
            Thread.sleep(1000);
        }
        System.out.println("Start!");
        System.out.println("\n------------------------------------------------------------------------------------------\n");
    }
}

