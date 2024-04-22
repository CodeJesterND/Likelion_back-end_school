package april.day15.nongenericpair;

/*
    제네릭이 없었을 때의 pair 클래스
    해당 클래스는 모든 타입의 객체를 저장하기 위해 Object 타입을 사용한다.
    유연성은 제공하지만, 타입 안정성이 떨어지는 경고가 일어나며 캐스팅이 필요한 단점이 있다.
 */
public class NonGenericPair {
    private Object first; // first는 Object 타입이다.
    private Object second; // second는 Object 타입이다.

    public NonGenericPair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return first;
    }

    public Object getSecond() {
        return second;
    }

    public void setFirst(Object first) {
        this.first = first;
    }

    public void setSecond(Object second) {
        this.second = second;
    }
}
