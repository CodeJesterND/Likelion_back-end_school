package march.day25;

public class Exam02 {
    /*정수1개과 문자 1개를 입력받아서 예를들어 3 과 * 을 입력 받았다면
    ***
    ***
    ***

    * 5, #

    #####
    #####
    #####
    #####
    #####
    *
    * 이렇게 출력 될 수 있도록 메서드를 만들어 주세요.
    */
    //접근제한자 리턴타입 메소드명 (매개변수들..){}
    public static void msgPrint(int count, String msg){
        for(int i = 0; i < count; i++){
            for(int j = 0; j < count; j++){
                System.out.print(msg);
            }
            System.out.println();
        }
    }
/*
3,*
*
**
***


***
**
*


 */
    public static void main(String[] args) {

        msgPrint(3,"*");
        msgPrint(5,"#");
    }
}
