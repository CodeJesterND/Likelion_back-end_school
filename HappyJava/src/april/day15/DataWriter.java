package april.day15;

import java.util.List;
import java.util.ArrayList;


public class DataWriter {
    // 하한을 사용하여 제네릭 메소드 정의

    public static void addNumbers(List<? super Integer> list) {
        for (int i = 0; i <= 5; i++) {
            list.add(i); // Integer 추가 가능
        }
    }

    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        addNumbers(numberList);
        addNumbers(objectList);

        System.out.println("Number List: " + numberList);
        System.out.println("Object List: " + objectList);
    }
}