package april.day16;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // ArrayList 생성
        List<String> fruits = new ArrayList<>();

        // 요소 추가
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // 요소 접근
        String firstFruit = fruits.get(0); System.out.println("첫 번째 과일: " + firstFruit);

        // 요소 수정
        fruits.set(1, "Blueberry");

        // 요소 삭제
        fruits.remove("Cherry");

        // 리스트 출력
        System.out.println("업데이트된 과일 리스트: " + fruits); }
}