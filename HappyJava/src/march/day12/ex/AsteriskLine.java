package march.day12.ex;

public class AsteriskLine {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 5) {
            int s = 1;
            while (s <= i) {
                System.out.print("*");
                s++;
            }
            System.out.println();
            i++;
        }
    }
}