package april.day15;

import java.util.List;
import java.util.Arrays;

public class WildcardExample {
    public static void printList(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }

    /*
    // 아래와 같이 메소드를 수정해도 결과는 같다.
    public static <T> void printList(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }
     */

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3); // 출력: 1, 2, 3
        List<String> stringList = Arrays.asList("Hello", "World"); // 출력: Hello, World
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3); // 출력: 1.1, 2.2, 3.3

        printList(intList);
        printList(stringList);
        printList(doubleList);
    }
}