package march.day14;

public class Array15 {
    public static void main(String[] args) {
        char[] copyFrom = {'h', 'e', 'l', 'l', 'o', '!'};
        char[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 1, 3);
        for (char c : copyTo) {
            System.out.println(c);
        }
    }
}