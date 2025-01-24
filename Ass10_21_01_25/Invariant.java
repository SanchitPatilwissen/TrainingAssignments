import java.util.List;

public class Invariant {
    public static void printList(List<Integer> list) {
        for (Integer num : list) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3);

        // This works
        printList(integerList);

        // List<Number> numberList = List.of(1.1, 2.2); --> CTE
        // printList(numberList);  // Error: cannot convert from List<Number> to List<Integer>
    }
}
