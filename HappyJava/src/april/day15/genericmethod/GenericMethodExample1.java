package april.day15.genericmethod;

/*
    해당 클래스는 제네릭이 아니더라도 제네릭 메소드를 정의할 수 있다.
    또한, 이는 인터페이스도 해당되는 사안이다.

    제네릭 메소드는 다양한 타입의 객체를 동일한 방식으로 처리할 수 있는 메소드이다.
 */

public class GenericMethodExample1 {
    public static <T> void printArrayElements(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        // Integer 배열
        Integer[] iArray = {1, 2, 3, 4, 5, 6};
        printArrayElements(iArray);

        // String 배열
        String[] strArray = {"Hello", "world", "kang", "hahaha"};
        printArrayElements(strArray);
    }
}
