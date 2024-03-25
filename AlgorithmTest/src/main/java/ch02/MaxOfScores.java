package ch02;

import java.util.Scanner;

// 점수 분석을 담당하는 클래스
class ScoreAnalyzer {
    private Scanner scanner; // 입력을 받기 위한 Scanner 객체

    // 생성자
    public ScoreAnalyzer() {
        this.scanner = new Scanner(System.in);
    }

    // 학생들의 점수를 입력받아 배열에 저장하는 메서드
    public int[] inputScores(int numStudents) {
        int[] scores = new int[numStudents]; // 학생들의 점수를 저장할 배열 생성

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("학생 %d의 점수를 입력하세요: ", i + 1);
            scores[i] = scanner.nextInt(); // 사용자로부터 각 학생의 점수 입력 받음
        }

        return scores;
    }

    // 배열에서 최고 점수를 찾아 반환하는 메서드
    public int getMaxScore(int[] scores) {
        int maxScore = scores[0]; // 최고 점수를 초기화

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > maxScore) { // 다음 학생의 점수가 최고 점수보다 크면
                maxScore = scores[i]; // 최고 점수를 해당 점수로 업데이트
            }
        }

        return maxScore; // 최고 점수 반환
    }

    // Scanner 객체를 닫는 메서드
    public void closeScanner() {
        scanner.close(); // Scanner 객체 닫기
    }
}

// 메인 클래스
public class MaxOfScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("학생 수를 입력하세요: ");
        int numStudents = scanner.nextInt(); // 사용자로부터 학생 수 입력 받음

        ScoreAnalyzer scoreAnalyzer = new ScoreAnalyzer(); // 점수 분석을 위한 객체 생성
        int[] scores = scoreAnalyzer.inputScores(numStudents); // 학생들의 점수 입력 받음
        int maxScore = scoreAnalyzer.getMaxScore(scores); // 최고 점수 계산

        System.out.println("최고 점수는 " + maxScore + "입니다.");

        scoreAnalyzer.closeScanner(); // Scanner 객체 닫기
    }
}