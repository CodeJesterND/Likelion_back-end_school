package march.day13;

public class SwitchExam2 {
    public static void main(String[] args) {
        int num;
        //num = 1;
        //num = 2;
        //num = 3;
        num = 4;
        switch (num) {
            case 1:
                System.out.println("1.입니다.");
                break;
            case 2:
                System.out.println("2.입니다.");
            case 3:
                System.out.println("3.입니다.");
            default:
                System.out.println("1, 2, 3이 아닙니다.");
        }
    }
}