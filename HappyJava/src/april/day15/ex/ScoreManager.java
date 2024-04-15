package april.day15.ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 점수를 관리하고 출력하는 클래스
public class ScoreManager<T extends Number> {
    private final Scanner input;
    private final List<T> scores;
    private final InputValidator<T> validator;

    public ScoreManager(InputValidator<T> validator){
        input = new Scanner(System.in);
        scores = new ArrayList<>();
        this.validator = validator;
    }

    // 입력 받은 문자열을 T 타입으로 변환하는 기능
    private T parseScore(String scoreStr) {
        if (scoreStr.contains(".")) {
            // Double 또는 Float 타입일 경우
            return (T) Double.valueOf(scoreStr);
        } else {
            // Integer 또는 Long 타입일 경우
            return (T) Integer.valueOf(scoreStr);
        }
    }

    // 점수 입력 기능
    public void readScores() {
        while (true) {
            System.out.print("점수를 입력하세요 (0 입력시 종료): ");
            try {
                T score = parseScore(input.next());
                if (score.intValue() == 0) {
                    break;
                } else if (!validator.validate(score)) {
                    System.out.println("0-100사이의 숫자만 입력이 가능합니다: " + score);
                } else {
                    scores.add(score);
                }
            } catch (Exception e) {
                System.out.println("유효하지 않은 입력입니다.");
                input.next();
            }
        }
    }

    // 0을 제거하는 기능
    public void removeZero() {
        scores.removeIf(score -> score.intValue() == 0);
    }

    // 결과 출력 기능
    public void printScores() {
        System.out.println("입력된 점수: " + scores);
        if (!scores.isEmpty()) {
            int sum = scores.stream().mapToInt(Number::intValue).sum();
            int average = sum / scores.size();
            System.out.println("총점: " + sum);
            System.out.println("평균: " + average);
        } else {
            System.out.println("입력된 점수가 없습니다.");
        }
    }

    // Scanner 리소스 정리 기능
    public void closeScanner() {
        input.close();
    }
}