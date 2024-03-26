package day01;

import java.util.Scanner;

public class Exam03 {
    //학생수를 입력하세요.   (입력받은 학생수에 해당하는..)
    //학생 5명의 점수를 입력받아서
    //모든 학생들의 점수를 출력하고,
    //전체 학생의 총점과 평균을 출력해 주세요.


    //main..
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("학생 수를 입력하세요.");
        int student = sc.nextInt();
        //System.out.println(student);

        int[] arr;
        arr = new int[student];

        for(int i = 0; i < student; i++){
            System.out.println("점수를 입력하세요.");
            int score = sc.nextInt();
            arr[i] = /*sc.nextInt();*/ score;
            System.out.println("score" + arr[i]);
        }

        int sum = 0;

        for(int j = 0; j < student; j++){
            sum += arr[j];
        }
//
        int average = sum / student;
        System.out.println("sum : " + sum + " " + "average : " + average);
    }

}
