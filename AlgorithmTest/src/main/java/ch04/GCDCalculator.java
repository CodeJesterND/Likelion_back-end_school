package ch04;

import java.util.Scanner;

public class GCDCalculator {
    //--- 두 정수 x와 y의 최대공약수(GCD)를 재귀적으로 계산합니다 ---//
    static int calculateGCD(int x, int y) {
        if(y == 0)
            return x; // 기저 조건: y가 0이면 x가 최대공약수
        else
            return calculateGCD(y, x % y);// 유클리드 호제법을 사용한 재귀 호출
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.println("두 수의 최대공약수를 계산합니다.");

        System.out.print("첫 번째 정수를 입력하세요: ");
        int x = stdIn.nextInt();
        System.out.print("두 번째 정수를 입력하세요: ");
        int y = stdIn.nextInt();

        System.out.println("두 수의 최대공약수는 " + calculateGCD(x, y) + "입니다.");
    }
}