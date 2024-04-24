package april.day01;

public class MethodTest {

    public static void plus(int a, int b){
        int sum = a + b;
        System.out.println(sum);
    }
    public static void main(String[] args) {
        //값을 두개 더하는 코드를 생성해 보세요.
        int a = 10;
        int b = 20;

        plus(a,b);

//        int sum = a + b;
//
//        System.out.println(sum);

        a = 2;
        b = 5;

        plus(a,b);
//        sum = a + b;
//
//        System.out.println(sum);

        a = 7;
        b = 8;

        plus(a,b);
//        sum = a+b;

    }
}
