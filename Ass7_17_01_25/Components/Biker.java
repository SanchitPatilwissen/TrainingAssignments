package Components;

import Components.Verification.Menu;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public final class Biker extends Thread{
    private CountDownLatch latch;
    private static int count = 0;

    private String name;

    private LocalTime startTime;
    private LocalTime endingTime;

    private int currentTime;
    private int distanceLeft;
    private int speed = 0;
    public static int distance;

    private Biker(String name, int dist, CountDownLatch latch){
        this.name = name;
        this.distanceLeft = dist;
        this.latch = latch;
        count++;
    }


    public static final Biker getBiker(int dist, CountDownLatch latch){
        System.out.print("Enter the name of Biker "+(count+1)+" : ");
        String name= Menu.validateName();
        return new Biker(name, dist, latch);

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
            System.out.println("Name : "+name+", Overall Time : "+currentTime+"s"+", Starting Time : "+startTime+", Ending Time : "+endingTime);
    }

    public int getDistance(){
        return distanceLeft;
    }

    public int getFinishTime(){
        return currentTime;
    }

    public void run(){
        System.out.println(name+" has started");
        Random random = new Random();
        
        startTime = LocalTime.now();
        latch.countDown();

        while(distanceLeft>0){
            try{
                int randomNumber = random.nextInt(16) - 5;
                accelerate(randomNumber);
                distanceLeft -= speed;
                Thread.sleep(1000);
                if(distanceLeft>0)
                    currentTime++;
            }
            catch(Exception e){
                System.out.println("Exception occured!");
            }
        }

        endingTime = LocalTime.now();
    }
}