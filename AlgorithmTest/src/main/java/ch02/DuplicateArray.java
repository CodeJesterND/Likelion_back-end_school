package ch02;

import java.util.Arrays;

class DuplicateArray {

    public static void main(String[] args) {
        int[] original = {10, 20, 30, 40, 50};
        int[] copied = original.clone(); //copied는 original의 복제본을 참조

        copied[2] = 0; //copied 배열의 세 번째 요소를 0으로 변경

        System.out.println("original = " + Arrays.toString(original));
        System.out.println("copied = " + Arrays.toString(copied));
    }
}
