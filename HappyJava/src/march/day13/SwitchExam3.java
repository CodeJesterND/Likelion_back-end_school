package march.day13;

public class SwitchExam3 {
    public static void main(String[] args) {
        char ch;
        //ch = 'a';
        //ch = 'b';
        //ch = 'c';
        //ch = 'd';
        //ch = 'A';
        //ch = 'B';
        //ch = 'C';
        ch = 'D';

        switch (ch) {
            case 'a':
            case 'A':
                System.out.println("A입니다.");
                break;
            case 'b':
            case 'B':
                System.out.println("B입니다.");
                break;
            case 'c':
            case 'C':
                System.out.println("C입니다.");
                break;
            default:
                System.out.println("A,B,C가 아닙니다.");
        }
    }
}