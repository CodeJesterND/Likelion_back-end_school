package april.day15;

public class GenericMethodExample {
    public static <T> void printArrayElements(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        // Integer 배열
        Integer[] intArray = {1, 2, 3, 4, 5};
        printArrayElements(intArray);

        // String 배열
        String[] stringArray = {"Hello", "world", "Java"};
        printArrayElements(stringArray);
    }
}
