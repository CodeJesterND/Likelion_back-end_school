package march.day14;

public class Array14 {
    public static void main(String[] args) {
        int[] copyFrom = {1, 2, 3};
        int[] copyTo = java.util.Arrays.copyOf(copyFrom, copyFrom.length);
        for (int c : copyTo) {
            System.out.println(c);
        }
        System.out.println("----------------------------------");
        int[] copyTo2 = java.util.Arrays.copyOf(copyFrom, 5);
        for (int c : copyTo2) {
            System.out.println(c);
        }
    }
}