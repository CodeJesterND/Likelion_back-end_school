package march.day13.ex;

public class MultiplicationTable {
    public static void main(String[] args) {
        int dan = 2;

        while (dan <= 9) {
            int num = 1;
            while (num <= 9) {
                System.out.println(dan + " * " + num + " = " + (dan * num));
                num++;
            }
            dan++;
        }
    }
}