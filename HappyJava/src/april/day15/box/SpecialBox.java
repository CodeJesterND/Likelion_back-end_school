package april.day15.box;

// Box를 상속받는 SpecialBox 정의
public class SpecialBox<T> extends Box<T> {
    public SpecialBox(T content) {
        super(content);
    }

    // 특별한 기능을 추가하는 메소드
    public void printContect() {
        System.out.println("Special box contains: " + getContent());
    }
}