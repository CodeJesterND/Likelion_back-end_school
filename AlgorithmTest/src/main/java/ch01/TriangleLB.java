package ch01;

import java.util.Scanner;

class Triangle {
    private int height;

    public void setHeight(int height) {
        this.height = height;
    }

    public void draw() {
        System.out.println("왼쪽 아래가 직각인 이등변삼각형을 그립니다.");

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}

public class TriangleLB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Triangle triangle = new Triangle();
        int n;

        do {
            System.out.print("삼각형의 높이를 입력해주세요: ");
            n = scanner.nextInt();
        } while (n <= 0);

        triangle.setHeight(n);
        triangle.draw();

        scanner.close();
    }
}