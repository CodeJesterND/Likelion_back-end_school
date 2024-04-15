package april.day15.ex;

// 점수를 검증하는 클래스
public class ScoreValidator<T extends Number> implements InputValidator<T> {
    @Override
    public boolean validate(T score) {
        int value = score.intValue();
        return value >= 0 && value <= 100;
    }
}