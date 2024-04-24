package march.day25;

//class 객체의 도면, 설계도, 붕어빵틀
public class HelloBaby {
    //기본구성요소
    //속성, 기능
    //필드 (멤버변수), 메소드
    String name;
    //접근제한자 리턴타입 메소드명(매개변수들... ){}
   public void say(String msg){
       System.out.println(msg);
   }

   public static void print(String msg){
       System.out.println(msg);
   }

    public static void main(String[] args) {
//        say("hello");
        print("하이");
    }
}
