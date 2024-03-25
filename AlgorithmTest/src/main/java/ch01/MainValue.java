package ch01;

public class MainValue {
    //메소드
    //접근 제한자 리턴타입 메소드명 (매개변수들...){}
    public static int max(int a, int b, int c) {
        // 세 개의 정수 a, b, c 중 최대값을 구하여 반환하는 메소드
        int max = a; // 우선 a를 최대값으로 가정

        if (b > max) {
            max = b; //b가 현재까지의 최대값보다 크면, b를 최대값으로 갱신
        }

        if (c > max) {
            max = c; //c가 현재까지의 최대값보다 크면, c를 최대값으로 갱신
        }

        return max; // 최대값 반환
    }

    /*
    public static void main(String[] args) {

        //int a = 34;
        //int b = 78;
        //int c = 56;

        //max 메소드를 호출하여 세 값 중 최대값을 구하고 출력
        //int result = max(a, b, c);
        //System.out.println("최대값: " + result);

        System.out.println("최대값: " + max(34, 78, 56));
    }
     */
}