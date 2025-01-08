class Person{
    String name;
}

public class ArrayDemo {
    public static void main(String[] args){
        Person persons[] = new Person[5];

        String users[] = {"Sita", "Geeta", "Rita", "Parineeta", "Sunita"};

        for(int i=0;i<persons.length;i++){
            persons[i] = new Person();
            persons[i].name = users[i];
        }

        for(Person person : persons){
            System.out.println("Name : " + person.name);
        }

        System.out.println("........................................................................");

        int arr[][] = new int[5][];

        arr[0] = new int[4];
        arr[1] = new int[10];
        arr[2] = new int[7];
        arr[3] = new int[9];
        arr[4] = new int[12];

        for(int i=0;i<persons.length;i++){
            for(int j=0;j<persons[i].length;j++){
                System.out.print("*");
            }
            System.out.println("");
        }

    }
}
