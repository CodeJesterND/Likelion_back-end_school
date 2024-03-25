package march.day13.ex;

import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("섭씨 온도를 입력하세요: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = celsius * 9 / 5 + 32;

        System.out.println("화씨 온도는 " + fahrenheit + "도 입니다.");

        scanner.close();
    }
}