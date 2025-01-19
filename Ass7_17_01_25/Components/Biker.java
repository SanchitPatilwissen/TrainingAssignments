package Components;

import Components.Verification.Menu;
import java.util.Random;

public final class Biker extends Thread{
    private static int count = 0;

    private String name;
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
        else
            speed += val;
    }

    public void display(){
        if(this.isAlive()){
            int percent = (int)((distanceLeft/distance)*100);
            System.out.print(percent);
            for(int i=0;i<percent;i++)
                System.out.print('|');
            System.out.println("\nName : "+name+", Distance Left : "+distanceLeft+" meters"+", Speed : "+speed+"m/s");
        }
        else
            System.out.println("Name : "+name+", End Time : "+endTime+"s");
    }

    public int getDistance(){
        return distanceLeft;
    }

    public int getFinishTime(){
        return endTime;
    }

    public void run(){
        Random random = new Random();
        
        while(distanceLeft>0){
            try{
                int randomNumber = random.nextInt(16) - 5;
                accelerate(randomNumber);
                distanceLeft -= speed;
                Thread.sleep(1000);
                endTime++;
            }
            catch(Exception e){
                System.out.println("Exception occured!");
            }
        }
    }
}