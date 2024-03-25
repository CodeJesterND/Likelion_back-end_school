package ch04;

import java.util.Scanner;

public class FactorialCalculator {
    //--- 주어진 정수 n에 대해 팩토리얼 값을 계산하여 반환합니다. ---//
    static int comptueFactorial(int n) {
        if (n > 0)
            return n * comptueFactorial(n - 1); // n이 양수일 때 재귀 호출
        else return 1; // 기저 조건: 0! = 1
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("계산할 정수를 입력하세요: ");
        int x = stdIn.nextInt();

        System.out.println(x + "의 팩토리얼 값은 " + comptueFactorial(x) + "입니다.");
    }
}
