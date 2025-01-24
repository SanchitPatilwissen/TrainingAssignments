// ? extends T --> Anythings which is a subclass of Template class allows reading from generic but restricts writing

import java.util.List;

public class Covariant<T> {
    public void printList(List<? extends T> list) {
        for (T num : list) {
            System.out.println(num);
        }
        
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3);
        List<Double> doubleList = List.of(1.1, 2.2, 3.3);

        Covariant<Number> c = new Covariant<>();
        c.printList(integerList);
        c.printList(doubleList);
    }
}
