package april.day15.genericpair;

/*
    제네릭을 사용하면, 컴파일 시점에 타입을 체크하며, 타입 안전성이 보장되고 코드의 가독성이 향상된다.
    또한, 캐스팅을 줄임으로써 코드의 오류 가능성을 줄이고 유지보수성을 향상시킨다.
 */

public class GenericPairExam {
    GenericPair<String, Integer> pair = new GenericPair("Hello", 5);
    String first = pair.getFirst();
    int second = pair.getSecond();
}