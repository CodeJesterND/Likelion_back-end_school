package april.day01;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3,4,5,6,7,8};
        int[] newArray = new int[4]; // 새 요소를 추가하기 위해 크기가 1 더 큰 배열 생성

        System.arraycopy(originalArray, 3, newArray, 0, 4);
//        newArray[3] = 4; // 새로운 요소 추가

        System.out.println(Arrays.toString(originalArray));
        System.out.println(Arrays.toString(newArray));

        for(int i = 0; i < newArray.length; i++){
            System.out.println(newArray[i]);
        }

    }
}
