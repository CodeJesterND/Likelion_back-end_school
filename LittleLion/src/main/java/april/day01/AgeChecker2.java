package april.day01;

public class AgeChecker2 {
    //매개변수로 나이를 입력 받으면, 나이에 따라서 메시지를 출력하는 메서드
    //접근제한자 리턴타입 메서드명(매개변수...){}
    public static void checker(int age){
        if(age < 18)
            System.out.println("나는 미성년자입니다.");
        else
            System.out.println("나는 성인입니다.");
    }
}
