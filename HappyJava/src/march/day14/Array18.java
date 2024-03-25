package march.day14;

import java.util.Arrays;

public class Array18 {
    public static void main(String[] args) {
        int[] array = {5,4,3,1,2};
        Arrays.sort(array);
        int i = Arrays.binarySearch(array, 4);
        System.out.println(i);
    }
}