package march.day13.ex;

import java.util.Scanner;

public class PositiveIntegerSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int number;

        do {
            System.out.print("양의 정수를 입력하세요 (0을 입력하면 종료): ");
            number = scanner.nextInt();

            if (number < 0) {
                System.out.println("양의 정수를 입력해주세요.");
            } else {
                sum += number;
            }
        } while (number != 0);

        System.out.println("입력한 양의 정수들의 총합은 " + sum + "입니다.");

        scanner.close();
    }
}