// ? super T --> Anythin which is a super class of T allows us to write but restricts reading.

import java.util.*;

public class Contravariant {

    public static void addNumbers(List<? super Integer> list) {
        list.add(1);  // Can add Integer because ? super Integer allows superclasses of Integer
        list.add(2);

        
    }

    public static void main(String[] args) {
        List<Number> numberList = List.of(1, 2, 3); // List of numbers

        List<Number> myNumbers = new ArrayList<>();
        addNumbers(myNumbers);

        System.out.println(myNumbers);
    }
}