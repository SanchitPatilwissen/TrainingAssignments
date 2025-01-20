package Components;

import Components.Verification.Menu;

import java.time.LocalTime;
import java.util.Random;

public final class Biker extends Thread{
    public static final Object lock = new Object();
    private static int count = 0;

    private String name;

    private LocalTime startTime;
    private LocalTime endingTime;

    private int endTime;
    private int distanceLeft;
    private int speed = 0;
    public static int distance;

    private Biker(String name, int dist){
        this.name = name;
        this.distanceLeft = dist;
        count++;
    }


    public static final Biker getBiker(int dist){
        System.out.print("Enter the name of Biker "+(count+1)+" : ");
        String name= Menu.validateName();
        return new Biker(name, dist);

    }

    private void accelerate(int val){
        if(speed+val<=0)
            speed = 0;
        else if(speed+val>80)
            speed = 80;
        else
            speed += val;
    }

    public void display(){
        if(this.isAlive() && distanceLeft>0){
            System.out.print("    ");
            int percent = (int)(((double)distanceLeft/distance)*100);
            for(int i=0;i<percent;i++)
                System.out.print('|');
            System.out.println("\nName : "+name+", Distance Left : "+distanceLeft+" meters"+", Speed : "+speed+"m/s");
        }
        else
            System.out.println("Name : "+name+", Overall Time : "+endTime+"s"+", Starting Time : "+startTime+", Ending Time : "+endingTime);
    }

    public int getDistance(){
        return distanceLeft;
    }

    public int getFinishTime(){
        return endTime;
    }

    public static void startRace() {
        
    }

    public void run(){
        synchronized (lock) {
            System.out.println(name+" IS WAITING");
            try {
               lock.wait();
            }
            catch (Exception e) {
                System.out.println(name + " interrupted while waiting to start the race.");
            }
        }
        System.out.println(name+" has started");
        Random random = new Random();
        
        startTime = LocalTime.now();

        while(distanceLeft>0){
            try{
                int randomNumber = random.nextInt(16) - 5;
                accelerate(randomNumber);
                distanceLeft -= speed;
                Thread.sleep(1000);
                if(distanceLeft>0)
                    endTime++;
            }
            catch(Exception e){
                System.out.println("Exception occured!");
            }
        }

        endingTime = LocalTime.now();
    }
}