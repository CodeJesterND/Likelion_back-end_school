package april.day15.ex;

// 입력된 점수의 유효성을 검증하는 인터페이스
public interface InputValidator<T> {
    boolean validate(T score);
}