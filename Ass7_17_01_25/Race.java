import java.util.Arrays;
import java.util.Comparator;

import Components.*;
import Components.Verification.Menu;

public class Race extends Thread{

    static Biker bikers[];

    public void run(){
        int cnt = 1;
        while(true){
            try{
                Arrays.sort(bikers, Comparator.comparingInt((Biker biker) -> biker.getFinishTime()).thenComparing(biker -> biker.getDistance()));       // Secondary sort by name
                System.out.println("---------------------------------------------------------------------");
                System.out.println("Time : "+cnt+"s");
                int i = 1;
                for(Biker biker : bikers){
                    System.out.print(i++ + ") ");
                    biker.display();
                }
                cnt++;
                Thread.sleep(1000);
            }
            catch(Exception e){
                System.out.println("Something went wrong");
                return;
            }
        }
    }

    static public void finalDisplay(){
        Arrays.sort(bikers, Comparator.comparingInt((Biker biker) -> biker.getFinishTime()).thenComparing(biker -> biker.getDistance()));       // Secondary sort by name
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Final Results");
        int i = 1;
        for(Biker biker : bikers){
            System.out.print(i++ + ") ");
            biker.display();
        }
    }
    public static void main(String[] args) throws InterruptedException{
        
        int distance, numberOfBikers;
        
        System.out.print("Enter the race distance (1000-5000) (it is in meters) : ");
        distance = Menu.readChoice(1000, 5000);

        Biker.distance = distance;

        System.out.print("Enter the number of bikers : ");
        numberOfBikers = Menu.readChoice(2, 20);
        
        Race.bikers = new Biker[numberOfBikers];
        
        for(int i=0;i<numberOfBikers;i++){
            bikers[i] = Biker.getBiker(distance);
        }

        Race obj = new Race();

        CountDown.display();

        obj.setDaemon(true);
        
        obj.start();

        for(var biker : bikers){
            biker.start();
        }

        for(var biker : bikers)
            biker.join();

        finalDisplay();
    }    
}
