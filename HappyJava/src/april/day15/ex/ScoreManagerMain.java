package april.day15.ex;

public class ScoreManagerMain {
    public static void main(String[] args) {
        InputValidator<Integer> validator = new ScoreValidator<>();
        ScoreManager<Integer> manager = new ScoreManager<>(validator);

        // 점수 입력 받기
        manager.readScores();

        // 0점 제거
        manager.removeZero();

        // 결과 출력
        manager.printScores();

        // 리소스 정리
        manager.closeScanner();
    }
}