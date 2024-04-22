package april.day15;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        // ArrayList 생성 및 요소 추가
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("오렌지");
        fruits.add("포도");

        // Iterator<String> iterator = fruits.iterator();
        Iterator<String> iterator = fruits.iterator();
        while(iterator.hasNext()) {
            String frult = iterator.next();
            System.out.println(frult);
        }
    }
}