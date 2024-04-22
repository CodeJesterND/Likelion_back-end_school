package april.day15.genericpair;

/*
    제네릭이 도입된 후의 Pair 클래스이다.
    해당 클래스는 구체적인 타입을 지정하지 않고, 객체를 생성할 때 타입을 지정할 수 있다.
    이는 타입 안전성을 높이고, 불필요한 캐스팅을 방지한다.
 */

public class GenericPair<T1, T2> {
    private T1 first;
    private T2 second;

    public GenericPair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public void setSecond(T2 second){
        this.second = second;
    }
}