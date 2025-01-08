
class Room {
    int length;
    int width;
    
    Room()
    {
        System.out.println("....................................");
    }
    
    Room (String str)
    {
        this();
        System.out.print(" Area : ");
    }

    Room (int length, int width)
    {
        this("abc");
        this.length = length;
        this.width = width;
        this.area();
    }

    public void area(){
        System.out.println(length* width);
    }
}



public class sample {
    public static void main(String[] args){
        Room r1 = new Room(10, 20);
        Room r2 = new Room(30, 40);
        r1.area();
        r2.area();
        System.out.println(".............................");

        r1.length = 50;
        r2.length = 60;
        r1.area();
        r2.area();
        System.out.println(".............................");

        r1 = r2;

        r1.length = 70;
        r2.width = 80;

        r1.area();
        r2.area();

    }
}
