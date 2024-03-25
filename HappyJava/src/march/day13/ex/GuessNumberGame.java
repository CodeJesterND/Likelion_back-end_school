package march.day13.ex;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; // 1부터 100까지의 임의의 숫자 선택

        Scanner scanner = new Scanner(System.in);

        System.out.println("1부터 100 사이의 숫자를 맞춰보세요.");

        int guess;
        do {
            System.out.print("숫자를 입력하세요: ");
            guess = scanner.nextInt();

            if (guess > randomNumber) {
                System.out.println("입력한 숫자가 정답보다 큽니다.");
            } else if (guess < randomNumber) {
                System.out.println("입력한 숫자가 정답보다 작습니다.");
            } else {
                System.out.println("정답입니다! 축하합니다.");
            }
        } while (guess != randomNumber);

        scanner.close();
    }
}